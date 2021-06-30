package com.checkin.web.dao;

import java.util.List;

import com.checkin.web.entity.Hashtag;

public interface HashtagMemberDao {
	Hashtag get(int id);
	List<Hashtag> getList();
	List<Hashtag> getList(String field, String query);
	
	int getCount(String field, String query);	
	int insert(Hashtag hashtag);
	int update(Hashtag hashtag);
	int delete(int id);
}
