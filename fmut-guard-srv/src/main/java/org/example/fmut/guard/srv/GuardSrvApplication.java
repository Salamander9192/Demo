package org.example.fmut.guard.srv;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @classname: GuardSrvApplication
 * @description:
 * @author: jiadongrui
 * @create: 2021-07-06 12:52
 **/
@SpringBootApplication
public class GuardSrvApplication {

    public static void main(String[] args) {
        SpringApplication appl = new SpringApplication(GuardSrvApplication.class);
        appl.setBannerMode(Banner.Mode.OFF);
        appl.run(args);
    }
}
