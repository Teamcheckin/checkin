package com.checkin.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.checkin.web.entity.Hashtag;
import com.checkin.web.entity.Member;
import com.checkin.web.service.BookStoreService;
import com.checkin.web.service.BookmarkService;
import com.checkin.web.service.HashtagMemberService;
import com.checkin.web.service.HashtagService;
import com.checkin.web.service.ReviewService;

@Controller("Dash")
public class DashController {
	private BookStoreService storeService;
	private BookmarkService service;
	private ReviewService reviewService;
	private HashtagMemberService hashmemService;
	private HashtagService hashService;
	
	@Autowired
	public DashController(BookStoreService storeService, BookmarkService service, ReviewService reviewService, 
							HashtagService hashService, HashtagMemberService hashmemService) {
		this.storeService = storeService;
		this.service = service;
		this.reviewService = reviewService;
		this.hashmemService = hashmemService;
		this.hashService = hashService;
	}
	
	
	@RequestMapping("/mypage/dashboard")
	public String dashboard(final HttpSession session, Model model){
		  Member member = (Member) session.getAttribute("member");
		  Integer memberId = member.getId();
		  model.addAttribute("member", member);
			
				
			// --- Hash, 나의 Hash, Hash count ---
			Integer[] hashId = hashmemService.getList(memberId);
			List<Hashtag> hashList = new ArrayList<>();
			for (int eachId : hashId) {
				Hashtag eachHash = hashService.get(eachId);
				hashList.add(eachHash);
			}
			List<Hashtag> list= hashService.getList();
			Integer hashCount = hashService.getCount();
			Integer myHashCount = hashmemService.getCount(memberId);
			
			model.addAttribute("hashList", list);
			model.addAttribute("hashCount", hashCount);
			model.addAttribute("myHashCount", myHashCount);
			model.addAttribute("myHashList", hashList);
			
			return "mypage/dashmember";
			
	}
	
	@RequestMapping("/mypage/dashboard/update")
	public String hashUpdate(final HttpSession session, Model model, Integer[] hashId){
		 Member member = (Member) session.getAttribute("member");
		 Integer memberId = member.getId();
		 for(Integer id : hashId) {
			 
			 boolean hashTrue= hashmemService.hashCheck(id, memberId);
			 if(!hashTrue) {
				 hashmemService.insert(id, memberId);
			 }
			 
			 Integer[] myHash = hashmemService.getList(memberId);
			 for(Integer hash: myHash)
				 if(hash == id) {
					 return null;
				 } else {
					 hashmemService.delete(hash, memberId);
				 }
		 }
			 
		 
		return "mypage/dashmember";
	}
	

	
}
