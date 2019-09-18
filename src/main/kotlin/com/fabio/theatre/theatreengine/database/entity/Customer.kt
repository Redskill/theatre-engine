package com.fabio.theatre.theatreengine.database.entity

import javax.persistence.*


@Entity
data class Customer (@Id
                     @GeneratedValue(strategy= GenerationType.IDENTITY)
                     val id: Int,
                     val first_name: String,
                     val last_name: String,
                     val email: String)