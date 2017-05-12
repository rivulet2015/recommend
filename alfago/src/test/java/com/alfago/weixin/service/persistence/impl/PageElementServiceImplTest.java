package com.alfago.weixin.service.persistence.impl;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alfago.weixin.common.entitys.PageElementEntity;
import com.alfago.weixin.service.persistence.PageElementService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/spring/applicationContext.xml"})
public class PageElementServiceImplTest {

	@Resource(name="pageElementService")
	private PageElementService pageElementService;
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testInsert() {
		PageElementEntity e = new PageElementEntity();
		e.setKeyname("aaa");
		e.setModuleId(11);
		e.setPageId(12);
		e.setValue("bbb");
		pageElementService.insert(e);
	}

/*	@Test
	public void testUpdate() {
		PageElementEntity e = new PageElementEntity();
		e.setId(1);
		e.setKeyname("ccc");
		e.setModuleId(11);
		e.setPageId(12);
		e.setValue("bbb");
		pageElementService.update(e);
	}

	@Test
	public void testDelete() {
		PageElementEntity e = new PageElementEntity();
		e.setId(1);
		e.setKeyname("ccc");
		e.setModuleId(11);
		e.setPageId(12);
		e.setValue("bbb");
		pageElementService.delete(1);
	}

	@Test
	public void testSelectById() {
		pageElementService.delete(1);
	}

	@Test
	public void testSelectOne() {
		PageElementEntity e = new PageElementEntity();
		e.setId(1);
		e.setKeyname("ccc");
		e.setModuleId(11);
		e.setPageId(12);
		e.setValue("bbb");
		pageElementService.selectOne(e);
	}

	@Test
	public void testSelectList() {
		PageElementEntity e = new PageElementEntity();
		e.setId(1);
		e.setKeyname("ccc");
		e.setModuleId(11);
		e.setPageId(12);
		e.setValue("bbb");
		pageElementService.selectList(e);
	}*/

	@Test
	public void testSelectPage() {

	}

}
