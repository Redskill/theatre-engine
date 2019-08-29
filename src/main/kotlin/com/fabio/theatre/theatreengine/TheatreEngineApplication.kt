package com.fabio.theatre.theatreengine

import com.fabio.theatre.theatreengine.dummydata.DummyData
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class TheatreEngineApplication

// TODO delete after tests
@Autowired
lateinit var data: DummyData

fun main(args: Array<String>) {
    runApplication<TheatreEngineApplication>(*args)
}
