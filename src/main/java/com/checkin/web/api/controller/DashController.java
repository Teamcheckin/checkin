package com.checkin.web.api.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.checkin.web.entity.Member;
import com.checkin.web.service.HashtagMemberService;

@RestController("apiDashController")
public class DashController {

	@Autowired
	private HashtagMemberService hashmemService;
	
	@RequestMapping("/api/hashUpdate")
	public String hashUpdate(@RequestParam(value="selected[]")List<String> selected,  final HttpSession session, Model model){
		 Member member = (Member) session.getAttribute("member");
		 Integer memberId = member.getId();

		 System.out.println(selected);
		 for(String stringId :selected) {
			 Integer id = Integer.parseInt(stringId);
			 System.out.println(id);
			 boolean hashTrue= hashmemService.hashCheck(id, memberId);
			 if(!hashTrue) {
				 System.out.println("없는 것:" + id);
			 // 내 해시목록에 없으면, 삽입
				 hashmemService.insert(id, memberId);
			 } else {
				 System.out.println("있는 것:" + id);
//			// 내 해시목록에 있는 애가 새 해시 목록에 없으면, 삭제
			 Integer[] myHash = hashmemService.getList(memberId);
			 System.out.println(myHash);
			 boolean areyouthere= Arrays.asList(myHash).contains(id);
			 if(!areyouthere)
				 System.out.println(id+"야, 너 거기 없니?");
				 hashmemService.delete(id, memberId);
			 }
		  }
			 
		String ok = "ok";
		return ok;
	}
}
