package com.menggp.artifactstore.services;

import com.menggp.artifactstore.controllersREST.DataSortController;
import com.menggp.artifactstore.dao.Artifact;
import com.menggp.artifactstore.dao.repo.ArtifactRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ArtifactCrudSortHandler {

    private static final Logger Log = LoggerFactory.getLogger(ArtifactCrudSortHandler.class);

    private ArrayList<Artifact> allArtifact;

    @Autowired
    ArtifactRepository artifactRepository;

    /*  - фильтр по категории: String cat
        - поле сортривки: int sortType
            1 - Категория(cat)
            2 - Автор(user)
            3 - Время создания(created)
         - направлениe: boolean sortDirection
                ASK по возрастанию = true
                DESK по убыванию = false
     */
    public ArrayList<Artifact> sortArtFilteredByCategory(String cat, int sortType, boolean sortDirection) {
        String clause;
        clause = "%" + cat + "%";
        clause = clause.toUpperCase();

        switch (sortType) {
            case 1:
                if ( sortDirection ) allArtifact = (ArrayList<Artifact>) artifactRepository.findByCategoryLikeIgnoreCaseOrderByCategory(clause);
                else allArtifact = (ArrayList<Artifact>) artifactRepository.findByCategoryLikeIgnoreCase(clause);
                break;
            case 2:
                if ( sortDirection ) allArtifact = (ArrayList<Artifact>) artifactRepository.findByCategoryLikeIgnoreCase(clause);
                else allArtifact = (ArrayList<Artifact>) artifactRepository.findByCategoryLikeIgnoreCase(clause);
                break;
            case 3:
                if ( sortDirection ) allArtifact = (ArrayList<Artifact>) artifactRepository.findByCategoryLikeIgnoreCase(clause);
                else allArtifact = (ArrayList<Artifact>) artifactRepository.findByCategoryLikeIgnoreCase(clause);
                break;
        }
        return allArtifact;
    } // end_method


} // end_class
