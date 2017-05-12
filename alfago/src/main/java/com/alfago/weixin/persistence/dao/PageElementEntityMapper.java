package com.alfago.weixin.persistence.dao;

import org.springframework.stereotype.Repository;

import com.alfago.weixin.common.entitys.PageElementEntity;
@Repository("pageElementEntityMapper")
public interface PageElementEntityMapper extends IBaseDao<PageElementEntity,Integer> {

}
