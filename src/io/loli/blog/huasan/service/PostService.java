package io.loli.blog.huasan.service;

import java.util.List;

import io.loli.blog.huasan.dao.PostDAO;
import io.loli.blog.huasan.entity.Post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {
	@Autowired
	private PostDAO postDAO;

	public int save(Post post) {
		return postDAO.save(post);
	}

	public int update(Post post) {
		return postDAO.update(post);
	}

	public int delete(int id) {
		return postDAO.delete(id);
	}

	public List<Post> listAll() {
		return postDAO.listAll();
	}

	public List<Post> list(int startIndex, int count) {
		return postDAO.list(startIndex, count);
	}
	
	public Post findById(int id){
		return postDAO.findById(id);
	}

	public PostDAO getPostDAO() {
		return postDAO;
	}

	public void setPostDAO(PostDAO postDAO) {
		this.postDAO = postDAO;
	}
}
