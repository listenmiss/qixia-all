package cn.com.catcher.vision.gov.qixia.approval.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.com.catcher.vision.gov.qixia.approval.model.MatterStats;
import cn.com.catcher.vision.gov.qixia.approval.model.User;
import cn.com.catcher.vision.gov.qixia.approval.service.MatterStatsService;
import cn.com.catcher.vision.gov.qixia.approval.service.UserService;
import net.sf.json.JSONObject;

//@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("stats")
public class MatterStatsController {
	   private static final Logger logger = LoggerFactory.getLogger(MatterStatsController.class);
	    
	    @Autowired
	    private MatterStatsService matterStatsService;
	    @RequestMapping(path = {"findMatterStatsByInsertStart"}, method = {RequestMethod.GET})
	    public List<MatterStats> findMatterStatsByInsertStart(HttpSession session,@RequestParam int insert_start){
	    	List<MatterStats> matterStatsList = this.matterStatsService.findMatterStatsByInsertStart(insert_start);
	        return matterStatsList;
	    }
	    
	    @RequestMapping(path = {"findMatterStatsDocs"}, method = {RequestMethod.GET})
	    public String findMatterStatsDocs(HttpSession session,@RequestParam int id){
	    	String  result = this.matterStatsService.findMatterStatsDocs(id);
	        return result;
	    }
	    

	    @RequestMapping(value="/updateMatterStatsInsertStart",method=RequestMethod.POST)
	    public boolean updateMatterStatsInsertStart(@RequestBody String data){
        	JSONObject  params= JSONObject.fromObject(data);
        	int id = params.getInt("id");
        	int status = params.getInt("status");
	    	boolean  result = this.matterStatsService.updateMatterStatsInsertStart(id,status);
	        return result;
	    }
}
