package com.amininjast.customer;

import java.util.List;
import java.util.Optional;


public interface CustomerDao {
    List<Customer> selectAllCustomers();

    Optional<Customer> selectCustomerById(Integer id);

    void insertCustomer(Customer customer);

    boolean existPersonWithEmail(String email);

    boolean existPersonWithId(Integer id);

    void deleteCustomerById(Integer id);

    void updateCustomerById(Integer id);
}
