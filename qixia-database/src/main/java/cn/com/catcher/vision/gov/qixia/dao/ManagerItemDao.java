package cn.com.catcher.vision.gov.qixia.dao;

import org.apache.ibatis.annotations.Param;

import cn.com.catcher.vision.gov.qixia.model.ManagerItem;

public interface ManagerItemDao {
    public ManagerItem findManagerItemById(@Param("id") int id);
    
    int insertManagerItem(ManagerItem manager);
}
