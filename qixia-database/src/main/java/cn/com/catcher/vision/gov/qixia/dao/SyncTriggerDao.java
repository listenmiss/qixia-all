package cn.com.catcher.vision.gov.qixia.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.com.catcher.vision.gov.qixia.model.SyncTrigger;

public interface SyncTriggerDao {
	
    public SyncTrigger findSyncTriggerById(@Param("id") int id);
    
    int insertSyncTrigger(SyncTrigger syncTrigger);
    
    List<SyncTrigger> findAllSyncTrigger();
    
    void deleteSyncTriggerById(@Param("id") int id);
} 
