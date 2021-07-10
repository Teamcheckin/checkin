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
		
		//로그인한 사용자 id 얻어서 사용자가 고른 해시태그 얻어오기
//		Member member = (Member)session.getAttribute("member");
//		Integer memberId = member.getId();
		//Integer[] hIdlist = service.getHashIdByMemberId(9);
//		System.out.println(hIdlist[0]);
//		System.out.println(hIdlist.length);
		
		
		List<Hashtag> memberHlist = service.getHashNamegByMemberId(9);
		System.out.println(memberHlist);
		

		List<BookStore> hlist1 = service.getListHashtagBookstore("#고양이");
		model.addAttribute("hlist1",hlist1);
		
		List<BookStore> hlist2 = service.getListHashtagBookstore("#큐레이터");
		model.addAttribute("hlist2",hlist2);
		
		List<BookStore> hlist3 = service.getListHashtagBookstore("#영화");
		model.addAttribute("hlist3",hlist3);
		
		
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
