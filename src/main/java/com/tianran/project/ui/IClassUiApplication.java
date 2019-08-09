package com.tianran.project.ui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.stereotype.Controller;


@SpringBootApplication
@EnableZuulProxy
@Controller
public class IClassUiApplication {
    public static void main(String[] args) {
        SpringApplication.run(IClassUiApplication.class, args);
    }

}
