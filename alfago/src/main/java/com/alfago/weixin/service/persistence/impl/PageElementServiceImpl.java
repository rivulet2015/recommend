package com.alfago.weixin.service.persistence.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alfago.weixin.common.entitys.PageElementEntity;
import com.alfago.weixin.persistence.dao.IBaseDao;
import com.alfago.weixin.persistence.dao.PageElementEntityMapper;
import com.alfago.weixin.service.persistence.PageElementService;

@Service("pageElementService") 
public class PageElementServiceImpl extends BaseServiceImpl<PageElementEntity,Integer> implements PageElementService{

	@Autowired
	private PageElementEntityMapper pageElementEntityMapper;

	@Override
	public IBaseDao<PageElementEntity, Integer> getDao() {
		// TODO Auto-generated method stub
		return pageElementEntityMapper;
	}

}
