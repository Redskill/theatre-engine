package com.fabio.theatre.theatreengine.database.repository

//import com.fabio.theatre.theatreengine.database.entity.Booking
import com.fabio.theatre.theatreengine.database.entity.*
//import com.fabio.theatre.theatreengine.database.entity.Review
import org.springframework.data.jpa.repository.JpaRepository
import javax.persistence.Id

interface BookingRepository : JpaRepository<Booking, Int>
interface CustomerRepository : JpaRepository<Customer, Int>
interface ReviewRepository : JpaRepository<Review, Int>
interface SeatRepository : JpaRepository<Seat, Int>
interface ShowRepository : JpaRepository<Show, Int> {
  fun findByVenueId(id: Int) : List<Show>
  fun findByVenueIdAndGenre(id: Int, genre: String) : List<Show>
}
interface VenueRepository : JpaRepository<Venue, Int>
