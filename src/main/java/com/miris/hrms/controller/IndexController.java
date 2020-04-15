package com.miris.hrms.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.miris.hrms.service.com.Com0101Service;
import com.miris.hrms.service.com.vo.ManagerVO;

@Controller
public class IndexController {
	@RequestMapping("/index.do")
	public String index() {
		return "common/login";
	}
	
	@Resource
	private Com0101Service com0101Service;
	
	@RequestMapping("/login.do")
	public String login(HttpServletRequest req, Model model, ManagerVO manager) throws Exception {
		String message;
		if(com0101Service.userLoginIn(manager)) {
			message = "로그인 성공";
		} else {
			message = "로그인 실패";
		}
		
		model.addAttribute("message", message);
		
		return "/";
		
	}
	
	
}
