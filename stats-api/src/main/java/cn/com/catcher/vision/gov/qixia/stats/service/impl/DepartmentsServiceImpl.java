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
@Service("departmentsService")
public class DepartmentsServiceImpl implements DepartmentsService{
	private static final Logger logger = LoggerFactory.getLogger(DepartmentsServiceImpl.class);
	@Autowired
	DepartmentsDao departmentsDao;
	@Override
	public String findAllDepartmentsMatterStatsToday(int dateType,int state) {
		List<Departments> alldlist= new ArrayList();
	
		

         

        
		Map<String,Object> jmap=new HashMap<String,Object>(); 
		 List<Integer> jdepIds = new ArrayList();
		 jdepIds.add(11);
		 jdepIds.add(12);
		 jdepIds.add(13);
		 jdepIds.add(14);
		 jdepIds.add(15);
		 jdepIds.add(16);
		 jdepIds.add(17);
		 jdepIds.add(32);
		 jdepIds.add(33);
		 jdepIds.add(4);
		 jdepIds.add(28);
		 jdepIds.add(31);
		 jmap.put("depIds", jdepIds);
		 jmap.put("dateType", dateType);
		 jmap.put("state", state);
		 
		alldlist= departmentsDao.findAllDepartmentsMatterStatsToday(jmap);
		
		Map<String,Object> jumap=new HashMap<String,Object>(); 
		 List<Integer> judepIds = new ArrayList();
		 judepIds.add(3);
		 judepIds.add(1);
		 judepIds.add(5);
		 judepIds.add(9);
		 jumap.put("depIds", judepIds);
		 jumap.put("dateType", dateType);
		 jumap.put("state", state);
		 List<Departments> julist = departmentsDao.findAllDepartmentsMatterStatsToday(jumap);
		 alldlist.addAll(julist);
		
		JSONArray ja = JSONArray.fromObject(alldlist);
		return ja.toString();
	}

}
