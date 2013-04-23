package io.loli.blog.huasan.dao;

import io.loli.blog.huasan.entity.Admin;

public interface IAdminDAO {
	public int save(Admin admin);

	public int update(Admin admin);

	public Admin findByName(String name);

	public Admin findById(int id);
}
