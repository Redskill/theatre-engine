package com.fabio.theatre.theatreengine.controller

import com.fabio.theatre.theatreengine.database.entity.Customer
import com.fabio.theatre.theatreengine.database.repository.CustomerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/customer")
class CustomerController {

    @Autowired
    lateinit var repository : CustomerRepository

    @GetMapping
    fun getCustomer() : List<Customer> {
        return repository.findAll()
    }
}