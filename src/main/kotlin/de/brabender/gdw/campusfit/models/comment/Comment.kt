package de.brabender.gdw.campusfit.models.comment


import de.brabender.gdw.campusfit.models.SportMeeting.SportMeeting
import jakarta.persistence.*
import lombok.Getter
import lombok.NoArgsConstructor
import lombok.Setter
import java.util.UUID





@Getter
@Setter
@Entity
@NoArgsConstructor
class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private val commentId: UUID? = null

    var contentHeader: String = ""
    var content: String = ""

    @ManyToOne
    var sportMeeting: SportMeeting? = null
}