package cn.com.catcher.vision.gov.qixia.stats.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.com.catcher.vision.gov.qixia.model.Departments;

public interface DepartmentsService {
	public String findAllDepartmentsByIds(String jdepIds);
	public String findAllDepartmentsMatterStatsToday(String jdepIds,int dateType,int state);
	int findDepartmentsMatterStatsCount(String jdepIds,int dateType,int state);
	String getDepartmentsMatterStatsCountInfo(String jdepIds,int state);
	
}
