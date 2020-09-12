package com.menggp.artifactstore.restService.controllersRest;

import com.menggp.artifactstore.model.Artifact;
import com.menggp.artifactstore.model.Comment;
import com.menggp.artifactstore.restService.services.ArtifactCrudCUDHandler;
import com.menggp.artifactstore.restService.services.CommentCrudHandler1;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/*
    REST-контроллеры задач на "обновление данных"
 */
@RestController
public class DataUpdateControler {

    private static final Logger Log = LoggerFactory.getLogger(DataUpdateControler.class);

    @Autowired
    ArtifactCrudCUDHandler artifactCrudCUDHandler;

    @Autowired
    CommentCrudHandler1 commentCrudHandler1;

    // Обновление Артефакта
    @RequestMapping(value="/updateArt", method = RequestMethod.PUT)
    public Artifact updateArtifact(
            @RequestBody Artifact updatedArt
    ) {
        return artifactCrudCUDHandler.updateArtifact(updatedArt);
    } // end_method

    // Обновление Комментария
    @RequestMapping(value="/updateComment", method = RequestMethod.PUT)
    public Comment updateComment(
            @RequestBody Comment updatedComment
    ) {
        return commentCrudHandler1.updateComment(updatedComment);
    } // end_method

} // end_class
