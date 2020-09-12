package com.menggp.artifactstore.restService.controllersRest;

import com.menggp.artifactstore.model.Artifact;
import com.menggp.artifactstore.model.Comment;
import com.menggp.artifactstore.restService.services.ArtifactCrudCUDHandler;
import com.menggp.artifactstore.restService.services.CommentCrudHandler1;
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
    CommentCrudHandler1 commentCrudHandler1;

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
        return commentCrudHandler1.createComment(newComment);
    } // end_method

} // end_class
