package de.brabender.gdw.campusfit.models

import jakarta.persistence.*
import java.util.UUID

@Entity
class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: UUID? = null

    @ManyToOne
    var sportMeeting: SportMeeting? = null

    var commentText: String? = null
}