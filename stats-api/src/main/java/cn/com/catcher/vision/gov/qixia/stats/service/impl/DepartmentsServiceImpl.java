package cn.com.catcher.vision.gov.qixia.stats.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.catcher.vision.gov.qixia.dao.DepartmentsDao;
import cn.com.catcher.vision.gov.qixia.model.Departments;
import cn.com.catcher.vision.gov.qixia.stats.service.DepartmentsService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
@Service("departmentsService")
public class DepartmentsServiceImpl implements DepartmentsService{
	private static final Logger logger = LoggerFactory.getLogger(DepartmentsServiceImpl.class);
	@Autowired
	DepartmentsDao departmentsDao;
	
	@Override
	public String findAllDepartmentsByIds(String jdepIds) {
	  	if(jdepIds==null||jdepIds.equals(""))
    	{
    		return null;
    	}
    	
		
	
    	List jdepIdsList= new ArrayList();
    	String[] depIdStrArray = jdepIds.split(",");
    	for(String str:depIdStrArray)
    	{
    		jdepIdsList.add(Integer.valueOf(str));
    	}
    	List<Departments> alldlist= departmentsDao.findAllDepartmentsByIds(jdepIdsList);
    	if(alldlist==null)
    	{
    		return null;
    	}
		JSONArray ja = JSONArray.fromObject(alldlist);
		return ja.toString();
	}
	
	@Override
	public String findAllDepartmentsMatterStatsToday(String jdepIds,int dateType,int state) {
    	if(jdepIds==null||jdepIds.equals(""))
    	{
    		return null;
    	}
    	
		List<Departments> alldlist= new ArrayList();
	
    	List jdepIdsList= new ArrayList();
    	String[] depIdStrArray = jdepIds.split(",");
    	for(String str:depIdStrArray)
    	{
    		jdepIdsList.add(Integer.valueOf(str));
    	}
    	

		Map<String,Object> jmap=new HashMap<String,Object>(); 
	
		 jmap.put("depIds", jdepIdsList);
		 jmap.put("dateType", dateType);
		 jmap.put("state", state);
		 jmap.put("sortList", jdepIdsList);
		 
		alldlist= departmentsDao.findAllDepartmentsMatterStatsToday(jmap);
		
		
		
		JSONArray ja = JSONArray.fromObject(alldlist);
		return ja.toString();
	}

	@Override
	public int findDepartmentsMatterStatsCount(String jdepIds, int dateType, int state) {
		if(jdepIds==null||jdepIds.equals(""))
    	{
    		return 0;
    	}
    	
		int result=0;
    	List jdepIdsList= new ArrayList();
    	String[] depIdStrArray = jdepIds.split(",");
    	for(String str:depIdStrArray)
    	{
    		jdepIdsList.add(Integer.valueOf(str));
    	}
    	

		Map<String,Object> jmap=new HashMap<String,Object>(); 
	
		 jmap.put("depIds", jdepIdsList);
		 jmap.put("dateType", dateType);
		 jmap.put("state", state);
		
		 
		 result= departmentsDao.findDepartmentsMatterStatsCount(jmap);
		
		
		return result;
		
	}

	@Override
	public String getDepartmentsMatterStatsCountInfo(String jdepIds, int state) {
		int todayCount=findDepartmentsMatterStatsCount( jdepIds, 1, 5);
		int weekCount=findDepartmentsMatterStatsCount( jdepIds, 2, 5);
		int monthCount=findDepartmentsMatterStatsCount( jdepIds, 3, 5);
		int yearCount =findDepartmentsMatterStatsCount( jdepIds, 4, 5);
		int allCount =findDepartmentsMatterStatsCount( jdepIds, 5, 5);
		
		JSONObject jo = new JSONObject();
		jo.put("todayCount",todayCount );
		jo.put("weekCount", weekCount);
		jo.put("monthCount", monthCount);
		jo.put("yearCount",yearCount );
		jo.put("allCount",allCount );
		
		return jo.toString();
		
	}


}
