package cn.com.catcher.vision.gov.qixia.stats.service;

public interface DepartmentsService {
	public String findAllDepartmentsByIds(String jdepIds);
	public String findAllDepartmentsMatterStatsToday(String jdepIds,int dateType,int state);
	int findDepartmentsMatterStatsCount(String jdepIds,int dateType,int state);
	String getDepartmentsMatterStatsCountInfo(String jdepIds,int state);
}
