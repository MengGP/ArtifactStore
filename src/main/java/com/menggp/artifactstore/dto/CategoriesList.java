package com.menggp.artifactstore.dto;

import com.menggp.artifactstore.dao.Artifact;

import java.util.ArrayList;
import java.util.List;

public class CategoriesList {

    private List<String> categoriesList;

    public CategoriesList() {
        categoriesList = new ArrayList<>();
    } // end_controller

    // -- Getters and Setters
    public List<String> getCategoriesList() {
        return categoriesList;
    }

    public void setCategoriesList(List<String> categoriesList) {
        this.categoriesList = categoriesList;
    }
    // -- end_getters_and_setters

} // end_method
