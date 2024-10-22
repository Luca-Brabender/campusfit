package de.brabender.gdw.campusfit.controllers

import de.brabender.gdw.campusfit.models.SportMeeting.SportMeeting
import de.brabender.gdw.campusfit.models.SportMeeting.SportMeetingRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*
import java.util.UUID

@Controller
class SportMeetingsController {

    @Autowired
    lateinit var sportMeetingsRepository: SportMeetingRepository

    @RequestMapping("/sportmeetings")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    fun sportmeetings(name: String, place: String, date: String) {
        val sportMeeting = SportMeeting()
        sportMeeting.name = name
        sportMeeting.place = place
        sportMeeting.date = date
        sportMeetingsRepository.save(sportMeeting)
    }

    @GetMapping("/sportmeetings")
    @ResponseBody
    fun getSportMeetings() {

        sportMeetingsRepository.findAll().forEach {
            it.toString()
        }
    }

    @GetMapping("/sportmeetings/{id}")
    @ResponseBody
    fun getSportMeetingById(@PathVariable("id") id: UUID): String {
        val optionalSportMeeting = sportMeetingsRepository.findById(id)
        val sportMeeting = optionalSportMeeting.get()
        return sportMeeting.name
    }

    @PutMapping("/sportmeetings/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun updateSportMeeting(@PathVariable("id") id: UUID, name: String, place: String, date: String) {
        val sportMeeting = sportMeetingsRepository.findById(id)
        sportMeeting.get().name = name
        sportMeeting.get().place = place
        sportMeeting.get().date = date
        sportMeetingsRepository.save(sportMeeting.get())

    }
}