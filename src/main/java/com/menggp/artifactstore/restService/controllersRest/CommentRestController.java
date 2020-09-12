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

    @GetMapping("/{id}")
    public Comment getCommentById(
            @PathVariable(name = "id") Long id
    ) {

        Log.info("CommentRestController.class - method - Comment getCommentById( ... )");

        return commentCrudHandler.findCommentById( id );
    }

    @GetMapping
    public CommentList getCommentsByArtifact(
            @RequestParam(value = "artId") long artId
    ) {

        Log.info("CommentRestController.class - method - Comment getCommentsByArtifact( ... )");

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

        Log.info("CommentRestController.class - method - createComment( ... )");

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

        Log.info("CommentRestController.class - method - delComment( ... )");

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

        Log.info("CommentRestController.class - method - updateComment( ... )");

        return commentCrudHandler.updateComment(updatedComment);
    }

    /*
         // Обновление Комментария
    @RequestMapping(value="/updateComment", method = RequestMethod.PUT)
    public Comment updateComment(
            @RequestBody Comment updatedComment
    ) {
        return commentCrudHandler1.updateComment(updatedComment);
    } // end_method
     */

}
