package cn.com.catcher.vision.gov.qixia.sync.client.api;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.com.catcher.vision.gov.qixia.config.MultipleDataSource;
import cn.com.catcher.vision.gov.qixia.model.MatterStats;
import cn.com.catcher.vision.gov.qixia.sync.client.service.ApiService;




@RestController
@RequestMapping("api")
public class Api {
	private static final Logger logger = LoggerFactory.getLogger(Api.class);
	
	   @Autowired
	    private ApiService apiService;
    
    @RequestMapping(path = {"test"}, method = {RequestMethod.GET})
    public String test(HttpSession session){


    	MatterStats matterStats = apiService.findMatterStatsById("50457");
    	
//    	
//    	long id = Long.valueOf("56714").longValue();
//    	matterStats.setIdx(id);
//    	MultipleDataSource.setDataSourceKey("dataSource2");
//    	int r = apiService.insertMatterStats(matterStats);
    	return "123";
    }
    
    
    @RequestMapping(path = {"test2"}, method = {RequestMethod.GET})
    public String test2(HttpSession session){


    	String  tt = apiService.t2();
    	
//    	
//    	long id = Long.valueOf("56714").longValue();
//    	matterStats.setIdx(id);
//    	MultipleDataSource.setDataSourceKey("dataSource2");
//    	int r = apiService.insertMatterStats(matterStats);
    	return tt;
    }
    
    @RequestMapping(path = {"test3"}, method = {RequestMethod.GET})
    public String test3(HttpSession session){


    	String  tt = apiService.t3();
    	
//    	
//    	long id = Long.valueOf("56714").longValue();
//    	matterStats.setIdx(id);
//    	MultipleDataSource.setDataSourceKey("dataSource2");
//    	int r = apiService.insertMatterStats(matterStats);
    	return tt;
    }
    
    
    @RequestMapping(path = {"test4"}, method = {RequestMethod.GET})
    public String test4(HttpSession session){


    	String  tt = apiService.t4();
    	
//    	
//    	long id = Long.valueOf("56714").longValue();
//    	matterStats.setIdx(id);
//    	MultipleDataSource.setDataSourceKey("dataSource2");
//    	int r = apiService.insertMatterStats(matterStats);
    	return tt;
    }
    
    
    @RequestMapping(path = {"test5"}, method = {RequestMethod.GET})
    public String test5(HttpSession session){


    	String  tt = apiService.t5();
    	
//    	
//    	long id = Long.valueOf("56714").longValue();
//    	matterStats.setIdx(id);
//    	MultipleDataSource.setDataSourceKey("dataSource2");
//    	int r = apiService.insertMatterStats(matterStats);
    	return tt;
    }
    
    
    @RequestMapping(path = {"test6"}, method = {RequestMethod.GET})
    public String test6(HttpSession session){


    	String  tt = apiService.t6();
    	
//    	
//    	long id = Long.valueOf("56714").longValue();
//    	matterStats.setIdx(id);
//    	MultipleDataSource.setDataSourceKey("dataSource2");
//    	int r = apiService.insertMatterStats(matterStats);
    	return tt;
    }
}
