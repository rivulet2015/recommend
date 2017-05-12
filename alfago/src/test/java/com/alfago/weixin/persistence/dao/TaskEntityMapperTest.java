package com.alfago.weixin.persistence.dao;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alfago.weixin.common.beans.RecommendRecord;
import com.alfago.weixin.common.beans.TaskEntity;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/spring/applicationContext.xml"})
public class TaskEntityMapperTest {

	@Resource
	private TaskEntityMapper taskEntityMapper;
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	@Test
	public void testUpdateByPrimaryKeySelective() {

	}
	
/*	@Test
	public void testInsertSelective() {
		TaskEntity taskEntity = new TaskEntity();
		taskEntity.setCreater("cadawew");
		taskEntity.setRecommendRecordId(123);
		taskEntity.setState(0);
		taskEntityMapper.insertSelective(taskEntity);
	}
	

	@Test
	public void testUpdateByPrimaryKeySelective() {
		TaskEntity taskEntity = new TaskEntity();
		taskEntity.setId(2);
		taskEntity.setCreater("wwwwwwwwwwwwwww");
		taskEntity.setRecommendRecordId(1111111111);
		taskEntity.setState(0);
		taskEntityMapper.updateByPrimaryKeySelective(taskEntity);
	}

	@Test
	public void testDeleteByPrimaryKey() {
		taskEntityMapper.deleteByPrimaryKey(2);
	}

	@Test
	public void testSelectByPrimaryKey() {

		TaskEntity taskEntity = taskEntityMapper.selectByPrimaryKey(3);
		System.out.println(taskEntity.getRecommendRecordId());
	}

	@Test
	public void testSelectOneByModel() {
		TaskEntity taskEntity = new TaskEntity();
		taskEntity.setCreater("cadawew");
		taskEntity.setRecommendRecordId(123);
		taskEntity.setState(0);
		TaskEntity taskEntity2 = taskEntityMapper.selectOneByModel(taskEntity);
		System.out.println(taskEntity2.getId());
	}

	@Test
	public void testSelectAllByModel() {
		TaskEntity taskEntity = new TaskEntity();
		taskEntity.setCreater("cadawew");
		taskEntity.setRecommendRecordId(123);
		taskEntity.setState(0);
		List<TaskEntity> taskEntitys = taskEntityMapper.selectAllByModel(taskEntity);
		for(TaskEntity t:taskEntitys){
			System.out.println(t.getId());
		}
		
	}

	@Test
	public void testSelectAll() {
		List<TaskEntity> taskEntitys = taskEntityMapper.selectAll();
		for(TaskEntity t:taskEntitys){
			System.out.println(t.getId());
		}
	}*/

}
