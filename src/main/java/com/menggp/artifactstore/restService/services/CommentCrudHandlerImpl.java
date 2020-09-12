package com.menggp.artifactstore.restService.services;

import com.menggp.artifactstore.model.Comment;
import com.menggp.artifactstore.model.repo.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Реализация интерфейса CommentCrudHandler
 */
@Service
public class CommentCrudHandlerImpl implements CommentCrudHandler {

    @Autowired
    CommentRepository commentRepository;

    @Override
    public Comment findCommentById(long id){
        return  commentRepository.findById( id ).get();
    }

    @Override
    public List<Comment> findByArtifactId(long artId){
        return (List<Comment>) commentRepository.findByArtifactId(artId);
    }

    @Override
    public Comment createComment(Comment newComment) {
        return commentRepository.save( newComment );
    }

    @Override
    public Comment updateComment(Comment updatedComment){

        Comment comment = commentRepository.findById( updatedComment.getId() ).get();
        comment.setUserId( updatedComment.getUserId() );
        comment.setContent( updatedComment.getContent() );

        return commentRepository.save( comment );
    }

    @Override
    public void deleteComment(long id) {
        commentRepository.deleteById(id);
    }

}
