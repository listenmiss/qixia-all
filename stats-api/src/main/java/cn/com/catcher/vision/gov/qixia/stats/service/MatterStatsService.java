package cn.com.catcher.vision.gov.qixia.stats.service;

public interface MatterStatsService {

	String findLastMatterStats( int count);
	String getMatterStatsCountByGroup(int state,String groupIds);
}
