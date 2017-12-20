package cn.com.catcher.vision.gov.qixia.dao;

import org.apache.ibatis.annotations.Param;

import cn.com.catcher.vision.gov.qixia.model.Matter;

public interface MatterDao {
    public Matter findMatterById(@Param("id") Long id);
    
    int insertMatter(Matter matter);
}
