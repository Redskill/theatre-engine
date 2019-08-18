package com.fabio.theatre.theatreengine.database.entity

import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

data class Venue(@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
                 val id : Int,
                 val name : String,
                 val address: String) {
}