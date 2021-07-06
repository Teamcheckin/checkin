package com.checkin.web.service;

import java.util.List;

import com.checkin.web.entity.BookStore;

public interface BookStoreService {
	
	BookStore get(int id);
	BookStore getBookstore(String name);
	List<BookStore> getList();
	List<BookStore> getList(String query, String gu);
	
	List<BookStore> getGu(String gu);
	
//	int MasterReg(int id);
	int getCount();	
	int insert(BookStore bookStore, Integer hashId);
	int update(BookStore bookStore);
	int delete(int id);
	
}
