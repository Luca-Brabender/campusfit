package de.brabender.gdw.campusfit.service

import de.brabender.gdw.campusfit.models.Comment
import de.brabender.gdw.campusfit.models.SportMeeting
import de.brabender.gdw.campusfit.repositories.CommentRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class CommentServiceImpl(private val commentRepository: CommentRepository) : CommentService {
    override fun getCommentById(id: UUID): Comment? {
        return commentRepository.findById(id).orElse(null)
    }

    override fun getAllComments(): List<Comment> {
        return commentRepository.findAll().toList()
    }

    override fun getAllBySportMeeting(sportMeeting: SportMeeting): List<Comment> {
        return commentRepository.findBySportMeeting(sportMeeting)
    }

    override fun deleteCommentsFromMeeting(sportmeeting: SportMeeting) {
        commentRepository.deleteAllBySportMeeting(sportmeeting)
    }

    override fun deleteAllCommentsFromSportMeeting(sportMeeting: SportMeeting) {
        val comments = commentRepository.findBySportMeeting(sportMeeting)
        for (comment in comments) {
            commentRepository.delete(comment)
        }
    }

    override fun fetchFilteredCommentList(sportMeeting: SportMeeting): List<Comment>{
        val commments = commentRepository.findAll()
        val filteredComments: MutableList<Comment> = mutableListOf()
        for (comment in commments) {
            if (comment.sportMeeting == sportMeeting){
                filteredComments.add(comment)
            }
        }
        return filteredComments
    }


    override fun saveComment(comment: Comment): Comment {
        return commentRepository.save(comment)
    }

    override fun deleteComment(comment: Comment) {
        commentRepository.delete(comment)
    }

    override fun delete(id: UUID) {
        val comment = commentRepository.findById(id).orElse(null)
        commentRepository.delete(comment)
    }

    override fun deleteAll() {
        commentRepository.deleteAll()
    }
}