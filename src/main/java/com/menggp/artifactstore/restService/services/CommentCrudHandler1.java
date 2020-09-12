package com.menggp.artifactstore.restService.services;

import com.menggp.artifactstore.model.Comment;
import com.menggp.artifactstore.model.repo.CommentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/*
    Обработчик CRUD операций для сущности комментарий
        C - create
        R - чтение
        U - update
        D - delete
 */
@Service
public class CommentCrudHandler1 {

    private static final Logger Log = LoggerFactory.getLogger(CommentCrudHandler1.class);

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
    } // end_method

    // Метод удаляет комментарий
    public void deleteComment(long id) {
        commentRepository.deleteById(id);
        return;
    } // end_method


} // end_class
