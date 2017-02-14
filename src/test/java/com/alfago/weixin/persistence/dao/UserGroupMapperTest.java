package com.alfago.weixin.persistence.dao;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alfago.weixin.common.beans.UserGroup;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/spring/applicationContext.xml"})
public class UserGroupMapperTest {

	@Resource
	private UserGroupMapper userGroupMapper;
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	@Test
	public void testUpdateByPrimaryKeySelective() {
		UserGroup userGroup = new UserGroup();
		userGroup.setId(1);
		userGroup.setDecription("adwaedwadwa");
		userGroup.setGroupType(2);
		userGroup.setKeyword("eweeeee");
		userGroup.setLocation(1234);
		userGroup.setQq("123344");
		userGroupMapper.updateByPrimaryKeySelective(userGroup);
	}
/*	@Test
	public void testInsertSelective() {
		UserGroup userGroup = new UserGroup();
		userGroup.setDecription("adwaedwadwa");
		userGroup.setGroupType(2);
		userGroup.setKeyword("adeaawew");
		userGroup.setLocation(1234);
		userGroup.setQq("123344333333");
		userGroupMapper.insertSelective(userGroup);
		
	}

	@Test
	public void testUpdateByPrimaryKeySelective() {
		UserGroup userGroup = new UserGroup();
		userGroup.setId(1);
		userGroup.setDecription("adwaedwadwa");
		userGroup.setGroupType(2);
		userGroup.setKeyword("eweeeee");
		userGroup.setLocation(1234);
		userGroup.setQq("123344");
		userGroupMapper.updateByPrimaryKeySelective(userGroup);
	}
	
	@Test
	public void testSelectByPrimaryKey() {
		UserGroup userGroup = new UserGroup();
		userGroup.setId(1);
		userGroup.setDecription("adwaedwadwa");
		userGroup.setGroupType(2);
		userGroup.setKeyword("eweeeee");
		userGroup.setLocation(1234);
		userGroup.setQq("123344");
		UserGroup userGroup2 = userGroupMapper.selectByPrimaryKey(1);
	}

	@Test
	public void testSelectOneByModel() {
		UserGroup userGroup = new UserGroup();
		userGroup.setDecription("adwaedwadwa");
		userGroup.setGroupType(2);
		userGroup.setKeyword("eweeeee");
		userGroup.setLocation(1234);
		userGroup.setQq("123344");
		List<UserGroup> userGroups = userGroupMapper.selectAllByModel(userGroup);
	}	*/
	
/*
	@Test
	public void testDeleteByPrimaryKey() {
		fail("Not yet implemented");
	}



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
