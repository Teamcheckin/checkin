package com.checkin.web.dao.mybatis;

import java.util.Date;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.checkin.web.dao.StampViewDao;
import com.checkin.web.entity.StampView;

@Repository
public class MyBatisStampViewDao implements StampViewDao {

	private SqlSession sqlSession;
	private StampViewDao mapper;
	
	@Autowired
	public MyBatisStampViewDao(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
		mapper = sqlSession.getMapper(StampViewDao.class);
	}
	
	@Override
	public Date get(Integer bookstoreId, Integer memberId) {
		
		return mapper.get(bookstoreId, memberId);
	}
	
	@Override
	public Integer getStampCount(Integer memberId) {
		
		return mapper.getStampCount(memberId);
	}
	
	@Override
	public Integer getStampAdminCount(Integer bookstoreId) {

		return mapper.getStampAdminCount(bookstoreId);
	}

	@Override
	public Integer insert(Integer bookestoreId, Integer memberId) {

		return mapper.insert(bookestoreId, memberId);
	}


}
