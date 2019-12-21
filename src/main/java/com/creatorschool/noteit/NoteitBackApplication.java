package com.creatorschool.noteit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages={"com.creatorschool.noteit"})
public class NoteitBackApplication {

    public static void main(String[] args) {
        SpringApplication.run(NoteitBackApplication.class, args);
    }

}
