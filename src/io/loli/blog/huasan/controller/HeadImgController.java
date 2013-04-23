package io.loli.blog.huasan.controller;

import io.loli.util.MD5Util;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HeadImgController {
	@RequestMapping(value={"/headimg"},method=RequestMethod.GET)
	public String hash(@RequestParam("email") String email ,Model model){
		model.addAttribute("email",MD5Util.hash(email).toLowerCase());
		return "/headimg";
	}
}
