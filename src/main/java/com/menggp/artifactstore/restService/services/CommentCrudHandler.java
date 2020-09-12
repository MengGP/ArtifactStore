package com.menggp.artifactstore.restService.services;

import com.menggp.artifactstore.model.Comment;

import java.util.ArrayList;
import java.util.List;

/**
 * Интерфейс описывающий CRUD операции с сущьностью Comment
 */
public interface CommentCrudHandler {

    /**
     * Получение комментария по id комментария
     * @param id - id комментария
     * @return   - комментарий
     */
    Comment findCommentById(long id);

    /**
     * Получение списка комментариев для артифакта - по id артифакта
     * @param artId - id артифакта
     * @return  - комментари в виде списка
     */
    List<Comment> findByArtifactId(long artId);

    /**
     * Создание комментария
     * @param newComment - новый комментарий
     * @return  - созданный комментарий
     */
    Comment createComment(Comment newComment);

    // Метод обновляет комментарий

    /**
     * Обновление комментария
     * @param updatedComment - обновленный комментарий
     * @return - комментарий после обновления
     */
    Comment updateComment(Comment updatedComment);

    // Метод удаляет комментарий

    /**
     * Удаление комментария по id
     * @param id - id комментария
     */
    void deleteComment(long id);

}
