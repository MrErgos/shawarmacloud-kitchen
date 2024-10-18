package com.ergos.shawarmacloud_kitchen.kitchen.messaging.jms.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.activemq.artemis.jms.client.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;

import com.ergos.shawarmacloud_kitchen.model.ShawarmaOrder;

import jakarta.jms.Destination;

//@Profile({"jms-template", "jms-listener"})
@Configuration
public class MessagingConfig {
    @Bean
    public Destination orderQueue() {
        return new ActiveMQQueue("shawarmacloud.order.queue");
    }

    @Bean
    public MappingJackson2MessageConverter messageConverter() {
        MappingJackson2MessageConverter messageConverter = new MappingJackson2MessageConverter();
        messageConverter.setTypeIdPropertyName("_typeId");

        Map<String, Class<?>> typeIdMappings = new HashMap<>();
        typeIdMappings.put("order", ShawarmaOrder.class);
        messageConverter.setTypeIdMappings(typeIdMappings);

        return messageConverter;
    }
}
