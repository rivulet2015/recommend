package com.alfago.weixin.common.freemarker;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/spring/applicationContext.xml"})
public class FreeMarkerWorkerTest {

	@Resource(name="freeMarkerWorker")
	FreeMarkerWorker freeMarkerWorker;
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
/*
	@Test
	public void testGetTemplate() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetFreemarkerConfig() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetFreemarkerConfig() {
		fail("Not yet implemented");
	}

	@Test
	public void testPrintFile() {
		fail("Not yet implemented");
	}



	@Test
	public void testPrintConsole() {
		fail("Not yet implemented");
	}

	@Test
	public void testRenderTemplateAtLocation() {
		fail("Not yet implemented");
	}

	@Test
	public void testRenderTemplateStringMapOfStringObjectAppendable() {
		fail("Not yet implemented");
	}
*/
	@Test
	public void testPrintString() {
		//System.out.print(freeMarkerWorker.printString("test.ftl", ));
	}
	
	@Test
	public void testRenderTemplateTemplateMapOfStringObjectAppendable() {
	//	System.out.print("***************"+this.freeMarkerWorker+"**********************");
	}

}
