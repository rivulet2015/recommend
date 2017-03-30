package com.alfago.weixin.common.message.rabbitmq;

import javax.annotation.Resource;

import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.spi.LoggingEvent;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.stereotype.Component;
@Component
public class LogAppender extends AppenderSkeleton {
	
	@Resource
    public AmqpTemplate amqpTemplate;

	public AmqpTemplate getAmqpTemplate() {
		return amqpTemplate;
	}

	public void setAmqpTemplate(AmqpTemplate amqpTemplate) {
		this.amqpTemplate = amqpTemplate;
	}

	public void close() {
	
		
	}

	public boolean requiresLayout() {
		
		return false;
	}

	@Override
	protected void append(LoggingEvent event) {

		final int priority = event.getLevel().toInt();
		amqpTemplate.convertAndSend(event, new MessagePostProcessor(){

			public Message postProcessMessage(Message message)
					throws AmqpException {
				message.getMessageProperties().setPriority(priority);  
				return message;
			}
			
		});
	}

}
