package cn.com.catcher.vision.gov.qixia.stats.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.catcher.vision.gov.qixia.dao.UserDao;
import cn.com.catcher.vision.gov.qixia.stats.service.UserService;
import net.sf.json.JSONObject;
@Service("userService")
public class UserServiceImpl implements UserService {
	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	@Autowired
	UserDao userDao;
	@Override
	public String getUserCountInfo() {
		// TODO Auto-generated method stub
		int onlineCount =userDao.findOnlineUserCount();
		int allCount =userDao.findAllUserCount();
		JSONObject jo = new JSONObject();
		jo.put("onlineCount", onlineCount);
		jo.put("allCount", allCount);
		
		return jo.toString();
	}

}
