package com.checkin.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.checkin.web.dao.BookStoreDao;
import com.checkin.web.entity.BookStore;

@Service
public class BookStoreServiceImp implements BookStoreService {
	
	@Autowired
	private BookStoreDao dao;
	
	@Override
	public BookStore get(int id) {
		 
		return dao.get(id);
	}
	
	@Override
	public BookStore getBookstore(String name) {

		return dao.getBookstore(name);
	}

	@Override
	public List<BookStore> getList() {
		 
		return dao.getList();
	}

	@Override
	public List<BookStore> getList(String query, String gu) {
		 
		return dao.getList(query, gu);
	}

	@Override
	public int getCount() {
		 
		return dao.getCount();
	}

	@Override
	public int insert(BookStore bookStore) {
		 
		return dao.insert(bookStore);
	}

	@Override
	public int update(BookStore bookStore) {
		 
		return dao.update(bookStore);
	}

	@Override
	public int delete(int id) {
		 
		return dao.delete(id);
	}

	@Override
	public List<BookStore> getGu(String gu) {
		
		return dao.getGu(gu);
	}

}
