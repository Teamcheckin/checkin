package com.checkin.web.service;

import java.util.Date;
import java.util.List;

import com.checkin.web.entity.StampView;
import com.checkin.web.entity.MyStore;

public interface BookmarkService {
	Integer[] getStoreList(Integer id);
	Integer getStoreCount(Integer storeId);
	Integer getMyCount(Integer memberId);	

	Integer addStore(MyStore myStore);
	Integer delStore(Integer storeId);
	
	
	String get(Integer bookstoreId, Integer memberId);
	Integer getStampCount(Integer memberId);
	Integer getStampAdminCount(Integer bookstoreId);
	Integer insert(Integer bookestoreId, Integer memberId);
	

}