package com.checkin.web.dao.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.checkin.web.dao.BookStoreDao;
import com.checkin.web.dao.HashtagReviewDao;
import com.checkin.web.entity.HashtagReview;

@Repository
public class MyBatisHashtagReviewDao implements HashtagReviewDao{

	private HashtagReviewDao mapper;
	
	public MyBatisHashtagReviewDao(SqlSession sqlSession) {
		mapper = sqlSession.getMapper(HashtagReviewDao.class);
	}
	
	
	@Override
	public HashtagReview get(int id) {
		// TODO Auto-generated method stub
		return mapper.get(id);
	}

	@Override
	public int insert(int hashtagId, int reviewId) {
		// TODO Auto-generated method stub
		return mapper.insert(hashtagId, reviewId);
	}

	@Override
	public int update(int hashtagId) {
		// TODO Auto-generated method stub
		return mapper.update(hashtagId);
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return mapper.delete(id);
	}

}
