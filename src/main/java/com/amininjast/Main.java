package com.amininjast;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;


@SpringBootApplication
@RestController
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @GetMapping("/greet")
    public GreetResponse greet(
            @RequestParam(
                    value = "name", required = false) String name) {
        String greetMessage = name == null || name.isBlank() ? "Hello" : "Hello " + name;
        GreetResponse response = new GreetResponse(
                greetMessage,
                List.of("Java", "Golang", "JavaScript"),
                new Person("Amin", 28, 100_000)
        );
        return response;
    }

    class Customer {
        private Integer age;
        private Integer id;
        private String name;
        private String email;

        public Customer() {
        }

        public Customer(Integer age, Integer id, String name, String email) {
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
                    "age=" + age +
                    ", id=" + id +
                    ", name='" + name + '\'' +
                    ", email='" + email + '\'' +
                    '}';
        }
    }

    record Person(String name, int age, double savings) {
    }

    record GreetResponse(
            String greet,
            List<String> favProgrammingLanguages,
            Person person
    ) {
    }
}
