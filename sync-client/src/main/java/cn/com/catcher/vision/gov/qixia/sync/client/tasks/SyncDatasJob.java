package cn.com.catcher.vision.gov.qixia.sync.client.tasks;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;

import cn.com.catcher.vision.gov.qixia.sync.client.util.HttpConnectionUtil;
import cn.com.catcher.vision.gov.qixia.sync.client.util.PropertyUtil;

public class SyncDatasJob extends QuartzJobBean{
	 private static final Logger logger = LoggerFactory.getLogger(SyncDatasJob.class);
		@Override
		protected void executeInternal(JobExecutionContext arg0) throws JobExecutionException {
		
			logger.info("##SyncDatasJob##" );
		
			
		}
		
}
