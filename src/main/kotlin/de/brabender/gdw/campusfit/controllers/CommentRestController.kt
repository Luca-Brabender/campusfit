package de.brabender.gdw.campusfit.controllers

import de.brabender.gdw.campusfit.models.Comment
import de.brabender.gdw.campusfit.service.CommentService
import de.brabender.gdw.campusfit.service.SportMeetingService
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException
import java.util.*

@RestController
@RequestMapping("/sportmeetings/{sportmeetingId}", produces = [MediaType.APPLICATION_JSON_VALUE])
class CommentRestController (private val commentService: CommentService, private val sportMeetingService: SportMeetingService) {

    @PostMapping("/comments")
    @ResponseStatus(HttpStatus.CREATED)
    fun saveComment(commentText: String, @PathVariable sportmeetingId: UUID) {
        val sportMeeting = sportMeetingService.getById(sportmeetingId)
        if(sportMeeting != null){
            val comment = Comment()
            comment.commentText = commentText
            comment.sportMeeting = sportMeeting
            commentService.saveComment(comment)
        } else {
            throw ResponseStatusException(HttpStatus.BAD_REQUEST, "Sportmeeting not found")
        }
    }

    @GetMapping("/comments")
    fun getComments(@PathVariable sportmeetingId: UUID): List<Comment> {
        val sportmeeting = sportMeetingService.getById(sportmeetingId)
        if(sportmeeting != null){
            val comments = commentService.getAllBySportMeeting(sportmeeting)
            return comments
        } else {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "Sportmeeting not found")
        }
    }

    @GetMapping("/comments/{commentId}")
    fun getComment(@PathVariable commentId: UUID, @PathVariable sportmeetingId: UUID): Comment? {
        val sportmeeting = sportMeetingService.getById(sportmeetingId)
        if(sportmeeting != null){
            val comment = commentService.getCommentById(commentId)
            return comment
        }else{
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "Sportmeeting not found")
        }
    }

    @PutMapping("/comments/{commentId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun updateComment(@PathVariable commentId: UUID, commentText: String, @PathVariable sportmeetingId: UUID) {
        val sportmeeting = sportMeetingService.getById(sportmeetingId)
        if(sportmeeting != null){
            val comment = commentService.getCommentById(commentId)
            if(comment != null){
                comment.commentText = commentText
            } else {
                throw ResponseStatusException(HttpStatus.NOT_FOUND, "Sportmeeting not found")
            }
        }else{
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "Sportmeeting not found")
        }
    }

    @DeleteMapping("/comments/{commentId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteComment(@PathVariable commentId: UUID, @PathVariable sportmeetingId: UUID) {
        val sportmeeting = sportMeetingService.getById(sportmeetingId)
        if(sportmeeting != null){
            val comment = commentService.getCommentById(commentId)
            if (comment != null){
                commentService.deleteComment(comment)
            } else {
                throw ResponseStatusException(HttpStatus.NOT_FOUND, "comment not found")
            }
        } else{
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "Sportmeeting not found")
        }
    }

    @DeleteMapping("/comments")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteAllCommentsFromSportMeeting(@PathVariable sportmeetingId: UUID) {
        val sportmeeting = sportMeetingService.getById(sportmeetingId)
        if(sportmeeting != null){
            commentService.deleteAllCommentsFromSportMeeting(sportmeeting)
        } else{
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "Sportmeeting not found")
        }
    }

}