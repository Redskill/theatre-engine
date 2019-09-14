package com.fabio.theatre.theatreengine.controller

import com.fabio.theatre.theatreengine.database.entity.Show
import com.fabio.theatre.theatreengine.service.ShowService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/show")
class ShowController {

  @Autowired
  lateinit var service: ShowService

  @GetMapping("/all")
  fun getShows() : List<Show> {
    return  service.allshows
  }

  @GetMapping("/{id}")
  fun getShow(@PathVariable id : Int) : Show {
    return service.getShowById(id)
  }

  @GetMapping("/{id}/{genre}")
  fun getShowByVenueAndGenre(@PathVariable id: Int, @PathVariable genre: String) : List<Show> {
    return service.findShowByVenueIdAndGenre(id, genre)
  }

  @DeleteMapping("/{id}")
  fun deleteShow(@PathVariable id: Int) {
    service.deleteShow(id)
  }

}