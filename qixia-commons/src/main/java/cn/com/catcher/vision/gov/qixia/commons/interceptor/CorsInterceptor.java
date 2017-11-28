package cn.com.catcher.vision.gov.qixia.commons.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


public class CorsInterceptor implements HandlerInterceptor{
	private static Logger logger = Logger.getLogger(CorsInterceptor.class);
	
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		logger.info("Access####Access");
		    response.setHeader("Access-Control-Allow-Origin", "*");  
	        response.setHeader("Access-Control-Allow-Methods", "*");  
	        response.setHeader("Access-Control-Max-Age", "3600");  
	        response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept,Authorization"); 
	        response.setHeader("Access-Control-Allow-Credentials","true"); //�Ƿ����������Я���û������Ϣ��cookie��  
	        return true;  
	}

}
