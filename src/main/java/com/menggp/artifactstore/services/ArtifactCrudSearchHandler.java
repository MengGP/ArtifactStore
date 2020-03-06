package com.menggp.artifactstore.services;

import com.menggp.artifactstore.dao.Artifact;
import com.menggp.artifactstore.dao.repo.ArtifactRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;


/*
    Класс предоставляющий CRUD операции для работы с сущностью Artifact
        - только операции поиска
 */
@Service
public class ArtifactCrudSearchHandler {

    private static final Logger Log = LoggerFactory.getLogger(ArtifactCrudSearchHandler.class);

    private ArrayList<Artifact> allArtifact;
    private ArrayList<String> allString;

    @Autowired
    ArtifactRepository artifactRepository;

    // Запись аритифакт по ID
    public Artifact findArtById( long id ) {
        return artifactRepository.findById( id ).get();
    }

    // Все записи из таблицы ARTIFACTES
    public ArrayList<Artifact> readAll() {
        allArtifact = (ArrayList<Artifact>) artifactRepository.findAll();
        return allArtifact;
    } // end_method

    // ARTIFACTES - фильтр по категрии
    public  ArrayList<Artifact> findByCategory(String category) {
        String clause;
        clause = "%" + category + "%";
        clause = clause.toUpperCase();
        allArtifact = (ArrayList<Artifact>) artifactRepository.findByCategoryLikeIgnoreCase(clause);
        return allArtifact;
    } // end_method

    // ARTIFACTES - фильтр по пользователю
    public  ArrayList<Artifact> findByUser(String user) {
        String clause;
        clause = "%" + user + "%";
        clause = clause.toUpperCase();
        allArtifact = (ArrayList<Artifact>) artifactRepository.findByUserIdLikeIgnoreCase(clause);
        return allArtifact;
    } // end_method

    // ARTIFACTES - фильтр по пользователю
    public  ArrayList<Artifact> findByDescription(String desc) {
        String clause;
        clause = "%" + desc + "%";
        clause = clause.toUpperCase();
        allArtifact = (ArrayList<Artifact>) artifactRepository.findByDescriptionLikeIgnoreCase(clause);
        return allArtifact;
    } // end_method

    // ARTIFACTES - Фильтр по содержанию комментариев
    public ArrayList<Artifact> findByCommentContent(String comment) {
        String clause;
        clause = "%" + comment + "%";
        clause = clause.toUpperCase();
        allArtifact = (ArrayList<Artifact>) artifactRepository.findByCommentContent(clause);
        return allArtifact;
    }

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
