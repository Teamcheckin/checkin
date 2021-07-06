package com.checkin.web.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.checkin.web.entity.BookStore;
import com.checkin.web.entity.Gu;
import com.checkin.web.entity.Hashtag;
import com.checkin.web.entity.HashtagReview;
import com.checkin.web.entity.Rating;
import com.checkin.web.entity.RatingReview;
import com.checkin.web.entity.Review;
import com.checkin.web.entity.ReviewView;
import com.checkin.web.entity.ReviewView2;
import com.checkin.web.service.ReviewService;

@Controller
@RequestMapping("/review/")
public class ReviewController {
	
	@Autowired
	private ReviewService service;
	
	@GetMapping("list")
	public String list(String gu, Model model) {
		
		List<ReviewView2> list = service.getViewList(gu);
		model.addAttribute("list", list);
		model.addAttribute("selectedGu", gu);
		
		List<Gu> guList = service.getGu();
		model.addAttribute("guList", guList);
		
		return "review/list";
		//return "review.list";
	}
	
	@GetMapping("reg")
	public String reg(Model model) {
		
		List<BookStore> bookstoreList = service.getBookstore();
		model.addAttribute("bList", bookstoreList);
		
		List<Hashtag> hashtagList = service.getHashtag();
		model.addAttribute("hList", hashtagList);
		
		List<Rating> ratingList = service.getRating();
		model.addAttribute("rList", ratingList);
		
		return "review/reg";
	}
	
	@PostMapping("reg")
	public String reg(
			Integer bookstore,
			Integer hashtag,
			String content, 
			Integer rating,
			Integer member_id,
			@RequestParam("image") MultipartFile multipartFile) throws IOException {
		
		Review review = new Review();
		
		// 이미지 업로드
		String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
		String uploadDir = "./upload/review/";
		Path uploadPath = Paths.get(uploadDir);
        
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }
        
		if(fileName != null && !fileName.equals("")) {
			try (InputStream inputStream = multipartFile.getInputStream()) {
				Path filePath = uploadPath.resolve(fileName);
				
				Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
			} catch (IOException ioe) {        
				throw new IOException("이미지를 저장할 수 없습니다: " + fileName, ioe);
			}      		
			
			review.setImg(fileName);
		}
         
        HashtagReview hreview = new HashtagReview();
        RatingReview rreview = new RatingReview();
        
        review.setBookstoreId(bookstore);
        review.setContent(content);
        review.setMemberId(1);
        hreview.setHashtagId(hashtag);
		rreview.setRatingId(rating);

		service.insert(review, hreview, rreview);
		
		return "redirect:list";
	}
	
	@GetMapping("edit")
	public String edit(Model model, int id) {
		
		ReviewView2 review = service.get(id);
		model.addAttribute("review", review);
		
		List<BookStore> bookstoreList = service.getBookstore();
		model.addAttribute("bList", bookstoreList);
		
		List<Hashtag> hashtagList = service.getHashtag();
		model.addAttribute("hList", hashtagList);
		
		List<Rating> ratingList = service.getRating();
		model.addAttribute("rList", ratingList);
		
		return "review/edit";
	}
	
	@PostMapping("edit")
	public String edit(Review review, 
						HashtagReview hreview,
						RatingReview rreview,
			@RequestParam("image") MultipartFile multipartFile) throws IOException {
		
		// 이미지 업로드
		String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
				
		String uploadDir = "./upload/review/";
		
		Path uploadPath = Paths.get(uploadDir);
        
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }
         

        if(fileName != null && !fileName.equals("")) {
        	try (InputStream inputStream = multipartFile.getInputStream()) {
        		Path filePath = uploadPath.resolve(fileName);
        		System.out.println(filePath.toFile().getAbsolutePath());
        		
        		Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
        	} catch (IOException ioe) {        
        		throw new IOException("이미지를 저장할 수 없습니다: " + fileName, ioe);
        	}    
        	
        	review.setImg(fileName);
        }
        
		
		service.update(review, hreview, rreview);
		
		return "redirect:list";
	}
	
	@RequestMapping("del")
	public String del(int id) {
		
		service.delete(id);
		
		return "redirect:list";
	}
	

}
