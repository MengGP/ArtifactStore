package com.menggp.artifactstore.controllers;

import com.menggp.artifactstore.dao.Artifact;
import com.menggp.artifactstore.services.RestReadRequestHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ReadPagesController {

    @Autowired
    RestReadRequestHandler restReadRequestHandler;

    @RequestMapping("/")
    public String indexPage(Model model) {
        homePage(model);
        return "home";
    } // end_method

    @RequestMapping("/home")
    public String homePage(Model model) {

        // однуляем атрибуты поиска
        model.addAttribute("searchParamCategory",null);
        model.addAttribute("searchParamUser",null);
        model.addAttribute("searchParamDescription",null);
        model.addAttribute("searchParamComment",null);

        model.addAttribute("categoriesList", restReadRequestHandler.getAllCategories());
        model.addAttribute("usersList", restReadRequestHandler.getAllUsers());

        model.addAttribute("artifactList", restReadRequestHandler.getAllArtifacs());
        return "home";
    } // end_method

    @RequestMapping("/commentPage")
    public String commentPage(
            @RequestParam(value = "artifactId", required = true) long artId,
            Model model) {

        // Получаем артефакт по ID
        Artifact currArt = restReadRequestHandler.getArtById( artId );
        model.addAttribute("currArt", currArt);
        model.addAttribute("commentList", restReadRequestHandler.getCommentariesByArtifactId( artId ));



        return "commentPage";
    }

} // end_class

