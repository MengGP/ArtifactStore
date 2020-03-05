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

    public  ArrayList<Artifact> findByCategory(String category) {
        all = (ArrayList<Artifact>) artifactRepository.findByCategoryLike(category+"%");
        return all;
    }



} // end_class
