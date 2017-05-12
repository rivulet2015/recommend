package com.alfago.weixin.common.message.rabbitmq;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/spring/applicationContext.xml"})
public class LogAppenderTest {

/*	@Resource
    public AmqpTemplate amqpTemplate;*/
	
	private Logger logger = Logger.getLogger("wwwww");
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testAppendLoggingEvent() {
/*		String message = "test";
		for(long i=0;i<5L;i++){
			amqpTemplate.convertAndSend((Object)message,new MessagePostProcessor(){

				public Message postProcessMessage(Message message)
						throws AmqpException {
					message.getMessageProperties().setPriority(10);  
					return message;
				}
				
				
			});			
		}*/

	}

}
