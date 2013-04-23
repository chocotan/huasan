package io.loli.blog.huasan.dao;

import java.util.List;

import io.loli.blog.huasan.entity.Comment;

public interface ICommentDAO {
	public int save(Comment comment);

	public int delete(int id);

	public List<Comment> listByPostId(int p_id);
	
	public Comment findById(int id);
}
