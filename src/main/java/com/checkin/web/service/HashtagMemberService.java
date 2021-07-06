package com.checkin.web.service;

public interface HashtagMemberService {
	boolean hashCheck(Integer hashtagId, Integer memberId);
	Integer getCount(Integer memberId);
	Integer[] getList(Integer memberId);
	Integer insert(Integer hasgtagId, Integer memberId);
	Integer delete(Integer hashtagId, Integer memberId);
}
