package com.alfago.weixin.service.persistence.impl;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alfago.weixin.common.beans.UserEntity;
import com.alfago.weixin.service.mail.MailService;
import com.alfago.weixin.service.persistence.IUserInfoService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/spring/applicationContext.xml"})
public class UserEntityServiceImplTest {

	@Resource(name="userEntityService")
	private IUserInfoService userEntityService;
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testInsertSelective() {
		List<UserEntity> list = new ArrayList<UserEntity>();
		for(int i = 0; i< 2000; i++){
			UserEntity userEntity = new UserEntity();
			userEntity.setGroupId(12345);
			userEntity.setQq("123456989"+i);
			list.add(userEntity);
		}
		userEntityService.insertBatch(list);
		
	}

}
