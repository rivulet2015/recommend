package com.alfago.weixin.common.message.rabbitmq;

import javax.annotation.Resource;

import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.spi.LoggingEvent;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;

public class LogAppender extends AppenderSkeleton {
	
	@Resource
    AmqpTemplate amqpTemplate;
    
	public void close() {
	
		
	}

	public boolean requiresLayout() {
		
		return false;
	}

	@Override
	protected void append(LoggingEvent event) {

	}

}
