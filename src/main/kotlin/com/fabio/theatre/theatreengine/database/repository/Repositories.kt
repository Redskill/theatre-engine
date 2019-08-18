package com.fabio.theatre.theatreengine.database.repository

//import com.fabio.theatre.theatreengine.database.entity.Booking
import com.fabio.theatre.theatreengine.database.entity.Booking
import com.fabio.theatre.theatreengine.database.entity.Customer
import com.fabio.theatre.theatreengine.database.entity.Review
//import com.fabio.theatre.theatreengine.database.entity.Review
import com.fabio.theatre.theatreengine.database.entity.Seat
import org.springframework.data.jpa.repository.JpaRepository

interface BookingRepository : JpaRepository<Booking, Int>
interface ReviewRepository : JpaRepository<Review, Int>
interface CustomerRepository : JpaRepository<Customer, Int>
interface SeatRepository : JpaRepository<Seat, Int>


