package com.ergos.shawarmacloud_kitchen.kitchen;

import org.springframework.jms.support.converter.MessageConversionException;

import com.ergos.shawarmacloud_kitchen.model.ShawarmaOrder;

import jakarta.jms.JMSException;

public interface OrderReceiver {
    ShawarmaOrder receiveOrder() throws MessageConversionException, JMSException;
}
