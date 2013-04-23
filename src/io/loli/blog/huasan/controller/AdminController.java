package io.loli.blog.huasan.controller;

import javax.servlet.http.HttpSession;

import io.loli.blog.huasan.entity.Admin;
import io.loli.blog.huasan.service.AdminService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdminController {
	@Autowired
	private AdminService adminService;
	
	@RequestMapping(value={"/admin/login"},method=RequestMethod.GET)
	public String setupForm(Model model){
		Admin admin = new Admin();
		model.addAttribute("admin",admin);
		return "/admin/login";
	}
	
	@RequestMapping(value={"/admin/login"},method=RequestMethod.POST)
	public String submitForm(@ModelAttribute("admin") Admin admin,Model model,HttpSession session){
		Admin trueAdmin= adminService.findByName(admin.getName());
		if(admin.getPassword().equals(trueAdmin.getPassword())){
			admin = trueAdmin;
			session.setAttribute("admin", admin);
			return "redirect:/post/add";
		}
		return "/admin/login";
	}
}
