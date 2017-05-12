package com.alfago.weixin.persistence.dao;

import org.springframework.stereotype.Repository;

import com.alfago.weixin.common.entitys.BlogEntity;

@Repository("blogEntityMapper")
public interface BlogEntityMapper extends IBaseDao<BlogEntity,Integer> {

}
