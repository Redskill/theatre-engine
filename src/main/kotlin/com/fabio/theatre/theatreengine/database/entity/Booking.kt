//package com.fabio.theatre.theatreengine.database.entity
//
//import javax.persistence.*
//
//data class Booking(@Id
//                   @GeneratedValue(strategy = GenerationType.IDENTITY)
//                   val id: Int,
//
//                   @ManyToOne
//                   val customer_id: Int,
//
//                   @ManyToOne
//                   val show_id: Int,
//
//                   @ManyToOne
//                   val seat_id: Int)