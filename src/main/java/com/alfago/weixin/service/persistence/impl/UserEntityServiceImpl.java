package com.alfago.weixin.service.persistence.impl;

import java.util.List;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alfago.weixin.common.beans.UserEntity;
import com.alfago.weixin.persistence.dao.IBaseDao;
import com.alfago.weixin.persistence.dao.UserEntityMapper;
import com.alfago.weixin.service.persistence.IUserInfoService;

@Service("userEntityService")
public class UserEntityServiceImpl extends BaseServiceImpl<UserEntity,Integer> implements IUserInfoService{

	@Autowired
	private UserEntityMapper userEntityMapper;
	
	public UserEntityMapper getUserEntityMapper() {
		return userEntityMapper;
	}

	public void setUserEntityMapper(UserEntityMapper userEntityMapper) {
		this.userEntityMapper = userEntityMapper;
	}

	@Override
	public IBaseDao<UserEntity, Integer> getDao() {
		// TODO Auto-generated method stub
		return userEntityMapper;
	}

	@Override
	public SqlSessionFactory getSessionFactory() {
		// TODO Auto-generated method stub
		return this.getSqlSessionFactory();
	}

}
