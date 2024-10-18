package com.ergos.shawarmacloud_kitchen.kitchen.messaging.jms;

import org.springframework.context.annotation.Profile;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MessageConversionException;
import org.springframework.stereotype.Component;

import com.ergos.shawarmacloud_kitchen.kitchen.OrderReceiver;
import com.ergos.shawarmacloud_kitchen.model.ShawarmaOrder;

import jakarta.jms.Destination;
import jakarta.jms.JMSException;

//@Profile("jms-template")
@Component
public class JmsOrderReceiver implements OrderReceiver{
    
    private JmsTemplate jmsTemplate;
    private Destination destination;

    public JmsOrderReceiver(JmsTemplate jmsTemplate, Destination destination) {
        this.jmsTemplate = jmsTemplate;
        this.destination = destination;
    }

    @Override
    public ShawarmaOrder receiveOrder() throws MessageConversionException, JMSException {
        return (ShawarmaOrder) jmsTemplate.receiveAndConvert(destination);
    }
}
