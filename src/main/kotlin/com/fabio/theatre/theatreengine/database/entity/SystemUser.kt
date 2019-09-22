package com.fabio.theatre.theatreengine.database.entity

import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class SystemUser (@Id val email : String,
                       val password : String)