package cn.com.catcher.vision.gov.qixia.approval.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.com.catcher.vision.gov.qixia.approval.model.User;
import cn.com.catcher.vision.gov.qixia.approval.service.UserService;
import cn.com.catcher.vision.gov.qixia.commons.constants.Constant;
import cn.com.catcher.vision.gov.qixia.commons.utils.JwtUtil;
import cn.com.catcher.vision.gov.qixia.commons.utils.ResponseUtil;
import io.jsonwebtoken.Claims;
import net.sf.json.JSONObject;

//@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/authenticate")
public class AuthenticateController {
	private static Logger logger = Logger.getLogger(AuthenticateController.class);
	
//	@Autowired
//	private JwtUtil jwt;
	
    @Autowired
    private UserService userService;

    @RequestMapping(value="/checkLogin",method=RequestMethod.POST)
//    @ResponseBody
    public String checkLogin(@RequestBody String data){

        try {
        	JSONObject  params= JSONObject.fromObject(data);
        	String uname = params.getString("uname");
        	String pwd = params.getString("pwd");
//        	User u = userService.checkLogin(uname,pwd);
//        	if(u!= null)//验证通过
//        	{
//            	int userId = u.getId();
        		
            if("admin".equals(uname) && "123456".equals(pwd))
          {
        		int userId=1;
        		
    			String subject = JwtUtil.generalSubject(String.valueOf(userId),"admin");
    			String token = JwtUtil.createJWT(Constant.JWT_ID, subject, Constant.JWT_TTL);
    			String refreshToken = JwtUtil.createJWT(Constant.JWT_ID, subject, Constant.JWT_REFRESH_TTL);
    			JSONObject jo = new JSONObject();
    			jo.put("token", token);
    			jo.put("refreshToken", refreshToken);
    			return ResponseUtil.success(jo);
        	}else
        	{
        	
        			return ResponseUtil.noLogin();
        		
        	}
        	

		} catch (Exception e) {
			logger.error(e);
			return ResponseUtil.unKonwException();
		}
    }
    
  @RequestMapping(value="/refreshToken",method=RequestMethod.POST)
  public String refreshToken(@RequestBody String data){

      try {
      	JSONObject  params= JSONObject.fromObject(data);
      	String refreshToken = params.getString("refreshToken");
      	Claims claims = JwtUtil.parseJWT(refreshToken);
 		String subjectStr = claims.getSubject();
 		
 		JSONObject  subjectJO= JSONObject.fromObject(subjectStr);
 		
 		String userId = subjectJO.getString("userId");
    	String roleId = subjectJO.getString("roleId");
    	
 		String subject = JwtUtil.generalSubject(userId,roleId);
 		String token = JwtUtil.createJWT(Constant.JWT_ID, subject, Constant.JWT_TTL);
      	
 		JSONObject jo = new JSONObject();
		jo.put("token", token);
		jo.put("refreshToken", refreshToken);
		return ResponseUtil.success(jo);
		} catch (Exception e) {
			logger.error(e);
			return ResponseUtil.unKonwException();
		}
  }
    
    
}
