package com.amininjast.customer;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class CustomerListDataAccessServise implements CustomerDao {

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

    @Override
    public List<Customer> selectAllCustomers() {
        return customers;
    }

    @Override
    public Optional<Customer> selectCustomerById(Integer id) {
        return customers.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst();
    }
}
