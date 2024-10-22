package de.brabender.gdw.campusfit.models.SportMeeting

import org.springframework.data.repository.CrudRepository
import java.util.UUID

interface SportMeetingRepository: CrudRepository<SportMeeting, UUID> {
}