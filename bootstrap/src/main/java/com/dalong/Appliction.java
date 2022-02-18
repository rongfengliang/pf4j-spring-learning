package com.dalong;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class Appliction {
    public  static ApplicationContext applicationContextGLobal;
    public static void main(String[] args) {
        applicationContextGLobal =  SpringApplication.run(Appliction.class);
    }
}
