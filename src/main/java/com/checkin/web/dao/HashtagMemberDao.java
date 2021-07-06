package com.checkin.web.dao;

import java.util.List;

public interface HashtagMemberDao {
	Integer hashCheck(Integer hashtagId, Integer memberId);
	Integer getCount(Integer memberId);
	Integer[] getList(Integer memberId);
	Integer insert(Integer hasgtagId, Integer memberId);
	Integer delete(Integer hashtagId, Integer memberId);
}
