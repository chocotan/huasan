package io.loli.blog.huasan.controller;

import io.loli.blog.huasan.entity.Comment;
import io.loli.blog.huasan.service.CommentService;
import io.loli.util.mail.MailSenderInfo;
import io.loli.util.mail.SimpleMailSender;

import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.TreeMap;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/comment")
public class CommentController {
	@Autowired
	private CommentService commentService;

	@RequestMapping(value = { "add" }, method = RequestMethod.POST)
	public String add(@RequestParam int spam,
			@ModelAttribute final Comment comment, Model model,
			HttpSession session, HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {
		if (spam == 1 && !isspam(comment)) {
			comment.setPubDate(new Timestamp(new Date().getTime()));
			comment.setIp(request.getRemoteAddr());
			commentService.save(comment);
			Cookie cookie = new Cookie("JSESSIONID", session.getId());
			cookie.setDomain("../");
			cookie.setMaxAge(1000000);
			response.addCookie(cookie);
			session.setAttribute("nickname", comment.getUsername());
			session.setAttribute("email", comment.getEmail());
			session.setAttribute("website", comment.getWebsite());
			if (comment.getReply_id() != 0) {
				final Comment temp = commentService.findById(comment.getReply_id());
				new Thread() {
					@Override
					public void run() {
						send(temp);
					}
				}.start();
			}
			return "redirect:/post?id=" + comment.getP_id();
		} else {
			return "/error";
		}

	}

	public void send(Comment comment) {
		ResourceBundle rb = ResourceBundle
				.getBundle("io.loli.blog.huasan.prop.all");
		String username = rb.getString("email.username");
		String password = rb.getString("email.password");
		String title = rb.getString("email.title");
		String content = rb.getString("email.content");
		String blogurl = rb.getString("siteurl");
		String sendernickname = rb.getString("email.nickname");
		String suffix = rb.getString("email.suffix");
		String here = rb.getString("email.here");
		content = content + "<a href='" + blogurl + "/post?id="
				+ comment.getP_id() + "'>" + here + "</a>" + suffix;
		sendEmail(comment.getEmail(), title, content, username, password,
				sendernickname);
	}

	@RequestMapping(value = { "delete" }, method = RequestMethod.GET)
	public String delete(@RequestParam int id, @RequestParam int p_id,
			Model model) {
		commentService.delete(id);
		return "redirect:/post?id=" + p_id;
	}

	@RequestMapping(value = { "list" }, method = RequestMethod.GET)
	public String list(@RequestParam int p_id, Model model) {
		List<Comment> commentList = commentService.listByPostId(p_id);
		List<List<Comment>> result = new ArrayList<List<Comment>>();
		for (Comment comment : commentList) {
			if(!comment.getWebsite().contains("http://")){
				comment.setWebsite("http://"+comment.getWebsite());
			}
			if (comment.getReply_id() == 0) {
				result.add(sort(searchComment(comment, commentList)));
			}
		}
		Collections.reverse(result);
		model.addAttribute("commentListList", result);
		return "/comment/commentList";
	}

	// 递归将评论整理成列表
	private List<Comment> searchComment(Comment comment, List<Comment> totalList) {
		List<Comment> result = new ArrayList<Comment>();
		if (comment.getReply_id() == 0) {
			result.add(comment);
		}
		for (Comment single : totalList) {
			if (comment.getId() == single.getReply_id()) {
				result.add(single);
				result.addAll(searchComment(single, totalList));
			}
		}
		return result;
	}

	private List<Comment> sort(List<Comment> comments) {
		Map<Integer, Comment> map = new TreeMap<Integer, Comment>();
		for (Comment comment : comments) {
			map.put(comment.getId(), comment);
		}
		return new ArrayList<Comment>(map.values());
	}

	private boolean isspam(Comment comment) {
		if (comment.getContent().trim().equals("")
				|| comment.getUsername().trim().equals("")
				|| comment.getEmail().trim().equals("")
				|| comment.getWebsite().trim().equals("")) {
			return true;
		}
		if (comment.getContent().getBytes().length <= comment.getContent()
				.length()) {
			return true;
		}
		if (!comment
				.getEmail()
				.matches(
						"^[a-z0-9]+([._\\-]*[a-z0-9])*@([a-z0-9]+[-a-z0-9]*[a-z0-9]+.){1,63}[a-z0-9]+$")) {
			return true;
		}
		return false;
	}

	private static void sendEmail(String email, String title, String content,
			String adminemail, String adminpassword, String nickname) {
		MailSenderInfo mailInfo = new MailSenderInfo();
		mailInfo.setMailServerHost("smtp.gmail.com");
		mailInfo.setMailServerPort("465");
		mailInfo.setValidate(true);
		mailInfo.setUserName(adminemail);
		mailInfo.setPassword(adminpassword);// 您的邮箱密码
		mailInfo.setFromAddress(adminemail);
		mailInfo.setToAddress(email);
		// mailInfo.setSenderNickName("花伞菌");
		mailInfo.setSubject(title);
		mailInfo.setContent(content);
		mailInfo.setSenderNickName(nickname);
		// 这个类主要来发送邮件
		SimpleMailSender sms = new SimpleMailSender();
		sms.sendHtmlMail(mailInfo);// 发送html格式
	}
}
