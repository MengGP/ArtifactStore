package com.menggp.artifactstore.model.dto;

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
    }

    public StringList(List<String> stringList) {
        this.stringList = stringList;
    }


    public List<String> getStringList() {
        return stringList;
    }

    public void setStringList(List<String> stringList) {
        this.stringList = stringList;
    }


}
