package de.brabender.gdw.campusfit.repositories

import de.brabender.gdw.campusfit.models.SportMeeting
import org.springframework.data.repository.CrudRepository
import java.util.*


interface SportMeetingRepository : CrudRepository<SportMeeting, UUID> {
    fun findByOpenTrue(): List<SportMeeting>
    fun findByOpenFalse(): List<SportMeeting>
}
