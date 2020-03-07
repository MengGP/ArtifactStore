package com.menggp.artifactstore.services;

import com.menggp.artifactstore.dao.Artifact;
import com.menggp.artifactstore.dao.Comment;
import com.menggp.artifactstore.dao.repo.ArtifactRepository;
import com.menggp.artifactstore.dao.repo.CommentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;

@Service
public class CommentCrudHandler {

    private static final Logger Log = LoggerFactory.getLogger(CommentCrudHandler.class);

    @Autowired
    CommentRepository commentRepository;

    // Метод возвращает комментарий по ID
    public Comment findCommentById(long id){
        return  commentRepository.findById( id ).get();
    }

    // Метод возвращает комметнарии к Артефакту (по artifactId)
    public ArrayList<Comment> findByArtifactId(long artId){
        return (ArrayList<Comment>) commentRepository.findByArtifactId(artId);
    } // end_method

    // Метод создает комментарий в БД
    public Comment createComment(Comment newComment) {
        return commentRepository.save( newComment );
    } // end_method

    // Метод обновляет комментарий
    public Comment updateComment(Comment updatedComment){

        Comment comment = commentRepository.findById( updatedComment.getId() ).get();
        comment.setUserId( updatedComment.getUserId() );
        comment.setContent( updatedComment.getContent() );

        return commentRepository.save( comment );
    } // end_metod

} // end_class
