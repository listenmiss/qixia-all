package cn.com.catcher.vision.gov.qixia.dao;

import org.apache.ibatis.annotations.Param;

import cn.com.catcher.vision.gov.qixia.model.Manager;

public interface ManagerDao {
    public Manager findManagerById(@Param("id") int id);
    
    int insertManager(Manager manager);
}
