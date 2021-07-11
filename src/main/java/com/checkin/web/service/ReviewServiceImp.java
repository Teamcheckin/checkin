package com.checkin.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.checkin.web.dao.BookStoreDao;
import com.checkin.web.dao.GuDao;
import com.checkin.web.dao.HashtagDao;
import com.checkin.web.dao.RatingDao;
import com.checkin.web.dao.ReviewDao;
import com.checkin.web.entity.BookStore;
import com.checkin.web.entity.Gu;
import com.checkin.web.entity.Hashtag;
import com.checkin.web.entity.HashtagReview;
import com.checkin.web.entity.MyReviewView;
import com.checkin.web.entity.Rating;
import com.checkin.web.entity.RatingReview;
import com.checkin.web.entity.Review;
import com.checkin.web.entity.ReviewView;
import com.checkin.web.entity.ReviewView2;

@Service
public class ReviewServiceImp implements ReviewService {
	
	private ReviewDao reviewDao;
	private GuDao guDao;
	private BookStoreDao bookstoreDao;
	private HashtagDao hashtagDao;
	private RatingDao ratingDao;
	
	@Autowired
	public ReviewServiceImp(ReviewDao reviewDao, GuDao guDao, BookStoreDao bookstoreDao, 
							HashtagDao hashtagDao, RatingDao ratingDao) {
		
		this.reviewDao = reviewDao;
		this.guDao = guDao;
		this.bookstoreDao = bookstoreDao;
		this.hashtagDao = hashtagDao;
		this.ratingDao = ratingDao;
	}
	
	@Override
	public List<ReviewView2> getViewList() {
		
		List<ReviewView2> list = getViewList(null);
		return list;
	}

	@Override
	public List<ReviewView2> getViewList(String gu) {
		
		List<ReviewView2> list = reviewDao.getViewList(gu);
		return list;
	}
	
	@Override
	public List<ReviewView2> getBookStoreList(Integer bookstoreId) {
		
		List<ReviewView2> list = reviewDao.getBookStoreList(bookstoreId);

		return list;
	}
	
	@Override
	public List<MyReviewView> getMyReviewList(String gu, int memberId) {

		List<MyReviewView> list = reviewDao.getMyReviewList(gu, memberId);
		
		return list;
	}
	
	@Override
	public ReviewView2 get(int id) {

		ReviewView2 review = reviewDao.get(id);
		return review;
	}
	
	@Override
	public List<Gu> getGu() {
		
		List<Gu> list = guDao.getList();
		return list;
	}
	
	@Override
	public List<BookStore> getBookstore() {
		
		List<BookStore> list = bookstoreDao.getNameList();
		return list;
	}

	@Override
	public List<Hashtag> getHashtag() {
		
		List<Hashtag> list = hashtagDao.getList(null);
		return list;
	}

	@Override
	public List<Rating> getRating() {
		
		List<Rating> list = ratingDao.getList();
		return list;
	}

	@Override
	public int insert(
			Review review, 
			HashtagReview hreview, 
			RatingReview rreview) {

		return reviewDao.insert(review, hreview, rreview);
	}
	
	@Override
	public int update(
			Review review, 
			HashtagReview hreview, 
			RatingReview rreview) {
		
		return reviewDao.update(review, hreview, rreview);
	}
	
	@Override
	public int delete(int id) {
		return reviewDao.delete(id);
	}

	@Override
	public int likeToggle(int id) {
		return 0;
	}

}
