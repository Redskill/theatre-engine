package com.fabio.theatre.theatreengine.controller

import com.fabio.theatre.theatreengine.database.entity.Customer
import com.fabio.theatre.theatreengine.service.CustomerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/customer")
class CustomerController {

    @Autowired
    lateinit var service : CustomerService

    @GetMapping("/all")
    fun getAllCustomers() : List<Customer> {
        return service.allCustomers
    }

    @GetMapping("/{id}")
    fun getCustomer(@PathVariable id: Int) : Customer {
        return service.getCustomerById(id)
    }

    @DeleteMapping("/{id}")
    fun deleteCustomer(@PathVariable id: Int) {
        service.deleteById(id)
    }

    @PostMapping
    fun updateCustomer(@RequestBody customer: Customer) : Customer {
        return service.updateCustomer(customer)
    }

    @PutMapping
    fun saveCustomer(@RequestBody customer: Customer) : Customer {
        return service.saveCustomer(customer)
    }
}