package org.example.fmut.guard.cli;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @classname: GuardCliConfiguration
 * @description:
 * @author: jiadongrui
 * @create: 2021-07-07 13:50
 **/
@Configuration
@PropertySource(value = "classpath:/conf.properties",factory = RemotePropertySourceFactory.class)
public class GuardCliConfiguration {
}
