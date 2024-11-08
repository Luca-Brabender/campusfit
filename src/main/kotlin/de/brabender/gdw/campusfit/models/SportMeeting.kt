package de.brabender.gdw.campusfit.models

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

import java.util.UUID

@Entity
class SportMeeting {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: UUID? = null
    val isInDoor: Boolean = true
    var name: String = ""
    var place: String = ""
    var date: String = ""

    override fun toString(): String {
        return "SportMeeting(id=$id, name='$name', place='$place', date='$date')"
    }
}