package cn.com.catcher.vision.gov.qixia.stats.service;

import java.util.List;

import cn.com.catcher.vision.gov.qixia.model.Departments;

public interface DepartmentsService {
	public String findAllDepartmentsMatterStatsToday(int dateType,int state);
}
