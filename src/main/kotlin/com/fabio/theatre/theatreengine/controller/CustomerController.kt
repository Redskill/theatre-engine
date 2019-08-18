package com.fabio.theatre.theatreengine.controller

import com.fabio.theatre.theatreengine.database.entity.Customer
import com.fabio.theatre.theatreengine.database.repository.CustomerRepository
import com.fabio.theatre.theatreengine.service.Bla
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/customer")
class CustomerController {

//    @Autowired
//    lateinit var repository : CustomerRepository

    @Autowired
    lateinit var service : Bla


    // READ from DB
    @GetMapping
    fun getCustomer() : List<Customer> {
        return service.myList
    }

//    @PostMapping
//        @DeleteMapping


}