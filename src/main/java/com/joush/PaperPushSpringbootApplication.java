package com.joush;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@SpringBootApplication
public class PaperPushSpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(PaperPushSpringbootApplication.class, args);
    }

}
