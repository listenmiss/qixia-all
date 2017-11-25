package cn.com.catcher.vision.gov.qixia.approval.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.catcher.vision.gov.qixia.approval.dao.MatterStatsDao;
import cn.com.catcher.vision.gov.qixia.approval.dao.UserDao;
import cn.com.catcher.vision.gov.qixia.approval.model.MatterStats;
import cn.com.catcher.vision.gov.qixia.approval.service.MatterStatsService;
@Service("matterStatsService")
public class MatterStatsServiceImpl implements MatterStatsService {
	private static final Logger logger = LoggerFactory.getLogger(MatterStatsServiceImpl.class);
	@Autowired
	MatterStatsDao matterStatsDao;
	@Override
	public List<MatterStats> findMatterStatsByInsertStart(int insert_start) {
		logger.info("findMatterStatsByInsertStart:" + insert_start);
        return this.matterStatsDao.findMatterStatsByInsertStart(insert_start);
	}

}
