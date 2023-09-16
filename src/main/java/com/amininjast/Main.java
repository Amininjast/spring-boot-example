package com.amininjast;

import com.amininjast.customer.Customer;
import com.amininjast.customer.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;


@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    CommandLineRunner runner(CustomerRepository customerRepository) {
        return args -> {
            Customer amin = new Customer(
                    1,
                    "Amin",
                    "Amin@gmail.com",
                    28
            );
            Customer maryam = new Customer(
                    2,
                    "maryam",
                    "maryam@gmail.com",
                    22
            );
            List<Customer> customers = List.of(amin, maryam);
            customerRepository.saveAll(customers);
        };
    }
}
