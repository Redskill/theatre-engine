package com.fabio.theatre.theatreengine.controller

import com.fabio.theatre.theatreengine.database.entity.Booking
import com.fabio.theatre.theatreengine.service.BookingService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/booking")
class BookingController {

  @Autowired
  lateinit var service: BookingService

  @GetMapping
  fun getAllBookings() : List<Booking> {
    return ArrayList(service.getAllBookings())
  }

  @GetMapping("/{id}")
  fun getBooking(@PathVariable id: Int) : Booking {
    return service.getBooking(id)
  }

  @DeleteMapping("/{id}")
  fun deleteBooking(@PathVariable id: Int) {
    service.deleteBooking(id)
  }

  @PostMapping()
  fun createBooking(@RequestBody booking: Booking) : Booking {
    return service.createBooking(booking)
  }

  @GetMapping("/user/{id}")
  fun getBookingForCustomer(@PathVariable id: Int) : List<Booking> {
    return service.getBookingPerUserID(id)
  }

}