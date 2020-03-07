package com.menggp.artifactstore.dto;

import com.menggp.artifactstore.dao.Artifact;

import java.util.ArrayList;
import java.util.List;

/*
    Data Transfer Object -
        для передачи List<Artifact> в REST запросе
 */
public class ArtifactList {

    private List<Artifact> artifactList;

    public ArtifactList() {
        artifactList = new ArrayList<>();
    } // end_controller

    // -- Getters and Setters
    public List<Artifact> getArtifactList() {
        return artifactList;
    }

    public void setArtifactList(List<Artifact> artifactList) {
        this.artifactList = artifactList;
    }
    // -- end_getters_and_setters

} // end_class
