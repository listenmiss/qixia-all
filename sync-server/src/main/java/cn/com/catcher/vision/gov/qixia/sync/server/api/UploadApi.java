package cn.com.catcher.vision.gov.qixia.sync.server.api;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import cn.com.catcher.vision.gov.qixia.sync.server.utils.PropertyUtil;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("fileTransfer")
public class UploadApi {
	
	private static final Logger logger = LoggerFactory.getLogger(UploadApi.class);
	
	private static String baseDir =PropertyUtil.getProperty("baseDir");
	private static String logsDir =PropertyUtil.getProperty("logsDir");
	

	
	@RequestMapping(value = "/receiver", method = RequestMethod.POST)
    public String  receiver(HttpServletRequest request,@RequestParam String prefixPath,@RequestParam String dirPath,@RequestParam String islog) throws IllegalStateException, IOException
    {
		try
    
	{
         long  startTime=System.currentTimeMillis();
         //将当前上下文初始化给  CommonsMutipartResolver （多部分解析器）
        CommonsMultipartResolver multipartResolver=new CommonsMultipartResolver(
                request.getSession().getServletContext());
        //检查form中是否有enctype="multipart/form-data"
        if(multipartResolver.isMultipart(request))
        {
            //将request变成多部分request
            MultipartHttpServletRequest multiRequest=(MultipartHttpServletRequest)request;
           //获取multiRequest 中所有的文件名
            Iterator iter=multiRequest.getFileNames();
             
            while(iter.hasNext())
            {
                //一次遍历所有文件
                MultipartFile file=multiRequest.getFile(iter.next().toString());
                if(file!=null)
                {
                	String str = dirPath.replaceAll("\\\\","/");
                	String newPrefixPath = prefixPath.replaceAll("\\\\","/");
                	String newBaseDir = baseDir.replaceAll("\\\\","/");
                	String newDirPath = str.replaceAll(newPrefixPath, newBaseDir);
                	
//                	int lastIndex = newDirPath.lastIndexOf("/");
//                	String str = dirPath.substring(0, lastIndex);
                	
                	
//                	String fileName = file.getOriginalFilename();
//                    String path="D:/b/"+fileName;
                    
                    File dir = new File(newDirPath);
					if(!dir.exists())   {
						dir.mkdirs();
				    }
                    //上传
                    file.transferTo(new File(newDirPath));
                    
//                    if(islog.equals("true"))
//                    {
//                    	Calendar c = Calendar.getInstance(); 
//                		Date date=new Date(); 
//                	
//                		c.setTime(date); 
////                		int day=c.get(Calendar.DATE); 
////                		c.set(Calendar.DATE,day-1); 
//
//                		String day=new SimpleDateFormat("yyyy-MM-dd").format(c.getTime()); 
//                		
//                		String ss = logsDir+File.separator+day+".txt";
//                		String preLogsDir = ss.replaceAll("\\\\","/");
//                		File logfile=new File(preLogsDir); 
//                		logfile.createNewFile();
//                		
//                    	logger.info("islog");
//                    }
                    logger.info("receive file success:"+newDirPath);
                }
                 
            }
           
        }
        return "success";
	}catch(Exception e)
		{
		logger.error("#########receive faild###########",e);
		return "error";
	}
         
    }
	
	   @RequestMapping(value = "/test", method = RequestMethod.GET)
	    public String  test()
	    {
	        
	      return "success"; 
	    }
	
}
