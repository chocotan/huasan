package io.loli.blog.huasan.controller;

import io.loli.blog.huasan.service.PostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/feed")
public class RssController {
	@Autowired
	PostService postService;
	@RequestMapping(method = RequestMethod.GET)
	public String rss(Model model){
		model.addAttribute("posts", postService.list(0, 20));
		return "rss";
	}
}