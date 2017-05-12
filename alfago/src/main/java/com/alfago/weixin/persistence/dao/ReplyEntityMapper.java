package com.alfago.weixin.persistence.dao;

import org.springframework.stereotype.Repository;

import com.alfago.weixin.common.entitys.ReplyEntity;

@Repository("replyEntityMapper")
public interface ReplyEntityMapper extends IBaseDao<ReplyEntity,Integer> {

}
