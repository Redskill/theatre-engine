package com.fabio.theatre.theatreengine.database.entity

import javax.persistence.*

@Entity
data class Booking(@Id
                   @GeneratedValue(strategy = GenerationType.IDENTITY)
                   val id: Int,

                   @ManyToOne
                   val customer: Customer,

                   @OneToOne(
                       fetch = FetchType.LAZY,
                       cascade = [
                         CascadeType.DETACH,
                         CascadeType.MERGE,
                         CascadeType.PERSIST,
                         CascadeType.REFRESH])
                   val show: Show,

                   @OneToMany(fetch = FetchType.EAGER, cascade = [
                     CascadeType.DETACH,
                     CascadeType.MERGE,
                     CascadeType.PERSIST,
                     CascadeType.REFRESH])
                   val seat: MutableList<Seat>)