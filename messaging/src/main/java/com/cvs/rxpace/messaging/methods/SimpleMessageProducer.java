package com.cvs.rxpace.messaging.methods;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import com.cvs.rxpace.messaging.model.Patient;

public class SimpleMessageProducer {
    
    protected JmsTemplate jmsTemplate; 
    
    public JmsTemplate getJmsTemplate() {
		return jmsTemplate;
	}

	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}

	public void sendMessage() throws JMSException {
        	
		final Patient patient = new Patient(123,"eskay");
		
            jmsTemplate.send(new MessageCreator() {
                public Message createMessage(Session session) throws JMSException {
                    ObjectMessage message = session.createObjectMessage(patient); 
                    return message;
                }
            });
        
	}
}
