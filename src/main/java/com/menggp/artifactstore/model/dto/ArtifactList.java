package com.menggp.artifactstore.model.dto;

import com.menggp.artifactstore.model.Artifact;

import java.util.ArrayList;
import java.util.List;

/**
 *  Data Transfer Object
 *      для передачи List<Artifact> в REST запросе/ответе
 */
public class ArtifactList {

    private List<Artifact> artifactList;

    public ArtifactList() {
        artifactList = new ArrayList<>();
    }

    public ArtifactList(List<Artifact> artifactList) {
        this.artifactList = artifactList;
    }


    public List<Artifact> getArtifactList() {
        return artifactList;
    }

    public void setArtifactList(List<Artifact> artifactList) {
        this.artifactList = artifactList;
    }


}
