package com.fabio.theatre.theatreengine.controller

import com.fabio.theatre.theatreengine.database.entity.Show
import com.fabio.theatre.theatreengine.service.ShowService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/show")
class ShowController {

  @Autowired
  lateinit var service: ShowService

  @GetMapping("/all")
  fun getShow() : List<Show> {
    return  service.allshows
  }

}