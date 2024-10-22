package de.brabender.gdw.campusfit.models.comment

import org.springframework.data.repository.CrudRepository
import java.util.UUID

interface CommentRepository : CrudRepository<Comment, UUID> {
}