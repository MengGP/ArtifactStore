package com.menggp.artifactstore.dto;

import com.menggp.artifactstore.dao.Artifact;
import com.menggp.artifactstore.dao.Comment;

import java.util.ArrayList;
import java.util.List;

public class CommentList {

    private List<Comment> commentList;

    public CommentList() {
        commentList = new ArrayList<>();
    } // end_constructor

    // -- Getters and Setters
    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }
    // -- end_getters_and_setters

} // end_class
