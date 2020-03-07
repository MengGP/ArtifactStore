package com.menggp.artifactstore.controllers;

import com.menggp.artifactstore.dao.Artifact;
import com.menggp.artifactstore.services.RestDelRequestHandler;
import com.menggp.artifactstore.services.RestReadRequestHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DelPagesController {

    private static final Logger Log = LoggerFactory.getLogger(DelPagesController.class);

    @Autowired
    RestReadRequestHandler restReadRequestHandler;

    @Autowired
    RestDelRequestHandler restDelRequestHandler;

    @Autowired
    ReadPagesController readPagesController;

    @RequestMapping("/delArtifactPage")
    public String delArtifactPage(
            @RequestParam(value = "artifactId", required = true) long id,
            Model model) {

        Artifact currArt = restReadRequestHandler.getArtById( id );
        long commentsNumber = restReadRequestHandler.getCommentsNumber( id );

        model.addAttribute("commentsNum", commentsNumber);
        model.addAttribute("currArt", currArt);
        return "delArtifactPage";
    } // end_method

    @RequestMapping("/delArtifact")
    public String deleteArtifact(
            @RequestParam(value = "artifactId", required = true) long id,
            Model model) {

        int result = -1;
        result = restDelRequestHandler.delArtifact(id);

        if (result==-1) {
            Artifact currArt = restReadRequestHandler.getArtById( id );
            long commentsNumber = restReadRequestHandler.getCommentsNumber( id );
            model.addAttribute("currArt", currArt);
            model.addAttribute("commentsNum", commentsNumber);

            model.addAttribute("result", result);
            return "delArtifactPage";
        }

        readPagesController.homePage(model);
        return "home";
    } // end_method

} // end_class
