package io.loli.blog.huasan.controller;

import io.loli.blog.huasan.entity.Admin;
import io.loli.blog.huasan.entity.Comment;
import io.loli.blog.huasan.entity.Post;
import io.loli.blog.huasan.service.AdminService;
import io.loli.blog.huasan.service.PostService;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/post")
public class PostController {
	@Autowired
	private PostService postService;
	@Autowired
	private AdminService adminService;
	
	@RequestMapping(value = { "add" }, method = RequestMethod.GET)
	public String setupAddForm(Model model) {
		Post post = new Post();
		model.addAttribute("post", post);
		return "/post/add";
	}
	
	@RequestMapping(value = { "add" }, method = RequestMethod.POST)
	public String submitAddForm(@ModelAttribute("post") Post post, Model model,
			HttpSession session) {
		post.setAuthor_name(((Admin) session.getAttribute("admin")).getName());
		post.setAuthor_email(((Admin) session.getAttribute("admin")).getEmail());
		post.setPubDate(new Date());
		postService.save(post);
		return "redirect:/index";
	}
	
	@RequestMapping(value = { "edit" }, method = RequestMethod.GET)
	public String setupEditForm(@RequestParam("id") int id, Model model) {
		model.addAttribute("post", postService.findById(id));
		return "post/edit";
	}
	
	@RequestMapping(value = { "edit" }, method = RequestMethod.POST)
	public String submitEditForm(@ModelAttribute("post") Post post, Model model) {
		postService.update(post);
		return "/index";
	}

	@RequestMapping(value = { "list" }, method = RequestMethod.GET)
	public String list(@RequestParam("page") int page, Model model) {
		if (page == 0)
			page = 1;
		List<Post> postList = postService.list((page - 1) * 10, 10);
		for(Post p:postList){
			if(p.getContent().contains("\n"))
				p.setContent(p.getContent().replaceAll("\n", "<br/>"));
			if(p.getContent().contains("<!--readmore")){
				p.setContent(p.getContent().substring(0,p.getContent().indexOf("<!--readmore")));
			}
		}
		model.addAttribute("postList", postList);
		boolean hasLast = page>1?(postService.list((page-2)*10,10).size()==0?false:true):false;
		boolean hasNext = postService.list(page*10, 10).size()==0?false:true;
		model.addAttribute("hasLast",hasLast);
		model.addAttribute("hasNext",hasNext);
		return "/post/list";
	}

	@RequestMapping(method = RequestMethod.GET)
	public String post(@RequestParam("id") int id, Model model) {
		Post post = postService.findById(id);
		post.setContent(post.getContent().replaceAll("\n", "<br/>"));
		model.addAttribute("post", post);
		Comment comment = new Comment();
		comment.setP_id(post.getId());
		model.addAttribute("comment",comment);
		return "/post/post";
	}
	
	@RequestMapping(value={"delete"},method = RequestMethod.GET)
	public String delete(@RequestParam("id") int id, Model model) {
		postService.delete(id);
		return "/index";
	}

	public PostService getPostService() {
		return postService;
	}

	public void setPostService(PostService postService) {
		this.postService = postService;
	}

	public AdminService getAdminService() {
		return adminService;
	}

	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}
}
