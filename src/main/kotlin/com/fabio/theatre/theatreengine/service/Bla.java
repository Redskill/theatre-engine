package com.fabio.theatre.theatreengine.service;

import com.fabio.theatre.theatreengine.database.entity.Customer;
import com.fabio.theatre.theatreengine.database.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Bla {

    @Autowired
    private CustomerRepository repository;

    public List<Customer> getMyList() {
        List<Customer> list = repository.findAll();
        Customer fabio = list.get(0);
        List<Customer> nueList = new ArrayList<>();
        nueList.add(fabio);
        nueList.add(fabio);
        nueList.add(fabio);
        nueList.add(fabio);
        return nueList;
    }
}
