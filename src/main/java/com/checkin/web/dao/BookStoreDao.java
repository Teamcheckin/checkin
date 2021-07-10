package com.checkin.web.dao;

import java.util.List;

import com.checkin.web.entity.BookStore;
import com.checkin.web.entity.BookStoreView;

public interface BookStoreDao {
	
	BookStore get(int id);
	BookStoreView getView(int id);
	BookStore getBookstore(String name);
	List<BookStore> getList();
	List<BookStore> getList(String query, String gu);
	List<BookStore> getNameList();
	public List<BookStore> getGu(String gu);
	
	int getCount();	
	int insert(BookStore bookStore);
	int update(BookStore bookStore);
	int delete(int id);
	

}
