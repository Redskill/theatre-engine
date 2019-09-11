package com.fabio.theatre.theatreengine.database.entity

import java.time.LocalDate
import javax.persistence.*

@Entity
@Table(name = "`show`")
data class Show(@Id
                @GeneratedValue(strategy = GenerationType.IDENTITY)
                val id: Int,
                val title: String,

                @ManyToOne(
                    fetch = FetchType.LAZY,
                    cascade = [
                      CascadeType.DETACH,
                      CascadeType.MERGE,
                      CascadeType.PERSIST,
                      CascadeType.REFRESH])
                @JoinColumn(name = "venue_id")
                val venue: Venue,
                val description: String,
                val genre: String,
                val runtime: Int,
                @ElementCollection
                @CollectionTable(name = "show_date")
                val show_date: MutableList<String>,
                val image_path : String) {
}