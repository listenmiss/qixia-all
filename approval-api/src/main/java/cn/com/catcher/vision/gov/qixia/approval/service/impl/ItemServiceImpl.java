package cn.com.catcher.vision.gov.qixia.approval.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.catcher.vision.gov.qixia.approval.dao.ItemDao;
import cn.com.catcher.vision.gov.qixia.approval.model.Item;
import cn.com.catcher.vision.gov.qixia.approval.service.ItemService;

@Service("itemService")
public class ItemServiceImpl implements ItemService{
	private static final Logger logger = LoggerFactory.getLogger(ItemServiceImpl.class);
	@Autowired
    ItemDao itemDao;

	@Override
	public Item findItemById(int id) {
		logger.info("findItemById:" + id);
        return this.itemDao.findItemById(id);
	}
	
}
