package io.loli.blog.huasan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.loli.blog.huasan.dao.CommentDAO;
import io.loli.blog.huasan.entity.Comment;
import io.loli.blog.huasan.entity.Post;

@Service
public class CommentService {
	@Autowired
	private CommentDAO commentDAO;
	@Autowired
	private PostService postService;

	public int save(Comment comment) {
		Post post = postService.findById(comment.getP_id());
		post.setCommentCount(post.getCommentCount()+1);
		postService.update(post);
		return commentDAO.save(comment);
	}

	public int delete(int id) {
		Post post = postService.findById(this.findById(id).getP_id());
		post.setCommentCount(post.getCommentCount()-1);
		postService.update(post);
		return commentDAO.delete(id);
	}

	public List<Comment> listByPostId(int p_id) {
		return commentDAO.listByPostId(p_id);
	}
	
	public Comment findById(int id){
		return commentDAO.findById(id);
	}

	public CommentDAO getCommentDAO() {
		return commentDAO;
	}

	public void setCommentDAO(CommentDAO commentDAO) {
		this.commentDAO = commentDAO;
	}
}
