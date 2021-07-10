package com.checkin.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.checkin.web.entity.BookStoreView;
import com.checkin.web.entity.ReviewView2;
import com.checkin.web.service.BookStoreService;
import com.checkin.web.service.ReviewService;

@Controller
@RequestMapping("/bookstore/")
public class BookStoreController {

	@Autowired
	private BookStoreService service;
	
	@Autowired
	private ReviewService reviewService;
	
	@GetMapping("detail")
	public String detail(int id, Model model) {
		
		BookStoreView bookstore = service.getView(id);
		List<ReviewView2> review = reviewService.getBookStoreList(id);
		
		model.addAttribute("bookstore", bookstore);
		model.addAttribute("review", review);
		
		return "bookstore/detail";
	}
	
}
