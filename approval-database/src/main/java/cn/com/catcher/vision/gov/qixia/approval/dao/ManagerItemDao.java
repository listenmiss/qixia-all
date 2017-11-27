package cn.com.catcher.vision.gov.qixia.approval.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.com.catcher.vision.gov.qixia.approval.model.ManagerItem;

public interface ManagerItemDao {
	public List<ManagerItem> findManagerItemByItemId(@Param("itemId") int itemId);
}
