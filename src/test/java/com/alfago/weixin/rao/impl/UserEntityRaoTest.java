package com.alfago.weixin.rao.impl;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

import com.alfago.weixin.common.beans.UserEntity;
import com.alfago.weixin.persistence.mongo.repository.RecommendationRepository;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/spring/applicationContext.xml"})
public class UserEntityRaoTest {

	@Resource(name="userEntityRao")
	private UserEntityRao userEntityRao;
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testAddUserEntity() {
		
		UserEntity userEntity = new UserEntity();
		userEntity.setGroupId(12345);
		userEntity.setQq("123456989");
		userEntityRao.add(userEntity);
	}


}
