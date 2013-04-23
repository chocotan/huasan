package io.loli.blog.huasan.dao;

import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import io.loli.blog.huasan.entity.Admin;

@Repository
public class AdminDAO extends BaseDaoSupport implements IAdminDAO {
	
	@Override
	public int save(Admin admin) {
		String sql = "insert into admin(name,password,email) values(?,?,?)";
		return this.getJdbcTemplate().update(sql, admin.getName(),
				admin.getPassword(), admin.getEmail());
	}

	@Override
	public int update(Admin admin) {
		String sql = "update admin set name=?,password=?,email=?";
		return this.getJdbcTemplate().update(sql, admin.getName(),
				admin.getPassword(), admin.getEmail());
	}

	@Override
	public Admin findByName(String name) {
		String sql = "select * from admin where name=?";
		return this.getJdbcTemplate().queryForObject(sql,
				ParameterizedBeanPropertyRowMapper.newInstance(Admin.class),
				name);
	}

	@Override
	public Admin findById(int id) {
		String sql = "select * from admin where id=?";
		return this.getJdbcTemplate()
				.queryForObject(
						sql,
						ParameterizedBeanPropertyRowMapper
								.newInstance(Admin.class), id);
	}

}
