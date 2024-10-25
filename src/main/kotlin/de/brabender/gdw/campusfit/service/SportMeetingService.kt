package de.brabender.gdw.campusfit.service

import de.brabender.gdw.campusfit.models.SportMeeting
import java.util.UUID

interface SportMeetingService {
    fun getAll(): List<SportMeeting>
    fun getAll(open: Boolean = false): List<SportMeeting>
    fun getById(id: UUID): SportMeeting?
    fun save(sportMeeting: SportMeeting): SportMeeting
    fun deleteById(id: UUID)
}