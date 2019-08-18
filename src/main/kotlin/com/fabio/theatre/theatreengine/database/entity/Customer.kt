package com.fabio.theatre.theatreengine.database.entity

import javax.persistence.*

@Entity
data class Customer (@Id
                     @GeneratedValue(strategy= GenerationType.IDENTITY)
                     val id: Int,
                     val first_name: String,
                     val lastName: String,
                     val email: String)