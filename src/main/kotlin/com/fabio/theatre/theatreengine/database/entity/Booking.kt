package com.fabio.theatre.theatreengine.database.entity

import javax.persistence.*

@Entity
data class Booking(@Id
                   @GeneratedValue(strategy = GenerationType.IDENTITY)
                   val id: Int,

                   @ManyToOne
                   val customer: Customer,

                   @ManyToOne
                   val show: Show,

                   @ManyToOne
                   val seat: Seat)