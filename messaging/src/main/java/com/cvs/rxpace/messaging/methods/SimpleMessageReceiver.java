package com.cvs.rxpace.messaging.methods;

import org.springframework.jms.core.JmsTemplate;

import com.cvs.rxpace.messaging.model.Patient;

public class SimpleMessageReceiver {
protected JmsTemplate jmsTemplate; 
    
    public JmsTemplate getJmsTemplate() {
		return jmsTemplate;
	}

	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}
	
	public Patient jmsReceive() {
		Patient message = (Patient) jmsTemplate.receiveAndConvert();
		return message;
    }
	

}
