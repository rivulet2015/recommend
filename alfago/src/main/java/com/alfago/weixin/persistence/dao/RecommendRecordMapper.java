package com.alfago.weixin.persistence.dao;

import org.springframework.stereotype.Repository;

import com.alfago.weixin.common.beans.RecommendRecord;
@Repository("recommendRecordMapper")
public interface RecommendRecordMapper extends IBaseDao<RecommendRecord,Integer> {

}
