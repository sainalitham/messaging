package com.cvs.rxpace.messaging.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cvs.rxpace.messaging.methods.SimpleMessageReceiver;
import com.cvs.rxpace.messaging.model.Patient;

@RestController
public class ReceiverController {
	
	@RequestMapping(value="/receive" , method = RequestMethod.GET)
	public Patient receiveMessage() {

		ApplicationContext context = new ClassPathXmlApplicationContext("/META_INF/spring/consumer-jms-context.xml",
				ReceiverController.class);
		SimpleMessageReceiver receiver = (SimpleMessageReceiver) context.getBean("messageReceiver");
		Patient patient = receiver.jmsReceive();
		return patient;
	}
}
