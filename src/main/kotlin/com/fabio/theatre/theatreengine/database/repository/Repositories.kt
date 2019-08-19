package com.fabio.theatre.theatreengine.database.repository

//import com.fabio.theatre.theatreengine.database.entity.Booking
import com.fabio.theatre.theatreengine.database.entity.*
//import com.fabio.theatre.theatreengine.database.entity.Review
import org.springframework.data.jpa.repository.JpaRepository

interface BookingRepository : JpaRepository<Booking, Int>
interface CustomerRepository : JpaRepository<Customer, Int>
interface ReviewRepository : JpaRepository<Review, Int>
interface SeatRepository : JpaRepository<Seat, Int>
interface ShowRepository : JpaRepository<Show, Int>
interface VenueRepository : JpaRepository<Venue, Int>
