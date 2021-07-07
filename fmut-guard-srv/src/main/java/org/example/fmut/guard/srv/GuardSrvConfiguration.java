package org.example.fmut.guard.srv;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @classname: GuardSrvConfiguration
 * @description:
 * @author: jiadongrui
 * @create: 2021-07-06 13:36
 **/
@Configuration
@ComponentScan("org.example.fmut.guard.srv")
@PropertySource("classpath:/conf.properties")
public class GuardSrvConfiguration {
}
