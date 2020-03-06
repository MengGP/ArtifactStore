package com.menggp.artifactstore.services;

import com.menggp.artifactstore.dao.Artifact;
import com.menggp.artifactstore.dao.repo.ArtifactRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/*   - поле сортривки: int sortType
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
                if ( sortDirection ) allArtifact = (ArrayList<Artifact>) artifactRepository.findAllByOrderByCategoryAsc();
                else allArtifact = (ArrayList<Artifact>) artifactRepository.findAllByOrderByCategoryDesc();
                break;
            case 2: // сортрировка по автору(UserId)
                if ( sortDirection ) allArtifact = (ArrayList<Artifact>) artifactRepository.findAllByOrderByUserIdAsc();
                else allArtifact = (ArrayList<Artifact>) artifactRepository.findAllByOrderByUserIdDesc();
                break;
            case 3: // сортировка по времени создания(created)
                if ( sortDirection ) allArtifact = (ArrayList<Artifact>) artifactRepository.findAllByOrderByCreatedAsc();
                else allArtifact = (ArrayList<Artifact>) artifactRepository.findAllByOrderByCreatedDesc();
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
                if ( sortDirection ) allArtifact = (ArrayList<Artifact>) artifactRepository.findByCategoryLikeIgnoreCaseOrderByCategory(clause);
                else allArtifact = (ArrayList<Artifact>) artifactRepository.findByCategoryLikeIgnoreCaseOrderByCategoryDesc(clause);
                break;
            case 2: // сортрировка по автору(UserId)
                if ( sortDirection ) allArtifact = (ArrayList<Artifact>) artifactRepository.findByCategoryLikeIgnoreCaseOrderByUserId(clause);
                else allArtifact = (ArrayList<Artifact>) artifactRepository.findByCategoryLikeIgnoreCaseOrderByUserIdDesc(clause);
                break;
            case 3: // сортировка по времени создания(created)
                if ( sortDirection ) allArtifact = (ArrayList<Artifact>) artifactRepository.findByCategoryLikeIgnoreCaseOrderByCreated(clause);
                else allArtifact = (ArrayList<Artifact>) artifactRepository.findByCategoryLikeIgnoreCaseOrderByCreatedDesc(clause);
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
                if ( sortDirection ) allArtifact = (ArrayList<Artifact>) artifactRepository.findByUserIdLikeIgnoreCaseOrderByCategory(clause);
                else allArtifact = (ArrayList<Artifact>) artifactRepository.findByUserIdLikeIgnoreCaseOrderByCategoryDesc(clause);
                break;
            case 2: // сортрировка по автору(UserId)
                if ( sortDirection ) allArtifact = (ArrayList<Artifact>) artifactRepository.findByUserIdLikeIgnoreCaseOrderByUserId(clause);
                else allArtifact = (ArrayList<Artifact>) artifactRepository.findByUserIdLikeIgnoreCaseOrderByUserIdDesc(clause);
                break;
            case 3: // сортировка по времени создания(created)
                if ( sortDirection ) allArtifact = (ArrayList<Artifact>) artifactRepository.findByUserIdLikeIgnoreCaseOrderByCreated(clause);
                else allArtifact = (ArrayList<Artifact>) artifactRepository.findByUserIdLikeIgnoreCaseOrderByCreatedDesc(clause);
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
                if ( sortDirection ) allArtifact = (ArrayList<Artifact>) artifactRepository.findByDescriptionLikeIgnoreCaseOrderByCategory(clause);
                else allArtifact = (ArrayList<Artifact>) artifactRepository.findByDescriptionLikeIgnoreCaseOrderByCategoryDesc(clause);
                break;
            case 2: // сортрировка по автору(UserId)
                if ( sortDirection ) allArtifact = (ArrayList<Artifact>) artifactRepository.findByDescriptionLikeIgnoreCaseOrderByUserId(clause);
                else allArtifact = (ArrayList<Artifact>) artifactRepository.findByDescriptionLikeIgnoreCaseOrderByUserIdDesc(clause);
                break;
            case 3: // сортировка по времени создания(created)
                if ( sortDirection ) allArtifact = (ArrayList<Artifact>) artifactRepository.findByDescriptionLikeIgnoreCaseOrderByCreated(clause);
                else allArtifact = (ArrayList<Artifact>) artifactRepository.findByDescriptionLikeIgnoreCaseOrderByCreatedDesc(clause);
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
