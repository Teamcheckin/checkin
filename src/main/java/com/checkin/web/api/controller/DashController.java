package com.checkin.web.api.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.checkin.web.entity.Member;
import com.checkin.web.service.HashtagMemberService;

@RestController("apiDashController")
public class DashController {

	@Autowired
	private HashtagMemberService hashmemService;
	
	@RequestMapping("/api/hashUpdate")
	public String hashUpdate(@RequestBody String selectArray, final HttpSession session, Model model){
		 Member member = (Member) session.getAttribute("member");
		 Integer memberId = member.getId();

		 System.out.println(selectArray);
//		 Object object = selected.get("selected");
//		 int length =(int) selected.get("length");
//	
//		 
//		System.out.println(object);
//		System.out.println(length);
		// object[] array to string[] #1
//		 String[] stringArray = Arrays.copyOf(object, length, String[].class);
//		 System.out.println(Arrays.toString(stringArray));
		 
		// object[] array to string[] #2
//	     String[] stringArray = Arrays.asList(object).toArray(new String[length]);
             // .toArray(new String[objectArray.length]);
//	     System.out.println(Arrays.toString(stringArray));
		 
		 
//		 for() {
//			 Integer id = (Integer)value;
//			 boolean hashTrue= hashmemService.hashCheck(id, memberId);
//			 if(!hashTrue) {
//			 // 내 해시목록에 없으면, 삽입
//				 hashmemService.insert(id, memberId);
//			 } else {
//			// 내 해시목록에 있는 애가 새 해시 목록에 없으면, 삭제
//			 Integer[] myHash = hashmemService.getList(memberId);
//			 boolean areyouthere= Arrays.asList(myHash).contains(id);
//			 if(!areyouthere)
//				 hashmemService.delete(id, memberId);
//			 }
//	}
			 
		String result = "ok";
		return result;
	}
}
