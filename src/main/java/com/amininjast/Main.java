package com.amininjast;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class Main {

    public static void main(String[] args) {

        ConfigurableApplicationContext applicationContext = SpringApplication.run(Main.class, args);
        printBeanNames(applicationContext);
    }

    private static void printBeanNames(ConfigurableApplicationContext applicationContext) {
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String a : beanDefinitionNames) {
            System.out.println(a);
        }
    }

    @Bean("foo")
    public Foo getFoo() {
        return new Foo("this is Foo");
    }

    record Foo(String name) {
    }

}
