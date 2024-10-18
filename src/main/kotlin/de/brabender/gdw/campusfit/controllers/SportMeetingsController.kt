package de.brabender.gdw.campusfit.controllers

import de.brabender.gdw.campusfit.models.SportMeeting
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*
import java.util.UUID

@Controller
class SportMeetingsController {

    var sportMeetings: ArrayList<SportMeeting> = arrayListOf()

    @RequestMapping("/sportmeetings")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    fun sportmeetings(name: String) {
        val sportMeeting = SportMeeting()
        sportMeeting.name = name
        sportMeetings.add(sportMeeting)
    }

    @GetMapping("/sportmeetings")
    @ResponseBody
    fun getSportMeetings(): String {
        return sportMeetings.joinToString(",")
    }

    @GetMapping("/sportmeetings/{id}")
    @ResponseBody
    fun getSportMeetingById(@PathVariable("id") id: UUID): String {
        val sportMeeting = sportMeetings.find { it.id == id }
        return sportMeeting!!.name
    }

    @PutMapping("/sportmeetings/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun updateSportMeeting(@PathVariable("id") id: UUID, name: String) {
        val sportMeeting = sportMeetings.find { it.id == id }
        sportMeeting!!.name = name
    }
}