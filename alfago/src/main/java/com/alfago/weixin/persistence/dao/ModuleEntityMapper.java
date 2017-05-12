package com.alfago.weixin.persistence.dao;

import org.springframework.stereotype.Repository;

import com.alfago.weixin.common.entitys.ModuleEntity;
@Repository("moduleEntityMapper")
public interface ModuleEntityMapper extends IBaseDao<ModuleEntity,Integer> {

}
