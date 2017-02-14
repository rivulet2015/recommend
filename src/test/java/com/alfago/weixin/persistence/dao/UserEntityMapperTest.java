package com.alfago.weixin.persistence.dao;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alfago.weixin.common.beans.TaskEntity;
import com.alfago.weixin.common.beans.UserEntity;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/spring/applicationContext.xml"})
public class UserEntityMapperTest {

	@Resource
	private UserEntityMapper userEntityMapper;
	
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	@Test
	public void testDeleteByPrimaryKey() {
		//userEntityMapper.deleteByPrimaryKey(3);
	}
/*	@Test
	public void testInsertSelective() {
		UserEntity userEntity = new UserEntity();
		userEntity.setGroupId(12345);
		userEntity.setQq("123456989");
		userEntityMapper.insertSelective(userEntity);
	}

	@Test
	public void testUpdateByPrimaryKeySelective() {
		UserEntity userEntity = new UserEntity();
		userEntity.setId(1);
		userEntity.setGroupId(1233);
		userEntity.setQq("123456789");
		userEntityMapper.updateByPrimaryKeySelective(userEntity);
	}

	@Test
	public void testDeleteByPrimaryKey() {
		userEntityMapper.deleteByPrimaryKey(3);
	}

	@Test
	public void testSelectByPrimaryKey() {
		System.out.println(userEntityMapper.selectByPrimaryKey(1).getQq());
	}

	@Test
	public void testSelectOneByModel() {
		UserEntity userEntity = new UserEntity();
		userEntity.setGroupId(1233);
		userEntity.setQq("123456789");
		System.out.println(userEntityMapper.selectOneByModel(userEntity).getQq());
	}*/
	/*
	@Test
	public void testSelectAllByModel() {
		fail("Not yet implemented");
	}

	@Test
	public void testSelectAll() {
		fail("Not yet implemented");
	}
*/
}
