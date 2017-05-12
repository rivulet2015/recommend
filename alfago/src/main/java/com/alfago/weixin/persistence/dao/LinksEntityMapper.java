package com.alfago.weixin.persistence.dao;

import org.springframework.stereotype.Repository;

import com.alfago.weixin.common.entitys.LinksEntity;

@Repository("linksEntityMapper")
public interface LinksEntityMapper extends IBaseDao<LinksEntity,Integer> {

}
