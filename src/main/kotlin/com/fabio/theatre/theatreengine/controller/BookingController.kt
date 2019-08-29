package com.fabio.theatre.theatreengine.controller

import com.fabio.theatre.theatreengine.database.entity.Booking
import com.fabio.theatre.theatreengine.service.BookingService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

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
}