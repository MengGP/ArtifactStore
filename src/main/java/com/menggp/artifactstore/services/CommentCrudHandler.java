package com.menggp.artifactstore.services;

import com.menggp.artifactstore.dao.Artifact;
import com.menggp.artifactstore.dao.Comment;
import com.menggp.artifactstore.dao.repo.ArtifactRepository;
import com.menggp.artifactstore.dao.repo.CommentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CommentCrudHandler {

    private static final Logger Log = LoggerFactory.getLogger(CommentCrudHandler.class);

    @Autowired
    CommentRepository commentRepository;

    // Метод возвращает комметнарии к Артефакту (по artifactId)
    public ArrayList<Comment> findByArtifactId(long artId){
        return (ArrayList<Comment>) commentRepository.findByArtifactId(artId);
    } // end_method

} // end_class
