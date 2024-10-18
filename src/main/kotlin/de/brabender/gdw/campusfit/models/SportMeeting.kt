package de.brabender.gdw.campusfit.models

import java.util.UUID

class SportMeeting {
    var id: UUID = UUID.randomUUID()
    var name: String = ""

    override fun toString(): String {
        return "SportMeeting(id=$id, name='$name')"
    }
}