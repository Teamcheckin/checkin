package com.checkin.web.service;

import java.util.List;

import com.checkin.web.entity.BookStore;
import com.checkin.web.entity.Hashtag;
import com.checkin.web.entity.HashtagBookstore;

public interface RecService {
	
	List<Hashtag> getList();
	List<Hashtag> getList(String query);
	
	List<BookStore> getListBooktStore(String query); //해당 해시태그를 갖고 있는 서점 검색
	List<BookStore> getListHashtagBookstore(String query);
}
