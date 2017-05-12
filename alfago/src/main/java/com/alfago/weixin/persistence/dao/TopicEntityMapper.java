package com.alfago.weixin.persistence.dao;

import org.springframework.stereotype.Repository;

import com.alfago.weixin.common.entitys.TopicEntity;

@Repository("topicEntityMapper")
public interface TopicEntityMapper extends IBaseDao<TopicEntity,Integer> {

}
