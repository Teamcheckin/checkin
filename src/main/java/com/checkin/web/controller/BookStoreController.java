package com.checkin.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.checkin.web.entity.BookStore;
import com.checkin.web.service.BookStoreService;

@Controller
@RequestMapping("/bookstore/")
public class BookStoreController {

	@Autowired
	private BookStoreService service;
	
	
	@GetMapping("detail")
	public String detail(int id, Model model) {
		
		BookStore bookstore = service.get(id);
		
		model.addAttribute("bookstore", bookstore);
		
		return "bookstore/detail";
	}
	
}
