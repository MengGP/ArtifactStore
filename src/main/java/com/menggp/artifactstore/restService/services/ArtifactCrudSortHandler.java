package com.menggp.artifactstore.restService.services;

import com.menggp.artifactstore.model.Artifact;
import com.menggp.artifactstore.model.repo.ArtifactRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/*
    Обработчик CRUD операций для сущности Артифакт - Read: чтение и фильтр с сортировкой
     - поле сортривки: int sortType
        1 - Категория(cat)
        2 - Автор(user)
        3 - Время создания(created)
     - направлениe: boolean sortDirection
            ASC по возрастанию = true
            DESK по убыванию = false
 */
@Service
public class ArtifactCrudSortHandler {

    private static final Logger Log = LoggerFactory.getLogger(ArtifactCrudSortHandler.class);

    private ArrayList<Artifact> allArtifact;

    @Autowired
    ArtifactRepository artifactRepository;

    // Сортировка аритифактов без фильтров
    public ArrayList<Artifact> sortAllArtifacts(int sortType, boolean sortDirection) {
        switch (sortType) {
            case 1: // сортрировка по категории(category)
                if ( sortDirection ) {
                    Sort.Order order = new Sort.Order(Sort.Direction.ASC, "category").ignoreCase();
                    allArtifact = (ArrayList<Artifact>) artifactRepository.findAll( Sort.by(order) );
                }
                else {
                    Sort.Order order = new Sort.Order(Sort.Direction.DESC, "category").ignoreCase();
                    allArtifact = (ArrayList<Artifact>) artifactRepository.findAll( Sort.by(order) );
                }
                break;
            case 2: // сортрировка по автору(UserId)
                if ( sortDirection ) {
                    Sort.Order order = new Sort.Order(Sort.Direction.ASC, "userId").ignoreCase();
                    allArtifact = (ArrayList<Artifact>) artifactRepository.findAll( Sort.by(order) );
                }
                else {
                    Sort.Order order = new Sort.Order(Sort.Direction.DESC, "userId").ignoreCase();
                    allArtifact = (ArrayList<Artifact>) artifactRepository.findAll( Sort.by(order) );
                }
                break;
            case 3: // сортировка по времени создания(created)
                if ( sortDirection ) {
                    Sort.Order order = new Sort.Order(Sort.Direction.ASC, "created").ignoreCase();
                    allArtifact = (ArrayList<Artifact>) artifactRepository.findAll( Sort.by(order) );
                }
                else {
                    Sort.Order order = new Sort.Order(Sort.Direction.DESC, "created").ignoreCase();
                    allArtifact = (ArrayList<Artifact>) artifactRepository.findAll( Sort.by(order) );
                }
                break;
        }
        return allArtifact;
    } // end_method

    // Сортировка аритифактов отфильтрованных по категории(category)
    public ArrayList<Artifact> sortArtFilteredByCategory(String cat, int sortType, boolean sortDirection) {
        String clause;
        clause = "%" + cat + "%";
        clause = clause.toUpperCase();

        switch (sortType) {
            case 1: // сортрировка по категории(category)
                if ( sortDirection ) {
                    Sort.Order order = new Sort.Order(Sort.Direction.ASC, "category").ignoreCase();
                    allArtifact = (ArrayList<Artifact>) artifactRepository.findByCategoryLikeIgnoreCase( clause, Sort.by(order) );
                }
                else {
                    Sort.Order order = new Sort.Order(Sort.Direction.DESC, "category").ignoreCase();
                    allArtifact = (ArrayList<Artifact>) artifactRepository.findByCategoryLikeIgnoreCase( clause, Sort.by(order) );
                }
                break;
            case 2: // сортрировка по автору(UserId)
                if ( sortDirection ) {
                    Sort.Order order = new Sort.Order(Sort.Direction.ASC, "userId").ignoreCase();
                    allArtifact = (ArrayList<Artifact>) artifactRepository.findByCategoryLikeIgnoreCase( clause, Sort.by(order) );
                }
                else {
                    Sort.Order order = new Sort.Order(Sort.Direction.DESC, "userId").ignoreCase();
                    allArtifact = (ArrayList<Artifact>) artifactRepository.findByCategoryLikeIgnoreCase( clause, Sort.by(order) );
                }
                break;
            case 3: // сортировка по времени создания(created)
                if ( sortDirection ) {
                    Sort.Order order = new Sort.Order(Sort.Direction.ASC, "created").ignoreCase();
                    allArtifact = (ArrayList<Artifact>) artifactRepository.findByCategoryLikeIgnoreCase( clause, Sort.by(order) );
                }
                else {
                    Sort.Order order = new Sort.Order(Sort.Direction.DESC, "created").ignoreCase();
                    allArtifact = (ArrayList<Artifact>) artifactRepository.findByCategoryLikeIgnoreCase( clause, Sort.by(order) );
                }
                break;
        }
        return allArtifact;
    } // end_method

    // Сортировка аритифактов отфильтрованных по автору(user_id)
    public ArrayList<Artifact> sortArtFilteredByUserId(String userId, int sortType, boolean sortDirection) {
        String clause;
        clause = "%" + userId + "%";
        clause = clause.toUpperCase();

        switch (sortType) {
            case 1: // сортрировка по категории(category)
                if ( sortDirection ) {
                    Sort.Order order = new Sort.Order(Sort.Direction.ASC, "category").ignoreCase();
                    allArtifact = (ArrayList<Artifact>) artifactRepository.findByUserIdLikeIgnoreCase( clause, Sort.by(order) );
                }
                else {
                    Sort.Order order = new Sort.Order(Sort.Direction.DESC, "category").ignoreCase();
                    allArtifact = (ArrayList<Artifact>) artifactRepository.findByUserIdLikeIgnoreCase( clause, Sort.by(order) );
                }
                break;
            case 2: // сортрировка по автору(UserId)
                if ( sortDirection ) {
                    Sort.Order order = new Sort.Order(Sort.Direction.ASC, "userId").ignoreCase();
                    allArtifact = (ArrayList<Artifact>) artifactRepository.findByUserIdLikeIgnoreCase( clause, Sort.by(order) );
                }
                else {
                    Sort.Order order = new Sort.Order(Sort.Direction.DESC, "userId").ignoreCase();
                    allArtifact = (ArrayList<Artifact>) artifactRepository.findByUserIdLikeIgnoreCase( clause, Sort.by(order) );
                }
                break;
            case 3: // сортировка по времени создания(created)
                if ( sortDirection ) {
                    Sort.Order order = new Sort.Order(Sort.Direction.ASC, "created").ignoreCase();
                    allArtifact = (ArrayList<Artifact>) artifactRepository.findByUserIdLikeIgnoreCase( clause, Sort.by(order) );
                }
                else {
                    Sort.Order order = new Sort.Order(Sort.Direction.DESC, "created").ignoreCase();
                    allArtifact = (ArrayList<Artifact>) artifactRepository.findByUserIdLikeIgnoreCase( clause, Sort.by(order) );
                }
                break;
        }
        return allArtifact;
    } // end_method

    // Сортировка аритифактов отфильтрованных по описанию(description)
    public ArrayList<Artifact> sortArtFilteredByDescription(String desc, int sortType, boolean sortDirection) {
        String clause;
        clause = "%" + desc + "%";
        clause = clause.toUpperCase();

        switch (sortType) {
            case 1: // сортрировка по категории(category)
                if ( sortDirection ) {
                    Sort.Order order = new Sort.Order(Sort.Direction.ASC, "category").ignoreCase();
                    allArtifact = (ArrayList<Artifact>) artifactRepository.findByDescriptionLikeIgnoreCase( clause, Sort.by(order) );
                }
                else {
                    Sort.Order order = new Sort.Order(Sort.Direction.DESC, "category").ignoreCase();
                    allArtifact = (ArrayList<Artifact>) artifactRepository.findByDescriptionLikeIgnoreCase( clause, Sort.by(order) );
                }
                break;
            case 2: // сортрировка по автору(UserId)
                if ( sortDirection ) {
                    Sort.Order order = new Sort.Order(Sort.Direction.ASC, "userId").ignoreCase();
                    allArtifact = (ArrayList<Artifact>) artifactRepository.findByDescriptionLikeIgnoreCase( clause, Sort.by(order) );
                }
                else {
                    Sort.Order order = new Sort.Order(Sort.Direction.DESC, "userId").ignoreCase();
                    allArtifact = (ArrayList<Artifact>) artifactRepository.findByDescriptionLikeIgnoreCase( clause, Sort.by(order) );
                }
                break;
            case 3: // сортировка по времени создания(created)
                if ( sortDirection ) {
                    Sort.Order order = new Sort.Order(Sort.Direction.ASC, "created").ignoreCase();
                    allArtifact = (ArrayList<Artifact>) artifactRepository.findByDescriptionLikeIgnoreCase( clause, Sort.by(order) );
                }
                else {
                    Sort.Order order = new Sort.Order(Sort.Direction.DESC, "created").ignoreCase();
                    allArtifact = (ArrayList<Artifact>) artifactRepository.findByDescriptionLikeIgnoreCase( clause, Sort.by(order) );
                }
                break;
        }
        return allArtifact;
    } // end_method

    // Сортировка аритифактов отфильтрованных по соджержанию комментариев (comment - content)
    public ArrayList<Artifact> sortArtFilteredByCommentContent(String comment, int sortType, boolean sortDirection) {
        String clause;
        clause = "%" + comment + "%";
        clause = clause.toUpperCase();

        switch (sortType) {
            case 1: // сортрировка по категории(category)
                if ( sortDirection ) allArtifact = (ArrayList<Artifact>) artifactRepository.findByCommentContentOrderByCategory(clause);
                else allArtifact = (ArrayList<Artifact>) artifactRepository.findByCommentContentOrderByCategoryDesc(clause);
                break;
            case 2: // сортрировка по автору(UserId)
                if ( sortDirection ) allArtifact = (ArrayList<Artifact>) artifactRepository.findByCommentContentOrderByUserId(clause);
                else allArtifact = (ArrayList<Artifact>) artifactRepository.findByCommentContentOrderByUserIdDesc(clause);
                break;
            case 3: // сортировка по времени создания(created)
                if ( sortDirection ) allArtifact = (ArrayList<Artifact>) artifactRepository.findByCommentContentOrderByCreated(clause);
                else allArtifact = (ArrayList<Artifact>) artifactRepository.findByCommentContentOrderByCreatedDesc(clause);
                break;
        }
        return allArtifact;
    } // end_method

} // end_class
