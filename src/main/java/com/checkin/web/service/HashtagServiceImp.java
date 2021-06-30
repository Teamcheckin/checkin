package com.checkin.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.checkin.web.dao.HashtagDao;
import com.checkin.web.entity.Hashtag;

@Service
public class HashtagServiceImp implements HashtagService {

	@Autowired
	private HashtagDao dao;

	@Override
	public List<Hashtag> getList() {
		List<Hashtag> list = getList(null);
		return list;
	}

	@Override
	public List<Hashtag> getList(String query) {
		List<Hashtag> list = dao.getList(query);
		return list;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return dao.getCount();
	}

	@Override
	public int insert(String hashtag) {
		// TODO Auto-generated method stub
		return dao.insert(hashtag);
	}

	@Override
	public int delete(int id) {
		return dao.delete(id);
	}


	@Override
	public Hashtag getIdByName(String name) {
		return dao.getIdByName(name);
	}

	@Override
	public Hashtag get(int id) {
		return dao.get(id);
	}
	


}
