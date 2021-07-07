package org.example.fmut.order;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @classname: OrderApplication
 * @description:
 * @author: jiadongrui
 * @create: 2021-07-07 17:05
 **/
@SpringBootApplication
public class OrderApplication {

    public static void main(String[] args) {
        SpringApplication appl = new SpringApplication(OrderApplication.class);
        appl.setBannerMode(Banner.Mode.OFF);
        appl.run(args);
    }
}
