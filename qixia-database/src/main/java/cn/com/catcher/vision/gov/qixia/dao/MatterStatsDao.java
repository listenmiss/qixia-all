package cn.com.catcher.vision.gov.qixia.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.com.catcher.vision.gov.qixia.model.MatterStats;

public interface MatterStatsDao {
	public MatterStats findMatterStatsById(@Param("id") Long id);
	
	public List<MatterStats> findLastMatterStats(@Param("count") int count);
	
	
	int findMatterStatsCountByGroup(Map<String, Object> map);
}
