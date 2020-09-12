package com.menggp.artifactstore.model.dto;

import com.menggp.artifactstore.model.Comment;

import java.util.ArrayList;
import java.util.List;

/*
    Data Transfer Object -
        для передачи List<Comment> в REST запросе
 */
public class CommentList {

    private List<Comment> commentList;

    public CommentList() {
        commentList = new ArrayList<>();
    } // end_constructor

    public CommentList(List<Comment> commentList) {
        this.commentList = commentList;
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
