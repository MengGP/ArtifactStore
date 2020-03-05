package com.menggp.artifactstore.dao;

import com.menggp.artifactstore.dao.repo.ArtifactRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;



/*
    Сласс предоставляющий CRUD операции для работы с сущностью Artifact
 */
public class ArtifactCrudHandler {

    private ArrayList<Artifact> all;

    @Autowired
    ArtifactRepository artifactRepository;

    public ArrayList<Artifact> readAll() {
        all = (ArrayList<Artifact>) artifactRepository.findAll();
        return all;
    } // end_method

} // end_class
