package com.menggp.artifactstore.restService.services;

import com.menggp.artifactstore.model.Artifact;
import com.menggp.artifactstore.model.repo.ArtifactRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/*
    Обработчик CRUD операций для сущности Артифакт - Read: чтение и поиск
 */
@Service
public class ArtifactCrudReadHandler {

    private static final Logger Log = LoggerFactory.getLogger(ArtifactCrudReadHandler.class);

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
//        allString = (ArrayList<String>) artifactRepository.findCategory();
//        return allString;
        return (ArrayList<String>) artifactRepository.findCategory();
    } // end_method

    // Список пользователей - ARTIFACT
    public ArrayList<String> readAllUsers() {
//        allString = (ArrayList<String>) artifactRepository.findUser();
//        return allString;
        return (ArrayList<String>) artifactRepository.findUser();
    } // end_method

    // Количество комментариев к артифакту
    public long readCommentsNumberByArtId( long artId ) {
        return artifactRepository.findCommentsNumberByArtifactId( artId );
    } // end_method

} // end_class
