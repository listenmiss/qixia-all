package cn.com.catcher.vision.gov.qixia.approval.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.com.catcher.vision.gov.qixia.approval.model.MatterStats;

public interface MatterStatsService {
	public List<MatterStats> findMatterStatsByInsertStart( int insert_start);
}
