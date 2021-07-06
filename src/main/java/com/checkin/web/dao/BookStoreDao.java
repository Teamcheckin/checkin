package com.checkin.web.dao;

import java.util.List;

import com.checkin.web.entity.BookStore;


public interface BookStoreDao {
	BookStore get(int id);
	List<BookStore> getList();
	List<BookStore> getList(String query, String gu);
	List<BookStore> getNameList();
	public List<BookStore> getGu(String gu);
	
	int getCount();	
	int insert(BookStore bookStore);
	int update(BookStore bookStore);
	int delete(int id);
	

}
