package de.brabender.gdw.campusfit.repositories

import de.brabender.gdw.campusfit.models.Comment
import de.brabender.gdw.campusfit.models.SportMeeting
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface CommentRepository: CrudRepository<Comment, UUID> {

    fun findBySportMeeting(sportMeeting: SportMeeting): List<Comment>
    fun deleteAllBySportMeeting(sportMeeting: SportMeeting)
}