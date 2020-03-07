package com.menggp.artifactstore.dto;

import java.util.ArrayList;
import java.util.List;

/*
    Data Transfer Object -
        для передачи List<String> в REST запросе
 */
public class StringList {

    private List<String> stringList;

    public StringList() {
        stringList = new ArrayList<>();
    } // end_controller

    // -- Getters and Setters
    public List<String> getStringList() {
        return stringList;
    }

    public void setStringList(List<String> stringList) {
        this.stringList = stringList;
    }
    // -- end_getters_and_setters

} // end_method
