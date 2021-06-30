package com.checkin.web.dao;

import java.util.List;

import com.checkin.web.entity.Hashtag;


public interface HashtagDao {
	Hashtag getIdByName(String name);
	Hashtag get(int id);
	List<Hashtag> getList();
	List<Hashtag> getList(String query); //해시태그 검색 -> 해시태그 여러개 선택했을 때 나오게 하는거 생각중
	
	int getCount();	//해시태그 총 개수
<<<<<<< HEAD
	int insert(String hashtag); //해시태그 추가
=======
	int insert(Hashtag hashtag); //해시태그 추가
>>>>>>> branch 'main' of https://github.com/Teamcheckin/checkin.git
	int delete(int id); //해시태그 삭제

	
}
