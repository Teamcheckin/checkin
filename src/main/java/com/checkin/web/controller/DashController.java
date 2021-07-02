package com.checkin.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.checkin.web.entity.Member;
import com.checkin.web.service.BookStoreService;
import com.checkin.web.service.BookmarkService;
import com.checkin.web.service.ReviewService;

@Controller("Dash")
public class DashController {
	private BookStoreService storeService;
	private BookmarkService service;
	private ReviewService reviewService;
	
	@Autowired
	public DashController(BookStoreService storeService, BookmarkService service, ReviewService reviewService) {
		this.storeService = storeService;
		this.service = service;
		this.reviewService = reviewService;
	}
	
	
	@RequestMapping("/mypage/dashboard")
	public String mypage(final HttpSession session, Model model){
		  Member member = (Member) session.getAttribute("member");
		  System.out.println(member);
			
			
			if(member.getPositionId() == 2) {
				model.addAttribute("member", member);
				return "mypage/dashbook";
				
			} else {
				model.addAttribute("member", member);
				return "mypage/dashmember";
			}
	}
	
	
}
