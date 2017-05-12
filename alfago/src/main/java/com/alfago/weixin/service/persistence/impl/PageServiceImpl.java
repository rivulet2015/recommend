package com.alfago.weixin.service.persistence.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alfago.weixin.common.entitys.PageEntity;
import com.alfago.weixin.persistence.dao.IBaseDao;
import com.alfago.weixin.persistence.dao.PageEntityMapper;
import com.alfago.weixin.service.persistence.PageService;

@Service("pageService") 
public class PageServiceImpl extends BaseServiceImpl<PageEntity,Integer> implements PageService{

	@Autowired
	private PageEntityMapper pageEntityMapper;

	@Override
	public IBaseDao<PageEntity, Integer> getDao() {

		return this.pageEntityMapper;
	}
	
}
