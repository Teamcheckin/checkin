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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	
	@RequestMapping("admin/bookstore/insert")
	public String BookInsertPage(Model model) {
		List<Hashtag> hashList = hashService.getList();
		List<Gu> guList = guService.getList();
		Integer hashCount = hashService.getCount();
		model.addAttribute("hashList", hashList);
		model.addAttribute("guList", guList);
		model.addAttribute("hashCount", hashCount);
		
		return "admin/bookstoreInsert";
	}
	
	@PostMapping("admin/bookstore/insert")
	public String BookinsertPost(
				HttpServletRequest request
				,@RequestParam(required=false) MultipartFile file1
				,@RequestParam(required=false) MultipartFile file2
				,BookStore bookstore, Integer hashId, Model model,
				RedirectAttributes re) {
		System.out.println(file1);
		System.out.println(file2);
		// 배경 이미지 저장
		if(file1 != null) {
			String path ="/images/bgImg";
			String bgName = file1.getOriginalFilename();

			
			
			ServletContext application = request.getServletContext();
			String uploadPath = application.getRealPath(path);
			
			try {
				String filePath = uploadPath + File.separator + bgName;

				File saveFile = new File(filePath);
				file1.transferTo(saveFile);
				bookstore.setBgImg(path + '/' + bgName);
				System.out.println(bookstore.getBgImg());
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("배경업로드에러발생");
			}
		}
		
		//로고 이미지 저장
		if(file2 != null) {
			String path ="/images/logoImg";
			String logoName = file2.getOriginalFilename();
			
			ServletContext application = request.getServletContext();
			String uploadPath = application.getRealPath(path);
	
			try {
				String filePath = uploadPath + File.separator + logoName;
				File saveFile = new File(filePath);
				file2.transferTo(saveFile);
				bookstore.setLogoImg(path + '/' + logoName);
				System.out.println(bookstore.getLogoImg());
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("로고업로드에러발생");
			}
		}
		
		HashtagBookstore hashBookstore = new HashtagBookstore();
		hashBookstore.setHashtagId(hashId);


		System.out.println(bookstore);
		service.insert(bookstore, hashBookstore);
		
		BookStore modelBookstore = service.getBookstore(bookstore.getName());

		re.addAttribute("id", modelBookstore.getId());
		model.addAttribute("bookstore", modelBookstore);
		return "redirect:/bookstore/detail/{id}";
	}

}
