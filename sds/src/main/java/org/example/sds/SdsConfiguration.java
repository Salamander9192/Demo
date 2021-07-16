package org.example.sds;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * @classname: SdsConfiguration
 * @description:
 * @author: jiadongrui
 * @create: 2021-07-16 11:10
 **/
@Configuration
@ComponentScan(value = "org.example.sds")
@ImportResource({"classpath*:conf/spring/spring-dubbo-server.xml"})
public class SdsConfiguration {
}
