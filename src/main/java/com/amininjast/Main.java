package com.amininjast;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@SpringBootApplication
@RestController
public class Main {
    //db
    private static List<Customer> customers;

    static {
        customers = new ArrayList<>();
        Customer amin = new Customer(
                1,
                "Amin",
                "Amin@gmail.com",
                28
        );
        customers.add(amin);
        Customer maryam = new Customer(
                2,
                "maryam",
                "maryam@gmail.com",
                22
        );
        customers.add(maryam);
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    //    @RequestMapping(
//            path = "api/v1/customers" ,
//            method = RequestMethod.GET
//    )
    @GetMapping(path = "api/v1/customers")
    public List<Customer> getCustomers() {
        return customers;
    }

    static class Customer {
        private Integer age;
        private Integer id;
        private String name;
        private String email;

        public Customer() {
        }

        public Customer(Integer id, String name, String email, Integer age) {
            this.age = age;
            this.id = id;
            this.name = name;
            this.email = email;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Customer customer = (Customer) o;
            return Objects.equals(age, customer.age) && Objects.equals(id, customer.id) && Objects.equals(name, customer.name) && Objects.equals(email, customer.email);
        }

        @Override
        public int hashCode() {
            return Objects.hash(age, id, name, email);
        }

        @Override
        public String toString() {
            return "Customer{" +
                    "id=" + id +
                    ", name=" + name +
                    ", email='" + email + '\'' +
                    ", age='" + age + '\'' +
                    '}';
        }
    }
}
