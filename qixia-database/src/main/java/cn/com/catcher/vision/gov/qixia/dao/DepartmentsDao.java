package cn.com.catcher.vision.gov.qixia.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.com.catcher.vision.gov.qixia.model.Departments;

public interface DepartmentsDao {
	public List<Departments> findAllDepartmentsByIds(@Param("depIds")List depIds);
	public List<Departments> findAllDepartmentsMatterStatsToday(Map<String, Object> map);

	int findDepartmentsMatterStatsCount(Map<String, Object> map);
	

}
