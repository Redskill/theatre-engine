package com.fabio.theatre.theatreengine.database.entity
import javax.persistence.*

@Entity
data class Review (@Id @GeneratedValue(strategy= GenerationType.IDENTITY)
                   val id: Int,

                   val description: String,

                   @ManyToOne(
                       fetch = FetchType.LAZY,
                       cascade = [
                         CascadeType.DETACH,
                         CascadeType.MERGE,
                         CascadeType.PERSIST,
                         CascadeType.REFRESH])
                   val customer: Customer,

                   @ManyToOne(
                       fetch = FetchType.LAZY,
                       cascade = [CascadeType.ALL])
                   val show: Show)

