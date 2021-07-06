package com.checkin.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.checkin.web.entity.BookStore;
import com.checkin.web.entity.Gu;
import com.checkin.web.entity.Member;
import com.checkin.web.service.BookStoreService;
import com.checkin.web.service.BookmarkService;
import com.checkin.web.service.GuService;

@Controller
public class BookmarkController {
	private BookmarkService service;
	private BookStoreService bookService;
	private GuService guService;
	
	@Autowired
	public BookmarkController(BookmarkService service, BookStoreService bookService, GuService guService) {
		this.service = service;
		this.bookService = bookService;
		this.guService = guService;
	}
	

	@RequestMapping("/mypage/bookmark")
	public String bookmark(HttpSession session, 
							Model model) {
		Member member = (Member)session.getAttribute("member");
		int id = member.getId();
		System.out.println(id);
		
		/*--내 서점 불러오기--*/
		Integer[] storeId= service.getStoreList(id);
		
		/*--서점이 있으면 서점 카운트, 서점 정보 불러오기--*/
		if(storeId != null) {
			int count = service.getMyCount(id);
			List<BookStore> bookstore = new ArrayList<>();
			
			/*--서점 정보 담기--*/
			for(int eachId : storeId) {
				BookStore eachBookstore = bookService.get(eachId);
				bookstore.add(eachBookstore);
			}
			
			
			System.out.println(bookstore);
			System.out.println(count);
			
			model.addAttribute("bookstore", bookstore);
			model.addAttribute("count", count);
		}
		
		return "mypage/bookmark";
	}
	
	@RequestMapping("/mypage/stamp")
	public String stamp(HttpSession session,
							Model model,
							@RequestParam(required=false)String gu) {
		Member member = (Member)session.getAttribute("member");
		int id = member.getId();
		
		
		/*--구 이름 불러오기--*/
		List<Gu> guList = guService.getList();
		
		/*--내가 찍은 스탬프 수, 전체 스탬프 수 불러오기--*/
		int count= service.getStampCount(id);
		int entireCount = service.getStampCount(null);
		
		Map<Integer, String> date = new HashMap<>();
		/*--구 네임에 해당하는 서점 정보--*/
		List<BookStore> bookstore= bookService.getList();
		for(BookStore book : bookstore) {
			 int bookId = book.getId();
			 String dateString = service.get(bookId, id);
			 date.put(bookId, dateString);
		}
		System.out.println(date);
			model.addAttribute("guName", guList);
			model.addAttribute("selectedGu", gu);
			model.addAttribute("count", count);
			model.addAttribute("entireCount", entireCount);
			model.addAttribute("bookstore", bookstore);
			model.addAttribute("date", date);
			
		return "mypage/stamp";
	}
	

}
