package de.brabender.gdw.campusfit.models.SportMeeting

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import lombok.Getter
import lombok.NoArgsConstructor
import lombok.Setter
import java.util.UUID

@Getter
@Setter
@Entity
@NoArgsConstructor
class SportMeeting {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: UUID? = null

    var name: String = ""
    var place: String = ""
    var date: String = ""

    override fun toString(): String {
        return "SportMeeting(id=$id, name='$name', place='$place', date='$date')"
    }
}