package com.menggp.artifactstore.controllers;

import com.menggp.artifactstore.dao.Artifact;
import com.menggp.artifactstore.services.RestFindRequestHandler;
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
    RestFindRequestHandler restFindRequestHandler;

    @Autowired
    RestUpdateRequestHandler restUpdateRequestHandler;

    @RequestMapping("/editArtifactPage")
    public String editArtifact(
            @RequestParam(value = "artifactId", required = true) long id,
            Model model) {

        Artifact currArt = restFindRequestHandler.getArtById( id );

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

        Log.info(String.valueOf(id));

        Artifact currArt = restFindRequestHandler.getArtById( id );
        model.addAttribute("currArt", currArt);

        int result = -1;
        if ( userId.length()==0 || description.length()==0 )
            result = 0;
        else {
            result = restUpdateRequestHandler.updateArtifact(id, userId, category, description, currArt.getCreated() );
        }
        model.addAttribute("result", result);

        return "editArtifactPage";
    } // end_method

} // end_class
