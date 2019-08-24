package com.fabio.theatre.theatreengine.database.entity

import javax.persistence.*

@Entity
@Table(name = "venue")
data class Venue(@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
                 val id : Int,
                 val name : String,
                 val address: String) {
}