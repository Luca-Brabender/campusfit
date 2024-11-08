package de.brabender.gdw.campusfit.controllers

import de.brabender.gdw.campusfit.models.Comment
import de.brabender.gdw.campusfit.models.SportMeeting
import de.brabender.gdw.campusfit.service.CommentService
import de.brabender.gdw.campusfit.service.SportMeetingService
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException
import java.util.UUID

@RestController
@RequestMapping(produces = [MediaType.APPLICATION_JSON_VALUE])
class SportMeetingsRestController(private val sportMeetingService: SportMeetingService, private val commentService: CommentService) {



    @RequestMapping("/sportmeetings")
    @ResponseStatus(HttpStatus.CREATED)
    fun sportmeetings(name: String , place: String, date: String) {
        val sportMeeting = SportMeeting()
        sportMeeting.name = name
        sportMeeting.place = place
        sportMeeting.date = date
        sportMeetingService.save(sportMeeting)
    }

    @GetMapping("/sportmeetings")
    fun getSportMeetings(): List<SportMeeting> = sportMeetingService.getAll()

    @GetMapping("/sportmeetings/{id}")
    fun getSportMeetingById(@PathVariable("id") id: UUID): List<Comment> {
        val sportMeeting: SportMeeting? = sportMeetingService.getById(id)
        val filteredComments: List<Comment>
        if (sportMeeting != null) {
            filteredComments = commentService.fetchFilteredCommentList(sportMeeting)
        } else {
            throw ResponseStatusException(HttpStatus.BAD_REQUEST, "SportMeeting not found")
        }

        return filteredComments
    }

    @PutMapping("/sportmeetings/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun updateSportMeeting(@PathVariable("id") id: UUID, name: String, place: String, date: String) {
        val sportMeeting: SportMeeting? = sportMeetingService.getById(id)
        sportMeeting!!.name = name
        sportMeeting.place = place
        sportMeeting.date = date
        sportMeetingService.save(sportMeeting)
    }

    @DeleteMapping("/sportmeetings/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteSportMeetingById(@PathVariable("id") id: UUID) {
        val sportMeeting = sportMeetingService.getById(id)
        if (sportMeeting != null) {
            commentService.deleteAllCommentsFromSportMeeting(sportMeeting)
        }
        sportMeetingService.deleteById(id)

    }



}