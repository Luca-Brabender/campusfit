package de.brabender.gdw.campusfit.controllers

import de.brabender.gdw.campusfit.models.SportMeeting
import de.brabender.gdw.campusfit.repositories.SportMeetingRepository
import de.brabender.gdw.campusfit.service.SportMeetingService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*
import java.util.UUID

@Controller
class SportMeetingsController(private val sportMeetingService: SportMeetingService) {



    @RequestMapping("/sportmeetings")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    fun sportmeetings(name: String , place: String, date: String) {
        val sportMeeting = SportMeeting()
        sportMeeting.name = name
        sportMeeting.place = place
        sportMeeting.date = date
        sportMeetingService.save(sportMeeting)
    }

    @GetMapping("/sportmeetings")
    @ResponseBody
    fun getSportMeetings(): String {
        val sportMeetings = sportMeetingService.getAll()
        return sportMeetings.joinToString(",")
    }

    @GetMapping("/sportmeetings/{id}")
    @ResponseBody
    fun getSportMeetingById(@PathVariable("id") id: UUID): String {
        val sportMeeting: SportMeeting? = sportMeetingService.getById(id)
        return sportMeeting!!.name
    }

    @PutMapping("/sportmeetings/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun updateSportMeeting(@PathVariable("id") id: UUID, name: String, place: String, date: String) {
        val sportMeeting: SportMeeting? = sportMeetingService.getById(id)
        sportMeeting!!.name = name
        sportMeeting.place = place
        sportMeeting.date = date
    }

    @DeleteMapping("/sportmeetings/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteSportMeetingById(@PathVariable("id") id: UUID) {
        sportMeetingService.deleteById(id)
    }
}