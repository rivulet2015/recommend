package com.alfago.weixin.persistence.dao;

import org.springframework.stereotype.Repository;

import com.alfago.weixin.common.entitys.GbookEntity;

@Repository("gbookEntityMapper")
public interface GbookEntityMapper extends IBaseDao<GbookEntity,Integer> {

}
