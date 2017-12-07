package cn.com.catcher.vision.gov.qixia.stats.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.catcher.vision.gov.qixia.dao.MatterStatsDao;
import cn.com.catcher.vision.gov.qixia.model.MatterStats;
import cn.com.catcher.vision.gov.qixia.stats.service.MatterStatsService;
import net.sf.json.JSONArray;

@Service("matterStatsService")
public class MatterStatsServiceImpl implements MatterStatsService{
	private static final Logger logger = LoggerFactory.getLogger(MatterStatsServiceImpl.class);
	@Autowired
	MatterStatsDao matterStatsDao;
	@Override
	public String  findLastMatterStats(int count) {
		
		 List<MatterStats> list = matterStatsDao.findLastMatterStats(count);
		return JSONArray.fromObject(list).toString();
		
	}
	@Override
	public String getMatterStatsCountByGroup(int state,String groupIds) {
		
		
		JSONArray ja=new JSONArray();
		
		Map<String,Object> jmap=new HashMap<String,Object>(); 
		 jmap.put("state", state);
		 
		 String[]  groupIdsArray = groupIds.split(",");
		 
		 
		 for(int i=0;i<groupIdsArray.length;i++)
		 {
			 jmap.put("groupid", Integer.valueOf(groupIdsArray[i]));
			 int count = matterStatsDao.findMatterStatsCountByGroup(jmap);
			 
			 ja.add(count);
		 }
		
		
		return ja.toString();
	}
	
}
