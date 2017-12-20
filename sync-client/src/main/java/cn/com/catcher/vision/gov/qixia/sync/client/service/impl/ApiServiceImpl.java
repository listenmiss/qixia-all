package cn.com.catcher.vision.gov.qixia.sync.client.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.catcher.vision.gov.qixia.config.MultipleDataSource;
import cn.com.catcher.vision.gov.qixia.dao.ManagerDao;
import cn.com.catcher.vision.gov.qixia.dao.ManagerItemDao;
import cn.com.catcher.vision.gov.qixia.dao.MatterDao;
import cn.com.catcher.vision.gov.qixia.dao.MatterStatsDao;
import cn.com.catcher.vision.gov.qixia.dao.SyncTriggerDao;
import cn.com.catcher.vision.gov.qixia.dao.UserDao;
import cn.com.catcher.vision.gov.qixia.model.Manager;
import cn.com.catcher.vision.gov.qixia.model.ManagerItem;
import cn.com.catcher.vision.gov.qixia.model.Matter;
import cn.com.catcher.vision.gov.qixia.model.MatterStats;
import cn.com.catcher.vision.gov.qixia.model.SyncTrigger;
import cn.com.catcher.vision.gov.qixia.model.User;
import cn.com.catcher.vision.gov.qixia.sync.client.service.ApiService;

@Service("apiService")
public class ApiServiceImpl implements ApiService{
	private static final Logger logger = LoggerFactory.getLogger(ApiServiceImpl.class);
	
	@Autowired
	MatterStatsDao matterStatsDao;
	
	@Autowired
	UserDao userDao;
	
	
	@Autowired
	ManagerDao managerDao;
	
	@Autowired
	ManagerItemDao managerItemDao;

	@Autowired
	MatterDao matterDao;
	
	@Autowired
	SyncTriggerDao syncTriggerDao;
	
	@Override
	public MatterStats findMatterStatsById(String idStr) {
//		"50457"
		long id = Long.valueOf(idStr).longValue();
    	MatterStats matterStats = matterStatsDao.findMatterStatsById(id);
    	
    	

    	long id2 = Long.valueOf("56714").longValue();
    	matterStats.setIdx(id2);
    	MultipleDataSource.setDataSourceKey("dataSource2");
    	int r = matterStatsDao.insertMatterStats(matterStats);
    	return matterStats;
	}
	
	@Override
	public int insertMatterStats(MatterStats matterStats) {
//
    	int r = matterStatsDao.insertMatterStats(matterStats);
    	return r;
	}

	@Override
	public String t2() {
		User user = userDao.findUserById(2354);
		
		user.setId(2513);
		MultipleDataSource.setDataSourceKey("dataSource2");
    	int r = userDao.insertUser(user);
		
		return "123";
	}
	
	@Override
	public String t3() {
		Manager manager = managerDao.findManagerById(175);
		
		manager.setNo(185);
		MultipleDataSource.setDataSourceKey("dataSource2");
    	int r = managerDao.insertManager(manager);
		
		return "123";
	}
	
	
	@Override
	public String t4() {
		ManagerItem manager = managerItemDao.findManagerItemById(1185);
		
		manager.setNo(19866);
		MultipleDataSource.setDataSourceKey("dataSource2");
    	int r = managerItemDao.insertManagerItem(manager);
		
		return "123";
	}
	
	
	@Override
	public String t5( ) {
//		"50457"
		long id = Long.valueOf("50457").longValue();
		Matter matterStats = matterDao.findMatterById(id);
    	
    	

    	long id2 = Long.valueOf("56715").longValue();
    	matterStats.setIdx(id2);
    	MultipleDataSource.setDataSourceKey("dataSource2");
    	int r = matterDao.insertMatter(matterStats);
    	return "123";
	}
	
	
	@Override
	public String t6() {
		List<SyncTrigger> syncTriggerList = syncTriggerDao.findAllSyncTrigger();
		
		
    	 syncTriggerDao.deleteSyncTriggerById(8);
		
		return "123";
	}

	@Override
	public void syncDatas() {
		
		logger.info("##SyncDatasJob##" );
		
		MultipleDataSource.setDataSourceKey("dataSource");
		List<SyncTrigger> syncTriggerList = syncTriggerDao.findAllSyncTrigger();
		if(syncTriggerList!=null && syncTriggerList.size()>0)
		{
			for(int i=0;i<syncTriggerList.size();i++)
			{
				SyncTrigger syncTrigger = syncTriggerList.get(i);
				
				int id = syncTrigger.getId();
				String sync_name = syncTrigger.getSync_name();
				String sync_key = syncTrigger.getSync_key();
				
				delSyncTrigger(id);
				switch(sync_name) 
				{ 
				case "approvel_manager": 
					syncManager(sync_key); 
				 break; 
				case "approvel_manageritem": 
					syncManageritem(sync_key); 
				   break;  
				case "approvel_matter": 
					syncMatter(sync_key); 
					   break; 
				case "approvel_matter_stats": 
					syncMatterStats(sync_key); 
					   break; 
				default: 
					syncUser(sync_key); 
				   break; 

				} 
				
			}
		}
	}
	
	
	
	 
	 private void delSyncTrigger(int id)
	 {
		
		 syncTriggerDao.deleteSyncTriggerById(id);
	 }
	 
	 
	 private void syncManageritem(String sync_key)
	 {
		 
		    int key = Integer.valueOf(sync_key);
		    MultipleDataSource.setDataSourceKey("dataSource");
			ManagerItem manager = managerItemDao.findManagerItemById(key);
			
			MultipleDataSource.setDataSourceKey("dataSource2");
	        managerItemDao.insertManagerItem(manager);
	 }
	 private void syncManager(String sync_key)
	 {
		     int key = Integer.valueOf(sync_key);
		     MultipleDataSource.setDataSourceKey("dataSource");
			 Manager manager = managerDao.findManagerById(key);

			 MultipleDataSource.setDataSourceKey("dataSource2");
	    	 managerDao.insertManager(manager);
	 }
	 
	 private void syncMatter(String sync_key)
	 {
			long id = Long.valueOf(sync_key).longValue();
			 MultipleDataSource.setDataSourceKey("dataSource");
			Matter matterStats = matterDao.findMatterById(id);
	    	
	    	MultipleDataSource.setDataSourceKey("dataSource2");
	    	matterDao.insertMatter(matterStats);
	    	
	 }
	 
	 private void syncMatterStats(String sync_key)
	 {
		     long id = Long.valueOf(sync_key).longValue();
		    MultipleDataSource.setDataSourceKey("dataSource");
	    	MatterStats matterStats = matterStatsDao.findMatterStatsById(id);
	    	
	    	MultipleDataSource.setDataSourceKey("dataSource2");
	    	matterStatsDao.insertMatterStats(matterStats);
	 } 
	 
	 private void syncUser(String sync_key)
	 {
		    int key = Integer.valueOf(sync_key);
		    MultipleDataSource.setDataSourceKey("dataSource");
			User user = userDao.findUserById(key);
			
			MultipleDataSource.setDataSourceKey("dataSource2");
	    	userDao.insertUser(user);
	 } 
	 
	 
}
