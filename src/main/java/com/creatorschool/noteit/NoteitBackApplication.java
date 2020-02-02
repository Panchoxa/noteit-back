package com.creatorschool.noteit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


@SpringBootApplication(scanBasePackages={"com.creatorschool.noteit"})
public class NoteitBackApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(NoteitBackApplication.class, args);
    }

}
