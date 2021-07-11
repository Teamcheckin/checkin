package com.checkin.web.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.checkin.web.entity.BookStore;
import com.checkin.web.entity.BookStoreView;
import com.checkin.web.entity.Member;
import com.checkin.web.entity.ReviewView2;
import com.checkin.web.service.BookStoreService;
import com.checkin.web.service.BookmarkService;
import com.checkin.web.service.ReviewService;

@Controller
@RequestMapping("/bookstore/")
public class BookStoreController {

	@Autowired
	private BookStoreService service;
	
	@Autowired
	private BookmarkService bookmarkService;
	
	@Autowired
	private ReviewService reviewService;
	
	@GetMapping("detail/{id}")
	public String detail(
			@PathVariable int id, Model model, HttpSession session) {
		
		Member member = (Member)session.getAttribute("member");
		int memberId = member.getId();
		
		if(member != null) {
			if(member.getPositionId() != '1')
				model.addAttribute("member", null);
			model.addAttribute("member", member);
		} else {
			model.addAttribute("member", null);
		}
		
		BookStoreView bookstore = service.getView(id);
		List<ReviewView2> review = reviewService.getBookStoreList(id);
		Integer hasBookmark = bookmarkService.getBookmark(id, memberId);
		
		model.addAttribute("bookstore", bookstore);
		model.addAttribute("review", review);
		model.addAttribute("bookmark", hasBookmark);
		
		return "bookstore/detail";
	}
	
	@PostMapping("detail/location")
	public String detailLocation(
					@RequestParam(required=false) Double latitude,
					@RequestParam(required=false) Double longitude,
					@RequestParam(name="bookstoreId") Integer id,
					Model model, RedirectAttributes re) {
		
		BookStore bookstore = service.get(id);
		List<ReviewView2> review = reviewService.getBookStoreList(id);
		bookstore.setLatitude(latitude);
		bookstore.setLongitude(longitude);
		service.update(bookstore);
		System.out.println(bookstore);
		BookStoreView bookstoreView = service.getView(id);
		
	
		re.addAttribute("id", id);
		model.addAttribute(null, bookstoreView);
		model.addAttribute("bookstore", bookstoreView);
		model.addAttribute("review", review);
		
		return "redirect:/bookstore/detail/{id}";
	}
}
