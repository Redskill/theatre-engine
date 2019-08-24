package com.fabio.theatre.theatreengine.service;

import com.fabio.theatre.theatreengine.database.entity.Customer;
import com.fabio.theatre.theatreengine.database.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAllCustomers() {
        List<Customer> list = customerRepository.findAll();
        Customer fabio = list.get(0);
        List<Customer> nueList = new ArrayList<>();
        nueList.add(fabio);
        nueList.add(fabio);
        nueList.add(fabio);
        nueList.add(fabio);
        return nueList;
        // return customerRepository.findAll();
    }

//    private List<Booking> aMethod(Integer customerId) {
//        List<Booking> bookingList = bookingRepository.findAll();
//        List<Booking> customerBooking = new ArrayList<>();
//
//        bookingList.forEach(booking -> {
//            if (booking.getCustomer().getId() == customerId) {
//                customerBooking.add(booking);
//            }
//        });
//        List<Booking> bookingStram = bookingList.stream()
//                .filter(e -> e.getCustomer().getId() == customerId)
//                .collect(Collectors.toList());
//
//        for (Booking booking : bookingList) {
//            if (booking.getCustomer().getId() == customerId) {
//                customerBooking.add(booking);
//            }
//        }
//        return customerBooking;
//    }

    public Customer getCustomerById(Integer id) {
        return customerRepository.findById(id).orElseThrow(RuntimeException::new);
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

    public Customer saveCustomer(Customer customer) {
        customerRepository.save(customer);
        return customer;
    }
}
