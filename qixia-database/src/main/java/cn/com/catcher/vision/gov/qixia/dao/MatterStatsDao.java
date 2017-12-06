package cn.com.catcher.vision.gov.qixia.dao;

import org.apache.ibatis.annotations.Param;

import cn.com.catcher.vision.gov.qixia.model.MatterStats;

public interface MatterStatsDao {
	public MatterStats findMatterStatsById(@Param("id") Long id);
}
