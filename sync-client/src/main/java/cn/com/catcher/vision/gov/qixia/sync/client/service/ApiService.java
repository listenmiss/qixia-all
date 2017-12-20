package cn.com.catcher.vision.gov.qixia.sync.client.service;

import cn.com.catcher.vision.gov.qixia.model.MatterStats;

public interface ApiService {

	MatterStats findMatterStatsById(String idStr);
	public int insertMatterStats(MatterStats matterStats);
	
	
	public String t2();
	public String t3();
	public String t4();
	
	public String t5();
	
	public String t6();
	
	
	public void syncDatas();
}
