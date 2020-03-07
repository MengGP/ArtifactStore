package com.menggp.artifactstore.services;

import com.menggp.artifactstore.controllersREST.DataUpdateControler;
import com.menggp.artifactstore.dao.Artifact;
import com.menggp.artifactstore.dao.Comment;
import com.menggp.artifactstore.dao.repo.ArtifactRepository;
import com.menggp.artifactstore.dao.repo.CommentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;

@Service
public class ArtifactCrudCUDHandler {

    private static final Logger Log = LoggerFactory.getLogger(ArtifactCrudCUDHandler.class);

    @Autowired
    ArtifactRepository artifactRepository;

    @Autowired
    CommentRepository commentRepository;

    // Метод создает артифакт
    public Artifact createArtifact(Artifact newArt){
        newArt.setCreated( new Date() );
        return artifactRepository.save( newArt );
    } // end_method

    // Метод обновляет артифакт
    public Artifact updateArtifact(Artifact updatedArt){

        Artifact art = artifactRepository.findById( updatedArt.getId() ).get();
        art.setCreated( updatedArt.getCreated()) ;
        art.setDescription( updatedArt.getDescription() );
        art.setCategory( updatedArt.getCategory() );
        art.setUserId( updatedArt.getUserId() );

        return artifactRepository.save( art );
    } // end_metod

    // Метод удаляет артифакт
    public void deleteArtifact(long id) {

        ArrayList<Comment> commentsList = (ArrayList<Comment>) commentRepository.findByArtifactId( id );
        for (Comment iter : commentsList)
            commentRepository.delete( iter );

        artifactRepository.deleteById( id );
        return;
    } // end_method



} // end_class
