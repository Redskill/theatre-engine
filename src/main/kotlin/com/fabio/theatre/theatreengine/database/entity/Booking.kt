package com.fabio.theatre.theatreengine.database.entity

import javax.persistence.*

@Entity
data class Booking(@Id
                   @GeneratedValue(strategy = GenerationType.IDENTITY)
                   val id: Int,

                   @ManyToOne
                   val customer: Customer,

                   @ManyToOne(
                       fetch = FetchType.LAZY,
                       cascade = [
                         CascadeType.DETACH,
                         CascadeType.MERGE,
                         CascadeType.PERSIST,
                         CascadeType.REFRESH])
                   val show: Show,

                   @ManyToMany(fetch = FetchType.EAGER, cascade = [
                     CascadeType.DETACH,
                     CascadeType.MERGE,
                     CascadeType.PERSIST,
                     CascadeType.REFRESH])
                   val seat: MutableList<Seat>,

                   @Column(name = "show_date")
                   val showDate: String)