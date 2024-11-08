package de.brabender.gdw.campusfit.service

import de.brabender.gdw.campusfit.models.Comment
import de.brabender.gdw.campusfit.models.SportMeeting
import java.util.*

interface CommentService {
    fun getCommentById(id: UUID): Comment?
    fun getAllComments(): List<Comment>

    fun getAllBySportMeeting(sportmeeting: SportMeeting):List<Comment>
    fun deleteCommentsFromMeeting(sportMeeting: SportMeeting)

    fun deleteAllCommentsFromSportMeeting(sportMeeting: SportMeeting)
    fun fetchFilteredCommentList(sportMeeting: SportMeeting): List<Comment>

    fun saveComment(comment: Comment): Comment
    fun deleteComment(comment: Comment)
    fun delete(id: UUID)
    fun deleteAll()
}