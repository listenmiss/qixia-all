package cn.com.catcher.vision.gov.qixia.dao;

import org.apache.ibatis.annotations.Param;

import cn.com.catcher.vision.gov.qixia.model.MatterStats;
import cn.com.catcher.vision.gov.qixia.model.User;

public interface UserDao {

    int findOnlineUserCount();
    int findAllUserCount();
    public User findUserById(@Param("id") int id);
    
    int insertUser(User user);

}