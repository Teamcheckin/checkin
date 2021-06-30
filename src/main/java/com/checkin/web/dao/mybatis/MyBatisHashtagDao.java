package com.checkin.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.checkin.web.dao.HashtagDao;
import com.checkin.web.entity.Hashtag;

@Repository
public class MyBatisHashtagDao implements HashtagDao{

	private SqlSession sqlSession;
	private HashtagDao mapper;

	@Autowired
	public MyBatisHashtagDao(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
		mapper = sqlSession.getMapper(HashtagDao.class);
	}
	
	@Override
	public Hashtag get(int id) {
		// TODO Auto-generated method stub
		return mapper.get(id);
	}

	@Override
	public List<Hashtag> getList() {
		// TODO Auto-generated method stub
		return getList(null);
	}

	@Override
	public List<Hashtag> getList(String query) {
		// TODO Auto-generated method stub
		return mapper.getList(query);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mapper.getCount();
	}
	
	@Override
	public Hashtag getIdByName(String name) {
		return mapper.getIdByName(name);
	}

	@Override
<<<<<<< HEAD
	public int insert(String hashtag) {
=======
	public int insert(Hashtag hashtag) {
>>>>>>> branch 'main' of https://github.com/Teamcheckin/checkin.git
		// TODO Auto-generated method stub
		return mapper.insert(hashtag);
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return mapper.delete(id);
	}

}
