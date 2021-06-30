package com.checkin.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.checkin.web.dao.BookStoreDao;
import com.checkin.web.dao.StampRouteDao;
import com.checkin.web.entity.BookStore;
import com.checkin.web.entity.StampRoute;

@Service
public class MapServiceImp implements MapService {
	
	private BookStoreDao bookstoreDao;
	private StampRouteDao stamprouteDao;
	
	@Autowired
	public MapServiceImp(BookStoreDao bookstoreDao,
						StampRouteDao stamprouteDao) {
		
		this.bookstoreDao = bookstoreDao;
		this.stamprouteDao = stamprouteDao;
	}

	@Override
	public List<BookStore> getList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BookStore> getBookstore(String bookstore) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BookStore getBookstore(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StampRoute> getStamp(String gu) {
		// TODO Auto-generated method stub
		return null;
	}

}
