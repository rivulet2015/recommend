package com.alfago.weixin.persistence.dao;

import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.util.List;

import javax.annotation.Resource;

import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alfago.weixin.common.beans.RecommendRecord;
import com.alfago.weixin.service.mail.MailService;
import com.caucho.hessian.client.HessianProxyFactory;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/spring/applicationContext.xml"})
public class RecommendRecordMapperTest {

	@Resource
	private RecommendRecordMapper recommendRecordMapper;
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/*
	@Test
	public void testInsertSelective() {
		RecommendRecord recommendRecord = new RecommendRecord();
		recommendRecord.setGroupId(1122121);
		recommendRecord.setRecommendationId("12121131231");
		recommendRecordMapper.insertSelective(recommendRecord);
	}
	*/
	@Test
	public void testSelectByPrimaryKey() throws MalformedURLException {
		
/*		RecommendRecord recommendRecord = null;
		recommendRecord =  recommendRecordMapper.selectByPrimaryKey(2);
		System.out.println(recommendRecord.getRecommendationId());*/
		
/*		 String url = "http://localhost:8080/alfago/hessian/RecommendRecordMapper"; 
		 HessianProxyFactory factory = new HessianProxyFactory(); 
		 RecommendRecordMapper recommendRecordMapper = (RecommendRecordMapper) factory.create(RecommendRecordMapper.class, url); 
		 RecommendRecord recommendRecord = null;
		recommendRecord =  recommendRecordMapper.selectByPrimaryKey(2);
		System.out.println(recommendRecord.getRecommendationId());*/
		
	}
/*	@Test
	public void testUpdateByPrimaryKeySelective() {
		RecommendRecord recommendRecord = new RecommendRecord();
		recommendRecord.setId(2);
		recommendRecord.setGroupId(123);
		recommendRecord.setRecommendationId("231");
		recommendRecordMapper.updateByPrimaryKeySelective(recommendRecord);
	}
	@Test
	public void testInsertSelective() {
		RecommendRecord recommendRecord = new RecommendRecord();
		recommendRecord.setGroupId(1122121);
		recommendRecord.setRecommendationId("12121131231");
		recommendRecordMapper.insertSelective(recommendRecord);
	}*/
/*	@Test
	public void testInsertSelective() {
		RecommendRecord recommendRecord = new RecommendRecord();
		recommendRecord.setGroupId(1122121);
		recommendRecord.setRecommendationId("12121131231");
		recommendRecordMapper.insertSelective(recommendRecord);
	}



	@Test
	public void testUpdateByPrimaryKeySelective() {
		RecommendRecord recommendRecord = new RecommendRecord();
		recommendRecord.setId(2);
		recommendRecord.setGroupId(123);
		recommendRecord.setRecommendationId("231");
		recommendRecordMapper.updateByPrimaryKeySelective(recommendRecord);
	}

	
	@Test
	public void testDeleteByPrimaryKey() {

		recommendRecordMapper.deleteByPrimaryKey(3);
	}

	@Test
	public void testSelectByPrimaryKey() {
		RecommendRecord recommendRecord =  recommendRecordMapper.selectByPrimaryKey(2);
		System.out.println(recommendRecord.getRecommendationId());
	}

	@Test
	public void testSelectOneByModel() {
		RecommendRecord recommendRecord = new RecommendRecord();
		recommendRecord.setGroupId(123);
		recommendRecord.setRecommendationId("231");
		RecommendRecord recommendRecord2 = recommendRecordMapper.selectOneByModel(recommendRecord);
		System.out.println(recommendRecord2.getId());
	}

	@Test
	public void testSelectAllByModel() {
		RecommendRecord recommendRecord = new RecommendRecord();
		recommendRecord.setGroupId(1122121);
		recommendRecord.setRecommendationId("12121131231");
		List<RecommendRecord> recommendRecords = recommendRecordMapper.selectAllByModel(recommendRecord);
		for(RecommendRecord r : recommendRecords){
			System.out.println(r.getId());
		}

	}

	@Test
	public void testSelectAll() {
		List<RecommendRecord> recommendRecords = recommendRecordMapper.selectAll();
		for(RecommendRecord r : recommendRecords){
			System.out.println(r.getId());
		}
	}*/

}
