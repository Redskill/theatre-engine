package com.fabio.theatre.theatreengine.database.entity
import javax.persistence.*

@Entity
data class Review (@Id @GeneratedValue(strategy= GenerationType.IDENTITY)
                   val id: Int,

                   val description: String,

                   @ManyToOne(fetch = FetchType.LAZY)
                   @JoinColumn
                   val customer: Customer,

                   @ManyToOne(cascade = [CascadeType.ALL])
                   val show: Show)

