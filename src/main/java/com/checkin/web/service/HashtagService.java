package com.checkin.web.service;

import java.util.List;

import com.checkin.web.entity.Hashtag;

public interface HashtagService {
	Hashtag get(int id);
	Hashtag getIdByName(String name);
	List<Hashtag> getList();
	List<Hashtag> getList(String query);
	
	int getCount();	//해시태그 총 개수
<<<<<<< HEAD
	int insert(String hashtag); //해시태그 추가
=======
	int insert(Hashtag hashtag); //해시태그 추가
>>>>>>> branch 'main' of https://github.com/Teamcheckin/checkin.git
	int delete(int id); //해시태그 삭제
}
