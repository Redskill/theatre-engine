package com.fabio.theatre.theatreengine.service;

import com.fabio.theatre.theatreengine.database.entity.Customer;
import com.fabio.theatre.theatreengine.database.entity.SystemUser;
import com.fabio.theatre.theatreengine.database.model.NewCustomer;
import com.fabio.theatre.theatreengine.database.repository.CustomerRepository;
import com.fabio.theatre.theatreengine.database.repository.SystemUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private SystemUserRepository systemUserRepository;

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomerById(Integer id) {
        return customerRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    public Customer getCustomerByEmail(String email) {
        return customerRepository.findByEmail(email);
    }

    public void deleteById(Integer id) {
        Optional<Customer> customer = customerRepository.findById(id);
        if (customer.isPresent()) {
            customerRepository.deleteById(id);
        }
    }

    public Customer updateCustomer(Customer customer) {
        customerRepository.save(customer);
        return customer;
    }

    public Customer saveCustomer(NewCustomer customer) {
        systemUserRepository.save(new SystemUser(99 ,customer.getCustomer().getEmail(), customer.getPassword()));
        return customerRepository.save(customer.getCustomer());
    }
}
