package com.menggp.artifactstore.controllersREST;

import com.menggp.artifactstore.dao.Artifact;
import com.menggp.artifactstore.services.ArtifactCrudCUDHandler;
import com.menggp.artifactstore.services.RestUpdateRequestHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataUpdateControler {

    private static final Logger Log = LoggerFactory.getLogger(DataUpdateControler.class);

    @Autowired
    ArtifactCrudCUDHandler artifactCrudCUDHandler;

    @RequestMapping(value="/updateArt", method = RequestMethod.PUT)
    public Artifact updateArtifact(
            @RequestBody Artifact updatedArt
    ) {

        Artifact response = artifactCrudCUDHandler.updateArtifact(updatedArt);

        return response;
    } // end_method

} // end_class
