package com.amininjast.customer;

import com.amininjast.exception.DuplicateException;
import com.amininjast.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerDao customerDao;

    public CustomerService(@Qualifier("jpa") CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    public List<Customer> getAllCustomers() {
        return customerDao.selectAllCustomers();
    }

    public Customer getCustomer(Integer id) {
        return customerDao.selectCustomerById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "customer with id [%s] not found".formatted(id)));
    }

    public void addCustomer(
            CustomerRegisterationRequest customerRegisterationRequest) {
        //check if email exists
        if (customerDao.existPersonWithEmail(customerRegisterationRequest.email())) {
            throw new DuplicateException("email already exist");
        }
        //add
        Customer customer = new Customer(
                customerRegisterationRequest.age(),
                customerRegisterationRequest.name(),
                customerRegisterationRequest.email());
        customerDao.insertCustomer(customer);
    }

    public void deleteCustomer(Integer customerId) {
        if (!customerDao.existPersonWithId(customerId)) {
            throw new ResourceNotFoundException("in id nist");
        }
        customerDao.deleteCustomerById(customerId);
    }

    public void updateCustomer(Integer customerId) {
        if (!customerDao.existPersonWithId(customerId)) {
            throw new ResourceNotFoundException("in id nis");
        }
        customerDao.updateCustomerById(customerId);
    }
}
