package com.menggp.artifactstore.services;

import com.menggp.artifactstore.dao.Artifact;
import com.menggp.artifactstore.dao.repo.ArtifactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ArtifactCrudCUDHandler {

    @Autowired
    ArtifactRepository artifactRepository;

    // Метод создает артифакт
    public Artifact createArtifact(Artifact newArt){
        newArt.setCreated( new Date() );
        return artifactRepository.save( newArt );
    };

} // end_class
