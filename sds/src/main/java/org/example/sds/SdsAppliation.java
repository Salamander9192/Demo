package org.example.sds;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @classname: SdsAppliation
 * @description:
 * @author: jiadongrui
 * @create: 2021-07-16 11:10
 **/
@SpringBootApplication
public class SdsAppliation {

    public static void main(String[] args) {
        SpringApplication appl = new SpringApplication(SdsAppliation.class);
        appl.setBannerMode(Banner.Mode.OFF);
        appl.run(args);
    }
}
