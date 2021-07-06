package com.checkin.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.checkin.web.entity.BookStore;
import com.checkin.web.service.MapService;

@Controller
@RequestMapping("/map")
public class MapController {
	
	@Autowired
	private MapService service;
	
	@GetMapping("")
	public String main(String bookstore/* , Model model */) {
		
		List<BookStore> list = service.getBookstore(bookstore);
		
		return "map/main";
	}
	
}
