package com.fabio.theatre.theatreengine.controller

import com.fabio.theatre.theatreengine.database.entity.Seat
import com.fabio.theatre.theatreengine.database.entity.Show
import com.fabio.theatre.theatreengine.database.entity.Venue
import com.fabio.theatre.theatreengine.service.SeatService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.persistence.Id

@RestController
@RequestMapping("/seat")

class SeatController {

  @Autowired
  lateinit var service : SeatService

  @GetMapping("/all")
  fun getAllseats(): List<Seat>{
    return service.allSeats
  }
  @GetMapping("/{id}")
  fun getSeat(@PathVariable id : Int) : Seat {
    return service.getSeatById(id)
  }

  @GetMapping("/available/{showId}/{showDate}")
  fun getAvailableSeats(@PathVariable showId: Int, @PathVariable showDate: String) : List<Seat> {
    return service.getAvailableSeats(showId, showDate)
  }


}




