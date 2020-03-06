package com.menggp.artifactstore.controllersREST;

import com.menggp.artifactstore.dao.Artifact;
import com.menggp.artifactstore.dto.ArtifactList;
import com.menggp.artifactstore.services.ArtifactCrudCUDHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class DataCreateController {

    @Autowired
    ArtifactCrudCUDHandler artifactCrudCUDHandler;

    @RequestMapping(value="/createArt", method = RequestMethod.POST)
    public Artifact createArtifact(
            @RequestBody Artifact newArt
    ) {
        Artifact response = artifactCrudCUDHandler.createArtifact(newArt);

        return response;
    } // end_method

} // end_class
