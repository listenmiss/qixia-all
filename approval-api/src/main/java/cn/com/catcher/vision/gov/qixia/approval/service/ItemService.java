package cn.com.catcher.vision.gov.qixia.approval.service;

import org.apache.ibatis.annotations.Param;

import cn.com.catcher.vision.gov.qixia.approval.model.Item;

public interface ItemService {
	public Item findItemById( int id);
}
