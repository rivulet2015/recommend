package com.alfago.weixin.persistence.dao;

import org.springframework.stereotype.Repository;

import com.alfago.weixin.common.entitys.PageEntity;
@Repository("pageEntityMapper")
public interface PageEntityMapper extends IBaseDao<PageEntity,Integer> {

}
