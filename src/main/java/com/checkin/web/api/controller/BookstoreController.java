package com.checkin.web.api.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.checkin.web.entity.BookStore;
import com.checkin.web.entity.Hashtag;
import com.checkin.web.service.BookStoreService;


@RestController("apiBookstoreController")
@RequestMapping("/api/bookstore/")
public class BookstoreController {

	@Autowired
	private BookStoreService bookstoreService;
	
	@RequestMapping("list")
	public Map<String, Object> list(Model model){
		
		List<BookStore> list = bookstoreService.getList();
		
		Map<String, Object> map = new HashMap<>();
		map.put("list", list);
		
		return map;
	}
}
