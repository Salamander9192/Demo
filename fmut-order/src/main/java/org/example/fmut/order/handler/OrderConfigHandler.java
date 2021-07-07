package org.example.fmut.order.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @classname: OrderConfigHandler
 * @description:
 * @author: jiadongrui
 * @create: 2021-07-07 17:24
 **/
@Component
public class OrderConfigHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderConfigHandler.class);

    @Value("${order1.name}")
    private String orderName;

    @PostConstruct
    public void init(){
        LOGGER.info("test config : orderName=[{}]",orderName);
    }

}
