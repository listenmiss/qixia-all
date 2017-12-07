package cn.com.catcher.vision.gov.qixia.stats.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.com.catcher.vision.gov.qixia.stats.service.DepartmentsService;
import cn.com.catcher.vision.gov.qixia.stats.service.MatterStatsService;
import cn.com.catcher.vision.gov.qixia.stats.service.UserService;

@RestController
@RequestMapping("statsApi")
public class StatsApi {

    private static final Logger logger = LoggerFactory.getLogger(StatsApi.class);
    
    @Autowired
    private DepartmentsService departmentsService;
    
    
    @Autowired
    private MatterStatsService matterStatsService;
    
    
    @Autowired
    private UserService  userService;
    
    @RequestMapping(path = {"findAllDepartmentsByIds"}, method = {RequestMethod.GET})
    public String findAllDepartmentsByIds(HttpSession session,@RequestParam String jdepIds){

    	String result = this.departmentsService.findAllDepartmentsByIds(jdepIds);
    
    	return result;
    }
    
    @RequestMapping(path = {"findAllDepartmentsMatterStatsToday"}, method = {RequestMethod.GET})
    public String findAllDepartmentsMatterStatsToday(HttpSession session,@RequestParam String jdepIds,@RequestParam int dateType,@RequestParam int state){

    	String result = this.departmentsService.findAllDepartmentsMatterStatsToday(jdepIds,dateType,state);
    
    	return result;
    }
    
    
    @RequestMapping(path = {"getDepartmentsMatterStatsCountInfo"}, method = {RequestMethod.GET})
    public String getDepartmentsMatterStatsCountInfo(HttpSession session,@RequestParam String jdepIds,@RequestParam int state){

    	String  result = this.departmentsService.getDepartmentsMatterStatsCountInfo(jdepIds,state);
    	
    	return result;
    }
    
    @RequestMapping(path = {"findLastMatterStats"}, method = {RequestMethod.GET})
    public String findLastMatterStats(HttpSession session,@RequestParam int count){

    	String  result = this.matterStatsService.findLastMatterStats(count);
    	
    	return result;
    }
    
    @RequestMapping(path = {"getUserCountInfo"}, method = {RequestMethod.GET})
    public String getUserCountInfo(HttpSession session){

    	String  result = this.userService.getUserCountInfo();
    	
    	return result;
    }
    
    @RequestMapping(path = {"getMatterStatsCountByGroup"}, method = {RequestMethod.GET})
    public String getMatterStatsCountByGroup(HttpSession session){
    	String groupIds ="10,11,15,14,13,12";

    	String  result = this.matterStatsService.getMatterStatsCountByGroup(5,groupIds);
    	
    	return result;
    }
    
}
