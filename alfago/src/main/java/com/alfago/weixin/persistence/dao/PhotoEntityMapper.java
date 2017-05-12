package com.alfago.weixin.persistence.dao;

import org.springframework.stereotype.Repository;

import com.alfago.weixin.common.entitys.PhotoEntity;

@Repository("photoEntityMapper")
public interface PhotoEntityMapper extends IBaseDao<PhotoEntity,Integer> {

}
