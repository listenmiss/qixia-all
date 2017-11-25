package cn.com.catcher.vision.gov.qixia.approval.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.com.catcher.vision.gov.qixia.approval.model.MatterStats;

public interface MatterStatsDao {
	
	 public List<MatterStats> findMatterStatsByInsertStart(@Param("insert_start") int insert_start);
}
