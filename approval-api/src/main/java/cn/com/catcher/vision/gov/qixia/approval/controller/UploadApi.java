package cn.com.catcher.vision.gov.qixia.approval.controller;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import net.sf.json.JSONObject;

@RestController
@RequestMapping("fileTransfer")
public class UploadApi {
	private static final Logger logger = LoggerFactory.getLogger(UploadApi.class);

	private static String basePath = "/usr/local/statsDatas";
	/*
	 * 采用spring提供的上传文件的方法
	 */
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public boolean upload(@RequestParam("files") MultipartFile [] files,@RequestParam String userid,@RequestParam String idx)  
	{
			
		//如果只是上传一个文件，则只需要MultipartFile类型接收文件即可，而且无需显式指定@RequestParam注解  
        //如果想上传多个文件，那么这里就要用MultipartFile[]类型来接收文件，并且还要指定@RequestParam注解  
        //并且上传多个文件时，前台表单中的所有<input type="file"/>的name都应该是files，否则参数里的files无法获取到所有上传的文件  

		try
		{
	        boolean result = false;
	        String realPath;
	        for(int i=0;i<files.length;i++){
	            if (!files[i].isEmpty()) {  
						String dirPath = basePath +File.separator+userid+File.separator+idx;
						File dir = new File(dirPath);
						if(!dir.exists())   {
							dir.mkdirs();
					    }
	            	      String uniqueName=files[i].getOriginalFilename();//得到文件名
	                    realPath=dirPath+File.separator+uniqueName;//文件上传的路径这里为E盘
	                  
	                    files[i].transferTo(new File(realPath));   // 转存文件
	                    result = true;           
	                }
 
	            }
	        return result;

			
			
		}catch(Exception e)
		{
			logger.error("#########upload faild###########",e);
			return false;
		}
	
	}
	
	
	@RequestMapping(value="/download")
    public ResponseEntity<byte[]> download(HttpServletRequest request,
            @RequestParam("filename") String filename,
            @RequestParam String userid,
            @RequestParam String idx)throws Exception {
    	
    	 //下载文件路径
       String path = basePath +File.separator+userid+File.separator+idx;
       File file = new File(path + File.separator + filename);
       HttpHeaders headers = new HttpHeaders();  
       //下载显示的文件名，解决中文名称乱码问题  
       String downloadFielName = new String(filename.getBytes("UTF-8"),"iso-8859-1");
       //通知浏览器以attachment（下载方式）打开图片
       headers.setContentDispositionFormData("attachment", downloadFielName); 
       //application/octet-stream ： 二进制流数据（最常见的文件下载）。
       headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
       return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),    
               headers, HttpStatus.CREATED);  
    }
}
