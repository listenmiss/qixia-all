package cn.com.catcher.vision.gov.qixia.approval.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.com.catcher.vision.gov.qixia.approval.model.Item;
import cn.com.catcher.vision.gov.qixia.approval.service.ItemService;
@RestController
@RequestMapping("item")
public class ItemController {
      private static final Logger logger = LoggerFactory.getLogger(UserController.class);
		   
		    @Autowired
		    private ItemService itemService;
		    @RequestMapping(path = {"findItemById"}, method = {RequestMethod.GET})
		    public Item findItemById(HttpSession session,@RequestParam int id){
		    	Item item = this.itemService.findItemById(id);
		        return item;
		    }

}
