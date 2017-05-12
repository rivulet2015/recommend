package com.alfago.weixin.service.mail.test;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alfago.weixin.common.freemarker.FreeMarkerWorker;
import com.alfago.weixin.service.mail.MailService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/spring/applicationContext.xml"})
public class MailServiceTest {

	@Resource(name="mailService")
	private MailService mailService;
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
 }

	@Test
	public void testSetMailSender() {
	
	}
	
	@Test
	public void sendHtmlEmail() throws Exception {
	//	mailService.sendHtmlEmail("601838594@qq.com", "fullbenhouse@126.com", "test", "test.ftl");
		//mailService.sendMail("601838594@qq.com", "fullbenhouse@126.com", "test", "test.html");
	}	
	
	@Test
	public void testSendMail() throws Exception {
		//mailService.sendMail("1234@126.com", "fullbenhouse@126.com", "test", "test");
		//mailService.sendActivedMsg(123, "fullbenhouse@126.com", "rivulet", "rivulet", "rivulet");
	}
	
	@Test
	public void testSendActivedMsg() throws Exception {
		//mailService.sendMail("1234@126.com", "fullbenhouse@126.com", "test", "test");
		//mailService.sendActivedMsg(123, "fullbenhouse@126.com", "rivulet", "rivulet", "rivulet",1);
	}

}
