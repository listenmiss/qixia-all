package cn.com.catcher.vision.gov.qixia.dao;

import java.util.List;
import java.util.Map;

import cn.com.catcher.vision.gov.qixia.model.Departments;

public interface DepartmentsDao {
	
	public List<Departments> findAllDepartmentsMatterStatsToday(Map<String, Object> map);
}
