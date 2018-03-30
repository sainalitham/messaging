package com.cvs.rxpace.messaging.controller;

import javax.jms.JMSException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cvs.rxpace.messaging.methods.SimpleMessageProducer;

@RestController
public class SenderController {
	
	@RequestMapping(value="/send" , method = RequestMethod.GET)
	public String sendMessage() {
		ApplicationContext context = new ClassPathXmlApplicationContext("/META_INF/spring/producer-jms-context.xml", SenderController.class);
        SimpleMessageProducer producer = (SimpleMessageProducer) context.getBean("messageProducer");
        
        try {
        		producer.sendMessage();
        		return "message sent";
        }
        catch(JMSException e) {
        		e.printStackTrace();
        		return "error";
        }
	}
}
