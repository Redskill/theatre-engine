package com.fabio.theatre.theatreengine.database.entity

import javax.persistence.*

data class Booking(@Id
                   @GeneratedValue(strategy = GenerationType.IDENTITY)
                   val id: Int,

                   @ManyToOne
                   val customer_id: Customer,

                   @ManyToOne
                   val show_id: Show,

                   @ManyToOne
                   val seat_id: Seat)