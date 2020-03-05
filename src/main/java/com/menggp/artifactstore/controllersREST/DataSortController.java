package com.menggp.artifactstore.controllersREST;

import com.menggp.artifactstore.dao.Artifact;
import com.menggp.artifactstore.dto.ArtifactList;
import com.menggp.artifactstore.services.ArtifactCrudSortHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class DataSortController {

    private static final Logger Log = LoggerFactory.getLogger(DataSortController.class);

    @Autowired
    ArtifactCrudSortHandler artifactCrudSorthHandler;

    @RequestMapping(value="/artFilterByCatSort", method = RequestMethod.GET)
    public ArtifactList getArtifactsByUser(
            @RequestParam(value = "cat") String cat,
            @RequestParam(value = "sortType") int sortType,
            @RequestParam(value = "sortDirection") boolean sortDirection
    ) {
        ArrayList<Artifact> artList = new ArrayList<>();
        ArtifactList response = new ArtifactList();

        artList = artifactCrudSorthHandler.sortArtFilteredByCategory(cat, sortType, sortDirection);

        response.setArtifactList(artList);
        return response;
    } // end_method

} // end_class
