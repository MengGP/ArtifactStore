package com.menggp.artifactstore.controllersREST;

import com.menggp.artifactstore.dao.Artifact;
import com.menggp.artifactstore.services.ArtifactCrudCUDHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class DataDelController {

    private static final Logger Log = LoggerFactory.getLogger(DataDelController.class);

    @Autowired
    ArtifactCrudCUDHandler artifactCrudCUDHandler;

    @RequestMapping(value="/delArt", method = RequestMethod.DELETE)
    public void deleteArtifact(
            @RequestParam(value = "id") long id
    ) {
        artifactCrudCUDHandler.deleteArtifact(id);
        return;
    } // end_method

} // end_class
