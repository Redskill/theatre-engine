package com.fabio.theatre.theatreengine.service

import com.fabio.theatre.theatreengine.database.entity.Booking
import com.fabio.theatre.theatreengine.database.repository.BookingRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class BookingService {

  @Autowired
  lateinit var repository: BookingRepository

  fun getAllBookings(): MutableList<Booking> {
    return repository.findAll()
  }

  fun getBooking(id: Int): Booking {
    return repository.findById(id).let { return it.get() }
  }

  fun deleteBooking(id: Int) : Unit {
    repository.findById(id).let { repository.delete(it.get()) }
  }

  fun updateBooking(booking: Booking) : Booking {
    var booking = repository.findById(booking.id)
    booking.let { repository.save(it.get()) }
    return booking.get();
  }

  fun createBooking(booking: Booking) : Booking {
    return repository.save(booking)
  }

  fun getBookingsByShowId(id: Int) : List<Booking> {
    return repository.findByShowId(id)
  }

  fun getBookingPerUserID(id: Int) : List<Booking> {
    return repository.findByCustomer_Id(id)
  }
}