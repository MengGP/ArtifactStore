package com.menggp.artifactstore.controllersREST;

import com.menggp.artifactstore.dao.Artifact;
import com.menggp.artifactstore.dao.Comment;
import com.menggp.artifactstore.services.ArtifactCrudCUDHandler;
import com.menggp.artifactstore.services.CommentCrudHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/*
    REST-контроллеры задач на "создание данных"
 */
@RestController
public class DataCreateController {

    @Autowired
    ArtifactCrudCUDHandler artifactCrudCUDHandler;

    @Autowired
    CommentCrudHandler commentCrudHandler;

    // Создание артефакта
    @RequestMapping(value="/createArt", method = RequestMethod.POST)
    public Artifact createArtifact(
            @RequestBody Artifact newArt
    ) {
        return artifactCrudCUDHandler.createArtifact(newArt);
    } // end_method

    // Создание комметария
    @RequestMapping(value="/createComment", method = RequestMethod.POST)
    public Comment createComment(
            @RequestBody Comment newComment
    ) {
        return commentCrudHandler.createComment(newComment);
    } // end_method

} // end_class
