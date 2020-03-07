package com.menggp.artifactstore.controllers;

import com.menggp.artifactstore.dao.Artifact;
import com.menggp.artifactstore.dao.Comment;
import com.menggp.artifactstore.services.RestReadRequestHandler;
import com.menggp.artifactstore.services.RestUpdateRequestHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UpdatePagesController {

    private static final Logger Log = LoggerFactory.getLogger(UpdatePagesController.class);

    @Autowired
    RestReadRequestHandler restReadRequestHandler;

    @Autowired
    RestUpdateRequestHandler restUpdateRequestHandler;

    @RequestMapping("/editArtifactPage")
    public String editArtifactPage(
            @RequestParam(value = "artifactId", required = true) long id,
            Model model) {

        Artifact currArt = restReadRequestHandler.getArtById( id );

        model.addAttribute("currArt", currArt);
        return "editArtifactPage";
    } // end_method

    @RequestMapping("/updateArtifact")
    public String updateAtifact(
            @RequestParam(value = "artifactId", required = true) long id,
            @RequestParam(value = "userId", required = false) String userId,
            @RequestParam(value = "category", required = false) String category,
            @RequestParam(value = "description", required = false) String description,
            Model model) {

        Artifact currArt = restReadRequestHandler.getArtById( id );

        int result = -1;
        if ( userId.length()==0 || description.length()==0 )
            result = 0;
        else {
            result = restUpdateRequestHandler.updateArtifact(id, userId, category, description, currArt.getCreated() );
            currArt = restReadRequestHandler.getArtById( id );
        }

        model.addAttribute("result", result);
        model.addAttribute("currArt", currArt);
        return "editArtifactPage";
    } // end_method

    @RequestMapping("/editCommentPage")
    public String editArtifactPage(
            @RequestParam(value = "artifactId", required = true) long artId,
            @RequestParam(value = "commentId", required = true) long commentId,
            Model model) {

        Artifact currArt = restReadRequestHandler.getArtById( artId );
        Comment currComment = restReadRequestHandler.getCommentById( commentId );

        model.addAttribute("currArt", currArt);
        model.addAttribute("currComment", currComment);
        return "editCommentPage";
    } // end_method

    @RequestMapping("/updateComment")
    public String updateComment(
            @RequestParam(value = "artifactId", required = true) long artId,
            @RequestParam(value = "commentId", required = true) long commentId,
            @RequestParam(value = "userId", required = false) String userId,
            @RequestParam(value = "content", required = false) String content,
            Model model) {

        Artifact currArt = restReadRequestHandler.getArtById( artId );
        Comment currComment = restReadRequestHandler.getCommentById( commentId );

        int result = -1;
        if ( userId.length()==0 || content.length()==0 )
            result = 0;
        else {
            result = restUpdateRequestHandler.updateComment(commentId, userId, content, artId);
            currComment = restReadRequestHandler.getCommentById( commentId );
        }

        model.addAttribute("result", result);
        model.addAttribute("currArt", currArt);
        model.addAttribute("currComment", currComment);
        return "editCommentPage";
    } // end_method

} // end_class
