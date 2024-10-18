package com.ergos.shawarmacloud_kitchen.kitchen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;

import com.ergos.shawarmacloud_kitchen.model.ShawarmaOrder;

import jakarta.jms.JMSException;


//@Profile({"jms-template", "rabbitmq-template"})
@Controller
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderReceiverController {
    private OrderReceiver receiver;
    @Autowired
    public OrderReceiverController(OrderReceiver receiver) {
        this.receiver = receiver;
    }

    @GetMapping("/receive")
    public String receiveOrder(Model model) throws JMSException{
        ShawarmaOrder order = receiver.receiveOrder();
        if (order != null) {
            model.addAttribute("order", order);
            return "receiveOrder";
        }
        return "noOrder";
    }
    
}
