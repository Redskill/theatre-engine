package com.fabio.theatre.theatreengine.database.entity

import java.time.LocalDate
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

data class Show(@Id
                @GeneratedValue(strategy = GenerationType.IDENTITY)
                val id: Int,
                val title: String,
                val venue_id: Venue,
                val description: String,
                val runtime: Int,
                val show_date: LocalDate) {
}