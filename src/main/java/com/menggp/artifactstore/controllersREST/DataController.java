package com.menggp.artifactstore.controllersREST;

import com.menggp.artifactstore.dao.Artifact;
import com.menggp.artifactstore.dto.ArtifactList;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class DataController {

    @RequestMapping(value="/allArtifactsRequest", method = RequestMethod.GET)
    public ArtifactList getAllArtifacts() {
        ArrayList<Artifact> artList = new ArrayList<>();
        ArtifactList response = new ArtifactList();

        Artifact art1 = new Artifact();
        art1.setId(1);
        art1.setCategory("Cat-1");
        art1.setDescription("Desc-1");
        art1.setUserId("use01");
        artList.add(art1);
        art1.setId(2);
        art1.setCategory("Cat-2");
        art1.setDescription("Desc-2");
        art1.setUserId("use02");
        artList.add(art1);

        response.setArtifactList(artList);
        return response;
    } // end_method




} // end_class
