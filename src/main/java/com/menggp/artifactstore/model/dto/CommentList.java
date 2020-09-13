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
    }

    public CommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }


    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }


}
