package com.fabio.theatre.theatreengine.database.entity

import javax.persistence.*

@Entity
data class SystemUser (@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
                       val id: Int,
                       val email : String,
                       val password : String)