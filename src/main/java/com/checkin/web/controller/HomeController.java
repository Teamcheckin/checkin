package com.checkin.web.controller;

import java.text.ParseException;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.checkin.web.entity.BookStoreView;
import com.checkin.web.entity.Member;
import com.checkin.web.entity.ReviewView2;
import com.checkin.web.entity.StampList;
import com.checkin.web.service.BookStoreService;
import com.checkin.web.service.BookmarkService;
import com.checkin.web.service.ReviewService;

@Controller
public class HomeController {
	private BookStoreService service;
	private BookmarkService stampService;
	private ReviewService reviewService;
	
	@Autowired
	public HomeController(BookStoreService service, BookmarkService stampService, ReviewService reviewService) {
		this.service = service;
		this.stampService = stampService;
		this.reviewService = reviewService;
	}
	
	@RequestMapping("/index")
	public String index(Model model) {
		// 이 서점은 어떠세요?
		Integer[] bookStoreArray = service.getBookstoreIdArray();
		System.out.println(bookStoreArray);
		//Integer[] id = shuffle(bookStoreArray);
		BookStoreView bookstore= service.getView(bookStoreArray[0]);
		System.out.println(bookstore);
		model.addAttribute("b", bookstore);
		
		// 사람들이 스탬프를 찍고 있어요
		List<StampList> stampList = stampService.getStampList();
		model.addAttribute("stamp", stampList);
		
		// 최근 리뷰
		List<ReviewView2> review = reviewService.getViewList();
		model.addAttribute("review", review);
		
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
	
	static Integer[] shuffle(Integer[] bookStoreArray) {
		int r1, r2;
		int temp;
		for (int i = 0; i < bookStoreArray.length; i++) {
			//for문이 돌아갈때마다 바뀌는 난수 r1, r2생성
			r1 = (int) (Math.random()*9);
			r2 = (int) (Math.random()*9);
			//변수에 배열 r1번의 값을 담기 -> swap용
			temp = bookStoreArray[r1];
			//r1번째 값을 r2번째 값으로 바꿔주기
			bookStoreArray[r1] = bookStoreArray[r2];
			//r2번째 값에 swap용변수(r1)번 값 담아주기 
			bookStoreArray[r2] = temp;
		}
		return bookStoreArray;
	}
}
