package com.checkin.web.api.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.checkin.web.service.MemberService;

@RestController("apiMemberController")
public class MemberController {

	@Autowired
	private MemberService service;
	
	@RequestMapping("/api/member/{nickname}")
	public boolean nickTrue(@PathVariable("nickname") String nickname){
		boolean nicktrue = service.nickTrue(nickname);

		return nicktrue;
	}
}
