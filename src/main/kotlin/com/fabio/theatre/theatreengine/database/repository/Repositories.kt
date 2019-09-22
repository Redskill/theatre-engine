package com.fabio.theatre.theatreengine.database.repository

//import com.fabio.theatre.theatreengine.database.entity.Booking
import com.fabio.theatre.theatreengine.database.entity.*
import com.fabio.theatre.theatreengine.database.entity.SystemUser
//import com.fabio.theatre.theatreengine.database.entity.Review
import org.springframework.data.jpa.repository.JpaRepository

interface BookingRepository : JpaRepository<Booking, Int> {
  fun findByShowId(id: Int) : List<Booking>
}
interface CustomerRepository : JpaRepository<Customer, Int> {
  fun findByEmail(email: String) : Customer
}
interface ReviewRepository : JpaRepository<Review, Int>
interface SeatRepository : JpaRepository<Seat, Int>
interface ShowRepository : JpaRepository<Show, Int> {
  fun findByVenueId(id: Int) : List<Show>
  fun findByVenueIdAndGenre(id: Int, genre: String) : List<Show>
}
interface VenueRepository : JpaRepository<Venue, Int>
interface SystemUserRepository : JpaRepository<SystemUser, String>
