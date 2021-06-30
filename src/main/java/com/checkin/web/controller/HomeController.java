package com.checkin.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.checkin.web.entity.Member;

@Controller
public class HomeController {
	

	@RequestMapping("/index")
	public String login() {
		
		return "index";
	}
	
	
	@RequestMapping("/header")
	public String header(HttpSession session, Model model) {

			Member member = (Member)session.getAttribute("member");
			if(member != null) {
				model.addAttribute("member", member);
			} else {
				model.addAttribute("member", null);
			}
		return "inc/header";
	}
}
