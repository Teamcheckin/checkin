package com.checkin.web.controller.admin;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.checkin.web.entity.BookStore;
import com.checkin.web.entity.Gu;
import com.checkin.web.entity.Hashtag;
import com.checkin.web.entity.HashtagBookstore;
import com.checkin.web.service.BookStoreService;
import com.checkin.web.service.GuService;
import com.checkin.web.service.HashtagBookstoreService;
import com.checkin.web.service.HashtagService;

@Controller("bookEdit")
public class BookInsertController {
	private BookStoreService service;
	private HashtagService hashService;
	private GuService guService;
	
	@Autowired
	public BookInsertController(BookStoreService service, HashtagService hashService, GuService guService) {
		this.service = service;
		this.hashService = hashService;
		this.guService = guService;
	}
	
	@RequestMapping("/bookstore/insert")
	public String BookInsertPage(Model model) {
		List<Hashtag> hashList = hashService.getList();
		List<Gu> guList = guService.getList();
		Integer hashCount = hashService.getCount();
		model.addAttribute("hashList", hashList);
		model.addAttribute("guList", guList);
		model.addAttribute("hashCount", hashCount);
		
		return "admin/bookstoreInsert";
	}
	
	@PostMapping("/bookstore/insert")
	public String BookinsertPost(
				HttpServletRequest request
				,@RequestParam(name="bg-img", required=false) MultipartFile bgImg
				,@RequestParam(name="logo-img", required=false) MultipartFile logoImg
				,BookStore bookstore
				,Integer hashId) {
		
		// 배경 이미지 저장
		if(bgImg != null) {
			String path ="/upload/bookstore";
			String bgName = bgImg.getOriginalFilename();
			System.out.println(bgName);
			
			
			ServletContext application = request.getServletContext();
			String uploadPath = application.getRealPath(path);
			
			try {
				String filePath = uploadPath + File.separator + bgName;
				System.out.println(filePath);
				File saveFile = new File(filePath);
				bgImg.transferTo(saveFile);
				bookstore.setBgImg(path + '/' + bgName);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		//로고 이미지 저장
		if(logoImg != null) {
			String path ="/images/logoImg";
			String logoName = bgImg.getOriginalFilename();
			System.out.println(logoName);
			
			ServletContext application = request.getServletContext();
			String uploadPath = application.getRealPath(path);
	
			try {
				String filePath = uploadPath + File.separator + logoName;
				System.out.println(filePath);
				File saveFile = new File(filePath);
				logoImg.transferTo(saveFile);
				bookstore.setLogoImg(path + '/' + logoName);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		HashtagBookstore hashBookstore = new HashtagBookstore();
		hashBookstore.setHashtagId(hashId);

		
		if(bookstore.getName() == null)
			return "redirect:/bookstore/insert?error";
		
		System.out.println(bookstore);
		service.insert(bookstore, hashBookstore);
			
		return "redirect:/index";
	}
	
	
	@RequestMapping("addressPopup")
	public String addressPopup() {
		
		return "admin/addressPopup";
	}
	
}
