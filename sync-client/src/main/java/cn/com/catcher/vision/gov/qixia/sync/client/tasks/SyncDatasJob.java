package cn.com.catcher.vision.gov.qixia.sync.client.tasks;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import cn.com.catcher.vision.gov.qixia.sync.client.service.ApiService;
import cn.com.catcher.vision.gov.qixia.sync.client.service.impl.ApiServiceImpl;

public class SyncDatasJob extends QuartzJobBean{
	 private static final Logger logger = LoggerFactory.getLogger(SyncDatasJob.class);
		
	   @Autowired
	    private ApiService apiService;
	   
	   
	    @Override
		protected void executeInternal(JobExecutionContext arg0) throws JobExecutionException {
	    	
		 apiService.syncDatas();
		}
	 
	
}
