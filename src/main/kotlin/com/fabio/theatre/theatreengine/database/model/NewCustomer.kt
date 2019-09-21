package com.fabio.theatre.theatreengine.database.model

import com.fabio.theatre.theatreengine.database.entity.Customer


data class NewCustomer (val customer : Customer,
                        val password : String)
