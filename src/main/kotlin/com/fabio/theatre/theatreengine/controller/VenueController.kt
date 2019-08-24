package com.fabio.theatre.theatreengine.controller

import com.fabio.theatre.theatreengine.database.entity.Venue
import com.fabio.theatre.theatreengine.service.VenueService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/venue")
class VenueController {

  @Autowired
  lateinit var service : VenueService

  @GetMapping("all")
  fun getVenues() : List<Venue> {
    return service.allVenues
  }

  @GetMapping("/{id}")
  fun getVenue(@PathVariable id : Int) : Venue {
    return service.getVenueById(id)
  }
}