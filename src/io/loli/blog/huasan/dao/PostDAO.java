package io.loli.blog.huasan.dao;

import java.util.List;

import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import io.loli.blog.huasan.entity.Post;

@Repository
public class PostDAO extends BaseDaoSupport implements IPostDAO {

	@Override
	public int save(Post post) {
		String sql = "insert into post(title,content,commentCount,pubDate,author_name,author_email) values(?,?,?,?,?,?)";
		return this.getJdbcTemplate().update(sql, post.getTitle(),
				post.getContent(), post.getCommentCount(),
				post.getPubDate(),post.getAuthor_name(),post.getAuthor_email());
	}

	@Override
	public int update(Post post) {
		String sql = "update post set title=?,content=?,commentCount=? where id=?";
		return this.getJdbcTemplate().update(sql, post.getTitle(),
				post.getContent(),post.getCommentCount(), post.getId());
	}

	@Override
	public int delete(int id) {
		String sql = "update post set deleted=true where id=?";
		return this.getJdbcTemplate().update(sql, id);
	}

	@Override
	public List<Post> listAll() {
		String sql = "select * from post where deleted=false";
		return this.getJdbcTemplate().query(sql,
				ParameterizedBeanPropertyRowMapper.newInstance(Post.class));
	}

	@Override
	public List<Post> list(int startIndex, int count) {
		String sql = "select * from post where deleted=false order by id desc limit ?,?";
		return this.getJdbcTemplate().query(sql,
				ParameterizedBeanPropertyRowMapper.newInstance(Post.class),
				startIndex, count);
	}

	@Override
	public Post findById(int id) {
		String sql ="select * from post where id=? order by id desc ";
		return this.getJdbcTemplate().queryForObject(sql, ParameterizedBeanPropertyRowMapper
				.newInstance(Post.class),id);
	}

}
