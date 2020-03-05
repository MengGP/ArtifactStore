package com.menggp.artifactstore.controllersREST;

import com.menggp.artifactstore.dao.Artifact;
import com.menggp.artifactstore.dao.ArtifactCrudHandler;
import com.menggp.artifactstore.dto.ArtifactList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class DataController {

    @Autowired
    ArtifactCrudHandler artifactCrudHandler;

    @RequestMapping(value="/allArtifactsRequest", method = RequestMethod.GET)
    public ArtifactList getAllArtifacts() {
        ArrayList<Artifact> artList = new ArrayList<>();
        ArtifactList response = new ArtifactList();

        artList = artifactCrudHandler.readAll();

        response.setArtifactList(artList);
        return response;
    } // end_method




} // end_class
