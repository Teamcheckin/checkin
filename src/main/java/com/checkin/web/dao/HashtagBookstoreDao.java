package com.checkin.web.dao;

import java.util.List;

import com.checkin.web.entity.BookStore;

public interface HashtagBookstoreDao {
	List<BookStore> getList(String query);
	int insert(int hashtagId, int bookstoreId);
	int delete(int hashtagId, int bookstoreId);
}
