package org.example.fmut.order;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * @classname: OrderConfiguration
 * @description:
 * @author: jiadongrui
 * @create: 2021-07-07 17:06
 **/
@Configuration
@ComponentScan(value = "org.example.fmut")
@ImportResource({"classpath*:conf/spring/spring-dubbo-consumer.xml"})
public class OrderConfiguration {
}
