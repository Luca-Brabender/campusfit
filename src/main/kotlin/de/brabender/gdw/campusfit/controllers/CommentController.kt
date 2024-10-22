package de.brabender.gdw.campusfit.controllers

import de.brabender.gdw.campusfit.models.SportMeeting.SportMeeting
import de.brabender.gdw.campusfit.models.SportMeeting.SportMeetingRepository
import de.brabender.gdw.campusfit.models.comment.Comment
import de.brabender.gdw.campusfit.models.comment.CommentRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus
import java.util.*

@Controller
class CommentController {

    @Autowired
    lateinit var commentRepository: CommentRepository
    @Autowired
    lateinit var sportMeetingRepository: SportMeetingRepository

    @RequestMapping("/sportmeetings/{id}/comments")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    fun postComment(@PathVariable("id") sportMeetingId: UUID, commentHeader: String, content: String) {
        val comment = Comment()
        comment.contentHeader = commentHeader
        comment.content = content
        comment.sportMeeting = sportMeetingRepository.findById(sportMeetingId).get()
        commentRepository.save(comment)
    }

    @RequestMapping("/")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    fun postCommentOfMeeting(commentContent: String, sportMeetingId: UUID) {
        val comment = Comment()
        comment.content = commentContent
        commentRepository.save(comment)

    }

}