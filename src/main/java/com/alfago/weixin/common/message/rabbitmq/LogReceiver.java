package com.alfago.weixin.common.message.rabbitmq;

import java.io.UnsupportedEncodingException;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

public class LogReceiver implements MessageListener{

	public void onMessage(Message message) {
	    try {
			System.out.print("[x]  接收到的消息："+new String(message.getBody(),"utf-8")+"&&&"+"优先级"+message.getMessageProperties().getPriority());
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		
	}

}
