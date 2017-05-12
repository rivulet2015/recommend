package com.alfago.weixin.service.persistence.impl;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alfago.weixin.common.entitys.ModuleEntity;
import com.alfago.weixin.persistence.dao.IBaseDao;
import com.alfago.weixin.persistence.dao.ModuleEntityMapper;
import com.alfago.weixin.service.persistence.ModuleService;
@Service("moduleService")
public class ModuleServiceImpl extends BaseServiceImpl<ModuleEntity,Integer> implements ModuleService{

	@Autowired
	private ModuleEntityMapper moduleEntityMapper;
	
	@Override
	public IBaseDao<ModuleEntity, Integer> getDao() {
		// TODO Auto-generated method stub
		return this.moduleEntityMapper;
	}
}
