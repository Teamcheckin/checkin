package com.checkin.web.service;

import java.util.List;

import com.checkin.web.entity.BookStore;
import com.checkin.web.entity.StampRoute;

public interface MapService {

	// 근처 서점 지도에 출력
	List<BookStore> getList();
	// 검색한 서점 지도에 출력
	List<BookStore> getBookstore(String bookstore);
	// 검색한 서점 세부정보 출력
	BookStore getBookstore(int id);
	// 내 지역구 스탬프 활동 출력
	List<StampRoute> getStamp(String gu);
}
