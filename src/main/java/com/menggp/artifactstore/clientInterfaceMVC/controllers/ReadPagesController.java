package com.menggp.artifactstore.clientInterfaceMVC.controllers;

import com.menggp.artifactstore.model.Artifact;
import com.menggp.artifactstore.clientInterfaceMVC.services.RestReadRequestHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/*
   Обработка открытия страниц с базовой для для них информацией
 */
@Controller
public class ReadPagesController {

    private static final Logger Log = LoggerFactory.getLogger(ReadPagesController.class);

    @Autowired
    RestReadRequestHandler restReadRequestHandler;

    // home - page
    @RequestMapping("/")
    public String indexPage(Model model) {
        homePage(model);
        return "home";
    } // end_method

    // home - page
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

    // Страница комментариев
    @RequestMapping("/commentPage")
    public String commentPage(
            @RequestParam(value = "artifactId", required = true) long artId,
            Model model) {
        Artifact currArt = restReadRequestHandler.getArtById( artId );
        model.addAttribute("currArt", currArt);
        model.addAttribute("commentList", restReadRequestHandler.getCommentariesByArtifactId( artId ));

        return "commentPage";
    } // end_method

} // end_class

