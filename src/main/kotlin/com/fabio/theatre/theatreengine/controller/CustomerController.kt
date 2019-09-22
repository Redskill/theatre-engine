package com.fabio.theatre.theatreengine.controller

import com.fabio.theatre.theatreengine.database.entity.Customer
import com.fabio.theatre.theatreengine.database.entity.SystemUser
import com.fabio.theatre.theatreengine.database.model.NewCustomer
import com.fabio.theatre.theatreengine.exceptions.LoginNotValidException
import com.fabio.theatre.theatreengine.service.CustomerService
import com.fabio.theatre.theatreengine.service.SystemUserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/customer")
class CustomerController {

    @Autowired
    lateinit var service : CustomerService

    @Autowired
    lateinit var systemUserService : SystemUserService

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

    @PutMapping
    fun updateCustomer(@RequestBody customer: Customer) : Customer {
        return service.updateCustomer(customer)
    }

    @PostMapping("/login")
    fun authUser(@RequestBody systemUser : SystemUser) : Customer {
        if (!systemUserService.checkAuth(systemUser)) {
            throw LoginNotValidException("Invalid username or password. Retry.");
        }
        return service.getCustomerByEmail(systemUser.email)
    }

    @PostMapping
    fun saveCustomer(@RequestBody customer: NewCustomer) : Customer {
        return service.saveCustomer(customer)
    }
}