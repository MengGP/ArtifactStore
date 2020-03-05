package com.menggp.artifactstore.dto;

import java.util.ArrayList;
import java.util.List;

public class UserList {

    private List<String> userList;

    public UserList() {
        userList = new ArrayList<>();
    } // end_controller

    // -- Getters and Setters
    public List<String> getUserList() {
        return userList;
    }

    public void setUserList(List<String> userList) {
        this.userList = userList;
    }
    // -- end_getters_and_setters

} // end_method
