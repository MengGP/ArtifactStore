package com.menggp.artifactstore.restService.controllersRest;

import com.menggp.artifactstore.model.Comment;
import com.menggp.artifactstore.model.dto.CommentList;
import com.menggp.artifactstore.restService.services.ArtifactCrudHandler;
import com.menggp.artifactstore.restService.services.CommentCrudHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 *  Класс обрабатывает REST-запросы,
 *          к данными сущности Comment
 */
@RestController
@RequestMapping("/comments")
public class CommentRestController {

    private static final Logger Log = LoggerFactory.getLogger(CommentRestController.class);

    @Autowired
    CommentCrudHandler commentCrudHandler;

    /**
     * Получить комментарий по id
     * @param id - id комментария
     * @return - комменатрий
     */
    @GetMapping("/{id}")
    public Comment getCommentById(
            @PathVariable(name = "id") Long id
    ) {
        return commentCrudHandler.findCommentById( id );
    }

    /**
     * Получить список комментариев к артефакту по id артефакта
     * @param artId - id артефакта
     * @return - список комментариев
     */
    @GetMapping
    public CommentList getCommentsByArtifact(
            @RequestParam(value = "artId") long artId
    ) {
        return new CommentList( commentCrudHandler.findByArtifactId( artId ) );
    }

    /**
     * Создать комментарий
     * @param newComment - новый комментарий
     * @return - созаднный комментарий
     */
    @PostMapping
    public Comment createComment(
            @RequestBody Comment newComment
    ) {
        return commentCrudHandler.createComment(newComment);
    }

    /**
     * Удаление комментария по id
     * @param id - id комментария
     */
    @DeleteMapping("/{id}")
    public void delComment(
            @PathVariable("id") long id
    ) {
        commentCrudHandler.deleteComment(id);
    }

    /**
     * Обновление комментария
     * @param updatedComment - камментарий с новыми значениями
     * @return - обновленный комментарий
     */
    @PutMapping
    public Comment updateComment(
            @RequestBody Comment updatedComment
    ) {
        return commentCrudHandler.updateComment(updatedComment);
    }

}
