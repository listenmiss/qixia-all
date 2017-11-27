package cn.com.catcher.vision.gov.qixia.commons.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class CorsInterceptor implements HandlerInterceptor{

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
		    response.setHeader("Access-Control-Allow-Origin", "*");  
	        response.setHeader("Access-Control-Allow-Methods", "*");  
	        response.setHeader("Access-Control-Max-Age", "3600");  
	        response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept,Authorization"); 
	        response.setHeader("Access-Control-Allow-Credentials","true"); //是否允许浏览器携带用户身份信息（cookie）  
	        return true;  
	}

}
