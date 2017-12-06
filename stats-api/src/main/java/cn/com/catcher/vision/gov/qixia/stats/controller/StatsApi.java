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

@RestController
@RequestMapping("statsApi")
public class StatsApi {

    private static final Logger logger = LoggerFactory.getLogger(StatsApi.class);
    
    @Autowired
    private DepartmentsService departmentsService;
    
    @RequestMapping(path = {"findAllDepartmentsMatterStatsToday"}, method = {RequestMethod.GET})
    public String findAllDepartmentsMatterStatsToday(HttpSession session,@RequestParam int dateType,@RequestParam int state){
    	
    	
    	String result = this.departmentsService.findAllDepartmentsMatterStatsToday(dateType,state);
    
    	return result;
    }
    
}
