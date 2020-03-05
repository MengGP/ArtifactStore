package com.menggp.artifactstore.dao;

import com.menggp.artifactstore.dao.repo.ArtifactRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;


/*
    Сласс предоставляющий CRUD операции для работы с сущностью Artifact
 */
public class ArtifactCrudHandler {

    private ArrayList<Artifact> allArtifact;
    private ArrayList<String> allString;

    @Autowired
    ArtifactRepository artifactRepository;

    // Все записи из таблицы ARTIFACTES
    public ArrayList<Artifact> readAll() {
        allArtifact = (ArrayList<Artifact>) artifactRepository.findAll();
        return allArtifact;
    } // end_method

    // ARTIFACTES - фильтр по категрии
    public  ArrayList<Artifact> findByCategory(String category) {
        String clause;
        clause = "%" + category + "%";
        clause.toUpperCase();
        allArtifact = (ArrayList<Artifact>) artifactRepository.findByCategoryLikeIgnoreCase(clause);
        return allArtifact;
    } // end_method

    // ARTIFACTES - фильтр по пользователю
    public  ArrayList<Artifact> findByUser(String user) {
        String clause;
        clause = "%" + user + "%";
        clause.toUpperCase();
        allArtifact = (ArrayList<Artifact>) artifactRepository.findByUserIdLikeIgnoreCase(clause);
        return allArtifact;
    } // end_method

    // ARTIFACTES - фильтр по пользователю
    public  ArrayList<Artifact> findByDescription(String desc) {
        String clause;
        clause = "%" + desc + "%";
        clause.toUpperCase();
        allArtifact = (ArrayList<Artifact>) artifactRepository.findByDescriptionLikeIgnoreCase(clause);
        return allArtifact;
    } // end_method

    // Список категорий - ARTIFACT
    public ArrayList<String> readAllCategories() {
        allString = (ArrayList<String>) artifactRepository.findCategory();
        return allString;
    } // end_method

    // Список пользователей - ARTIFACT
    public ArrayList<String> readAllUsers() {
        allString = (ArrayList<String>) artifactRepository.findUser();
        return allString;
    } // end_method






} // end_class
