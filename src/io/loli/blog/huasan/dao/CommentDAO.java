package io.loli.blog.huasan.dao;

import java.util.List;

import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import io.loli.blog.huasan.entity.Comment;

@Repository
public class CommentDAO extends BaseDaoSupport implements ICommentDAO {

	@Override
	public int save(Comment comment) {
		String sql = "insert into comment (username,content,email,website,ip,pubDate,reply_id,p_id) values (?,?,?,?,?,?,?,?)";
		return this.getJdbcTemplate().update(sql, comment.getUsername(),comment.getContent(),
				comment.getEmail(), comment.getWebsite(), comment.getIp(),
				comment.getPubDate(), comment.getReply_id(), comment.getP_id());
	}

	@Override
	public int delete(int id) {
		String sql = "delete from comment where id=?";
		return this.getJdbcTemplate().update(sql, id);
	}

	@Override
	public List<Comment> listByPostId(int p_id) {
		String sql = "select * from comment where p_id=?";
		return this.getJdbcTemplate().query(sql,
				ParameterizedBeanPropertyRowMapper.newInstance(Comment.class),
				p_id);
	}

	@Override
	public Comment findById(int id) {
		String sql = "select * from comment where id=?";
		return this.getJdbcTemplate().queryForObject(sql, ParameterizedBeanPropertyRowMapper
				.newInstance(Comment.class),id);
	}
	
	
}
