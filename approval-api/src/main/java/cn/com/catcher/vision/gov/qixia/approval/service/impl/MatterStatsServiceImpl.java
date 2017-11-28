package cn.com.catcher.vision.gov.qixia.approval.service.impl;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.catcher.vision.gov.qixia.approval.dao.MatterStatsDao;
import cn.com.catcher.vision.gov.qixia.approval.model.MatterStats;
import cn.com.catcher.vision.gov.qixia.approval.service.MatterStatsService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
@Service("matterStatsService")
public class MatterStatsServiceImpl implements MatterStatsService {
	private static final Logger logger = LoggerFactory.getLogger(MatterStatsServiceImpl.class);
	@Autowired
	MatterStatsDao matterStatsDao;
	@Override
	public List<MatterStats> findMatterStatsByInsertStart(int insert_start) {
		logger.info("findMatterStatsByInsertStart:" + insert_start);
        return this.matterStatsDao.findMatterStatsByInsertStart(insert_start);
	}
	
	
	@Override
	public String findMatterStatsDocs(int id) {

		JSONArray result = new JSONArray();
		try {
			
			
			
			Long lId = new Long(id);
			MatterStats m=this.matterStatsDao.findMatterStatsById((lId));
			if(m!=null)
			{
				byte[] bdoc = m.getM_docs();
				if(bdoc!=null)
				{
					
						String str = new String(bdoc,"utf-8");
						
					  if(str!=null && !"".equals(str))
					  {
						  String[] ss = str.split("##");
							if(ss!=null&&ss.length>0)
							{
								for(int i=0;i<ss.length;i++)
								{
									result.add(ss[i]);
								}
							}
					  }
				}
			}
			 return result.toString();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	
	
	
//	@Override
//	public String findMatterStatsDocs(int id) {
//
//		JSONArray result = new JSONArray();
//		try {
//			
//			
//			
//			Long lId = new Long(id);
//			MatterStats m=this.matterStatsDao.findMatterStatsById((lId));
//			if(m!=null)
//			{
//				byte[] bdoc = m.getM_docs();
//				if(bdoc!=null)
//				{
//					
//						String str = new String(bdoc,"utf-8");
//						String[] ss = str.split("\n");
//						if(ss!=null&&ss.length>0)
//						{
//							for(int i=0;i<ss.length;i++)
//							{
//								
//								String itemStr = ss[i];
//								
//								if(itemStr!=null &&!"".equals(itemStr))
//								{
//									String[] itemStrArray = itemStr.split("��");
//									if(itemStrArray!=null && itemStrArray.length>1)
//									{
//										String doc = itemStrArray[1];
//										result.add(doc);
//									}
//							
//								}
//								
//								
//							}
//						}
//						
//					
//				}
//			}
//			 return result.toString();
//		} catch (UnsupportedEncodingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			return null;
//		}
//	}
	@Override
	public boolean updateMatterStatsInsertStart(int id, int status) {
		MatterStats m = new MatterStats();
		Long idx = new Long(id);
		m.setIdx(idx);
		m.setInsert_start(status);
		
		int c=this.matterStatsDao.updateMatterStatsInsertStart((m));
		if(c>0)
		{
			return true;
		}else
		{
			return false;
		}
		
	}

}
