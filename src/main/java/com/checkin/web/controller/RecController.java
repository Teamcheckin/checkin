package com.checkin.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.checkin.web.entity.BookStore;
import com.checkin.web.entity.Hashtag;
import com.checkin.web.entity.HashtagBookstore;
import com.checkin.web.entity.Member;
import com.checkin.web.service.HashtagBookstoreService;
import com.checkin.web.service.HashtagMemberService;
import com.checkin.web.service.HashtagService;
import com.checkin.web.service.RecService;


//추천탭 컨트롤러
@Controller
@RequestMapping("/rec/")
public class RecController {
	
	@Autowired
	private RecService service;
	
	@RequestMapping("main")
	public String main(Model model, HttpSession session) {

		List<Hashtag> hlist = service.getList();
		
		System.out.println(hlist);
		model.addAttribute("hlist",hlist);
		
		String h2="#술";
		String h3="#독서모임";
		
		//로그인한 사용자 id 얻어서 사용자가 고른 해시태그 얻어오기
		Member member = (Member)session.getAttribute("member");
		Integer memberId = 10;
		if(member!=null) {
			 memberId = member.getId();
		}
		//Integer[] hIdlist = service.getHashIdByMemberId(9);
//		System.out.println(hIdlist[0]);
//		System.out.println(hIdlist.length);
		
		List<Hashtag> memberHlist = service.getHashNamegByMemberId(memberId);
		System.out.println(memberHlist);
		System.out.println(memberHlist.get(0).getName());
		
		List<BookStore> hlist1 = service.getListHashtagBookstore(memberHlist.get(0).getName());
		model.addAttribute("hlist1",hlist1);
		model.addAttribute("hlist1Name",memberHlist.get(0).getName());
		
		if(memberHlist.size()>1) {
			h2 = memberHlist.get(1).getName();
		}
		
		List<BookStore> hlist2 = service.getListHashtagBookstore(h2);
		model.addAttribute("hlist2",hlist2);
		model.addAttribute("hlist2Name", h2);
		
		if(memberHlist.size()>2) {
			h3 = memberHlist.get(2).getName();
		}
		
		List<BookStore> hlist3 = service.getListHashtagBookstore(h3);
		model.addAttribute("hlist3",hlist3);
		model.addAttribute("hlist3Name",h3);
		return "rec/main";
	}
	
	
	
	
	
	
	
	@PostMapping("result")
	public String list(	Model model,	
						@RequestParam(name="q", required = false) String query, 
						@RequestParam(name="f", required = false) String field) {
		List<Hashtag> hlist = service.getList();
		
		model.addAttribute("hlist",hlist);
		
		
		if(field.equals("1")||query.equals("")) {
			//서점 검색
			System.out.println(query);
			System.out.println(field);
			
			List<BookStore> list = service.getListBooktStore(query, null);
			System.out.println(list);
			System.out.println(list.isEmpty());
			model.addAttribute("list",list);
			
		}else {
			//해시태그 검색
			System.out.println(query);
			System.out.println(field);
			
			List<BookStore> list = service.getListHashtagBookstore(query);
			System.out.println(list);
			
			model.addAttribute("list",list);
		}
			
		
		return "rec/result";
	}

	
	
}
