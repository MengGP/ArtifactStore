package com.menggp.artifactstore.restService.controllersRest;

import com.menggp.artifactstore.restService.services.ArtifactCrudCUDHandler;
import com.menggp.artifactstore.restService.services.CommentCrudHandler1;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/*
    REST-контроллеры задач на "удаление данных"
 */
@RestController
public class DataDelController {

    private static final Logger Log = LoggerFactory.getLogger(DataDelController.class);

    @Autowired
    ArtifactCrudCUDHandler artifactCrudCUDHandler;

    @Autowired
    CommentCrudHandler1 commentCrudHandler1;

    // удаление артефакта
    @RequestMapping(value="/delArt", method = RequestMethod.DELETE)
    public void deleteArtifact(
            @RequestParam(value = "id") long id
    ) {
        artifactCrudCUDHandler.deleteArtifact(id);
        return;
    } // end_method

    // удаление комментария
    @RequestMapping(value="/delComment", method = RequestMethod.DELETE)
    public void delComment(
            @RequestParam(value = "id") long id
    ) {
        commentCrudHandler1.deleteComment(id);
        return;
    } // end_method

} // end_class
