package com.ergos.shawarmacloud_kitchen.kitchen;

import org.springframework.stereotype.Component;

import com.ergos.shawarmacloud_kitchen.model.ShawarmaOrder;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class KitchenUI {
    public void displayOrder(ShawarmaOrder order) {
        log.info("НОВЫЙ ЗАКАЗ:" + order);
    }
}
