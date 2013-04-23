package io.loli.blog.huasan.dao;

import java.util.List;

import io.loli.blog.huasan.entity.Post;

public interface IPostDAO {
	public int save(Post post);

	public int update(Post post);

	public int delete(int id);

	public List<Post> listAll();

	public List<Post> list(int startIndex, int count);
	
	public Post findById(int id);
}
