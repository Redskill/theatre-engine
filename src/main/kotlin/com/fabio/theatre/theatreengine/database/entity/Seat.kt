package com.fabio.theatre.theatreengine.database.entity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Seat(@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
                val id: Int,
                val row: String,
                val number: String,
                val description: String)