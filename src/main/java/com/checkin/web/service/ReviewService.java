package com.checkin.web.service;

import java.util.List;

import com.checkin.web.entity.BookStore;
import com.checkin.web.entity.Gu;
import com.checkin.web.entity.Hashtag;
import com.checkin.web.entity.HashtagReview;
import com.checkin.web.entity.Rating;
import com.checkin.web.entity.RatingReview;
import com.checkin.web.entity.Review;
import com.checkin.web.entity.ReviewView;
import com.checkin.web.entity.ReviewView2;

public interface ReviewService {

	List<ReviewView2> getViewList();
	List<ReviewView2> getViewList(String gu); 
	List<ReviewView2> getBookStoreList(Integer bookstoreId);
	ReviewView2 get(int id);
	List<Gu> getGu();
	List<BookStore> getBookstore();
	List<Hashtag> getHashtag();
	List<Rating> getRating();
	
	int insert(Review review, HashtagReview hreview, RatingReview rreview);
	int update(Review review, HashtagReview hreview, RatingReview rreview);
	int delete(int id);
	int likeToggle(int id);
}
