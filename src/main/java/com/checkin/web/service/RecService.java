package com.checkin.web.service;

import java.util.List;

import com.checkin.web.entity.BookStore;
import com.checkin.web.entity.Hashtag;
import com.checkin.web.entity.HashtagBookstore;

public interface RecService {
	List<Hashtag> getList();
	List<Hashtag> getList(String query);
	
	List<BookStore> getListBooktStore(String query, String gu); //해당 해시태그를 갖고 있는 서점 검색
	List<BookStore> getListHashtagBookstore(String query);
	
	//Integer[] getHashIdByMemberId(int id); //멤버id로 해시태그 id 얻어오기
	List<Hashtag> getHashNamegByMemberId(int id); //해시태그 id로 해시태그 이름 얻어오기
}
