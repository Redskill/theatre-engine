package com.fabio.theatre.theatreengine.database.entity

import java.time.LocalDate
import javax.persistence.*

@Entity
data class Show(@Id
                @GeneratedValue(strategy = GenerationType.IDENTITY)
                val id: Int,
                val title: String,

                @ManyToOne
                val venue: Venue,
                val description: String,
                val runtime: Int,
                val show_date: LocalDate) {
}