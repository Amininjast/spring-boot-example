package com.amininjast;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
public class Main {

    public static void main(String[] args) {

        ConfigurableApplicationContext applicationContext = SpringApplication.run(Main.class, args);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String a : beanDefinitionNames) {
            System.out.println(a);
        }

    }

}
