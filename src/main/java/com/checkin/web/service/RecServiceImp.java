package com.checkin.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.checkin.web.dao.BookStoreDao;
import com.checkin.web.dao.HashtagBookstoreDao;
import com.checkin.web.dao.HashtagDao;
import com.checkin.web.dao.HashtagMemberDao;
import com.checkin.web.entity.BookStore;
import com.checkin.web.entity.Hashtag;
import com.checkin.web.entity.HashtagBookstore;

@Service
public class RecServiceImp implements RecService{

	private HashtagDao dao;
	private BookStoreDao bookstoredao;
	private HashtagBookstoreDao hashtagbookstoredao;
	private HashtagMemberDao hashtagMemberdao;
	
	@Autowired
	public RecServiceImp(HashtagDao dao, BookStoreDao bookstoredao,
			HashtagBookstoreDao hashtagbookstoredao, HashtagMemberDao hashtagMemberdao) {
		this.dao = dao;
		this.bookstoredao = bookstoredao;
		this.hashtagbookstoredao = hashtagbookstoredao;
		this.hashtagMemberdao = hashtagMemberdao;
	}
	
	@Override
	public List<Hashtag> getList() {
		List<Hashtag> list = getList(null);
		return list;
	}

	@Override
	public List<Hashtag> getList(String query) {
		return dao.getList(query);
	}

	@Override
	public List<BookStore> getListBooktStore(String query, String gu) {
		return bookstoredao.getList(query, null);
	}

	@Override
	public List<BookStore> getListHashtagBookstore(String query) {
		
		return hashtagbookstoredao.getList(query);
	}

	@Override
	public Integer[] getHashIdByMemberId(int id) {
		return hashtagMemberdao.getList(id);
	}

}
