package de.brabender.gdw.campusfit.service

import de.brabender.gdw.campusfit.models.SportMeeting
import de.brabender.gdw.campusfit.repositories.SportMeetingRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class SportMeetingServiceImpl(private val sportMeetingRepository: SportMeetingRepository) : SportMeetingService {
    override fun getAll(): List<SportMeeting> {
        return sportMeetingRepository.findAll().toList()
    }

    override fun getAll(open: Boolean): List<SportMeeting> {
        return if(open){
            sportMeetingRepository.findByOpenTrue()
        } else {
            sportMeetingRepository.findByOpenFalse()
        }
    }

    override fun getById(id: UUID): SportMeeting? {
        return sportMeetingRepository.findById(id).orElse(null)
    }

    override fun save(sportMeeting: SportMeeting): SportMeeting {
        return sportMeetingRepository.save(sportMeeting)
    }

    override fun deleteById(id: UUID) {
        val sportMeeting = sportMeetingRepository.findById(id).orElse(null)
        sportMeetingRepository.delete(sportMeeting)
    }
}