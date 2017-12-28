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

public class SyncLogsJob extends QuartzJobBean{
	
	 private static final Logger logger = LoggerFactory.getLogger(SyncLogsJob.class);
	@Override
	protected void executeInternal(JobExecutionContext arg0) throws JobExecutionException {
	
		logger.info("##SyncLogsJob##" );
		String logsDir = PropertyUtil.getProperty("logsDir");
		String baseDir = PropertyUtil.getProperty("baseDir");
//		upload();
		
		
		//SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd"); 
		Calendar c = Calendar.getInstance(); 
		Date date=new Date(); 
	
		c.setTime(date); 
		int day=c.get(Calendar.DATE); 
//		c.set(Calendar.DATE,day-1); 
		c.set(Calendar.DATE,day); 
		String dayBefore=new SimpleDateFormat("yyyy-MM-dd").format(c.getTime()); 
		
		String str = logsDir+File.separator+dayBefore+".txt";
		String preLogsDir = str.replaceAll("\\\\","/");
		File file=new File(preLogsDir);   
		if(file.exists())//�����������Ҫͬ��
		{
			String url = PropertyUtil.getProperty("receiver.url");
			 HttpConnectionUtil.uploadFile(url+"?dirPath="+preLogsDir+"&prefixPath="+baseDir+"&islog=true",new String[] { preLogsDir });
         	
		}
		
		logger.info("##v##" +logsDir);
		
	}
	
	
	private  void upload()
	{
//		 String str = HttpConnectionUtil.uploadFile("http://localhost:8080/sync-server/fileTransfer/receive",new String[] { "D:\\a\\test.txt" });
//         System.out.println(str);
	}

}
