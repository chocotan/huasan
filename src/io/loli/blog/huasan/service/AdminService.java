package io.loli.blog.huasan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.loli.blog.huasan.dao.AdminDAO;
import io.loli.blog.huasan.entity.Admin;
@Service
public class AdminService {
	@Autowired
	private AdminDAO adminDAO;

	public int save(Admin admin) {
		return adminDAO.save(admin);
	}

	public int update(Admin admin) {
		return adminDAO.update(admin);
	}

	public Admin findByName(String name) {
		return adminDAO.findByName(name);
	}

	public Admin findById(int id) {
		return adminDAO.findById(id);
	}

	public void setAdminDAO(AdminDAO adminDAO) {
		this.adminDAO = adminDAO;
	}

	public AdminDAO getAdminDAO() {
		return adminDAO;
	}

}
