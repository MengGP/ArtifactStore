package com.menggp.artifactstore.model.dto;

import com.menggp.artifactstore.model.ArtifactHist;

import java.util.ArrayList;
import java.util.List;

/**
 *  Data Transfer Object
 *      для передачи List<ArtifactHist> в REST запросе/ответе
 */
public class ArtifactHistList {

    private List<ArtifactHist> artifactHistList;

    public ArtifactHistList() {
        artifactHistList = new ArrayList<>();
    }

    public ArtifactHistList(List<ArtifactHist> artifactHistList) {
        this.artifactHistList = artifactHistList;
    }

    public List<ArtifactHist> getArtifactHistList() {
        return artifactHistList;
    }

    public void setArtifactHistList(List<ArtifactHist> artifactHistList) {
        this.artifactHistList = artifactHistList;
    }
}
