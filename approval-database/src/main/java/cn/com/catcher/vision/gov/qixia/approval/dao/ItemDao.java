package cn.com.catcher.vision.gov.qixia.approval.dao;

import org.apache.ibatis.annotations.Param;

import cn.com.catcher.vision.gov.qixia.approval.model.Item;

public interface ItemDao {
	
	 public Item findItemById(@Param("id") int id);
}
