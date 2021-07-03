package com.checkin.web.controller.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.checkin.web.entity.Hashtag;
import com.checkin.web.service.HashtagService;

@Controller
@RequestMapping("/admin/hash/")
public class HashtagController {
	
	@Autowired
	private HashtagService service;
	//@RequestParam(name:q) String query
	//초기페이지와 검색했을 때의 페이지는 컨트로러 작성을 어떻게?
	
	
	@RequestMapping("list")
	public String list(Model model){
		
		List<Hashtag> list = service.getList(null);
		model.addAttribute("list",list);
		
		return "admin/hashtag";
	}
	
	
	
	@PostMapping("result")
	public String result(Model model,
			@RequestParam(name="q" , required = false) String query,
			HttpServletResponse response) throws IOException{
		try {
			System.out.println(query);
			List<Hashtag> list = service.getList(query);
			model.addAttribute("list",list);
		} catch (Exception e) {
		
		}
		
		return "admin/hashtag";
	}
	
	
	
	
	
	@PostMapping("reg")
	public String reg(Model model, 
			@RequestParam(name="q" , required = false) String hashtag) {
		
		int result=0;
		try {
			
			result = service.insert(hashtag);
			System.out.println(result);
			
		} catch (Exception e) { //result = 0;
			
			System.out.println(result);
			model.addAttribute("result",result);
			
		}
		
		//model.addAttribute("result",result);
		
		
		return "redirect:list";
			
	}

	
//등록 기능은 컨트롤러를 어떻게 해야 되지?
	
	@RequestMapping("delete")
	public String del(int id) {
		service.delete(id);
		return "redirect:list";
	}
	
}
