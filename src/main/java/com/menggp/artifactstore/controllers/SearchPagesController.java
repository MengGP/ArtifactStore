package com.menggp.artifactstore.controllers;

import com.menggp.artifactstore.services.RestReadRequestHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SearchPagesController {

    private static final Logger Log = LoggerFactory.getLogger(SearchPagesController.class);

    @Autowired
    RestReadRequestHandler restReadRequestHandler;

    @RequestMapping("/showAllArtifacts")
    public String showAllArtifacts(Model model) {

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

    @RequestMapping("/showArtifactFilterByCategory")
    public String showArtifactFilterByCategory(
            @RequestParam(value = "artifactCatagory", required = false) String category,
            Model model) {

        // аттрибуты поиска - поиск по категории
        model.addAttribute("searchParamCategory",category);
        model.addAttribute("searchParamUser",null);
        model.addAttribute("searchParamDescription",null);
        model.addAttribute("searchParamComment",null);

        model.addAttribute("categoriesList", restReadRequestHandler.getAllCategories());
        model.addAttribute("usersList", restReadRequestHandler.getAllUsers());

        model.addAttribute("artifactList", restReadRequestHandler.getArtifacatsFilterByCategory(category));
        return "home";
    } // end_method

    @RequestMapping("/showArtifactFilterByUser")
    public String showArtifactFilterByUser(
            @RequestParam(value = "artifactUser", required = false) String user,
            Model model
    ) {

        // аттрибуты поиска - поиск по автору (user)
        model.addAttribute("searchParamCategory",null);
        model.addAttribute("searchParamUser",user);
        model.addAttribute("searchParamDescription",null);
        model.addAttribute("searchParamComment",null);

        model.addAttribute("categoriesList", restReadRequestHandler.getAllCategories());
        model.addAttribute("usersList", restReadRequestHandler.getAllUsers());

        model.addAttribute("artifactList", restReadRequestHandler.getArtifacatsFilterByUser(user));
        return "home";
    } // end_method

    @RequestMapping("/showArtifactFilterByDescription")
    public String showArtifactFilterByDescription(
            @RequestParam(value = "artifactDescription", required = false) String desc,
            Model model
    ) {

        // аттрибуты поиска - поиск по описанию (desc)
        model.addAttribute("searchParamCategory",null);
        model.addAttribute("searchParamUser",null);
        model.addAttribute("searchParamDescription",desc);
        model.addAttribute("searchParamComment",null);

        model.addAttribute("categoriesList", restReadRequestHandler.getAllCategories());
        model.addAttribute("usersList", restReadRequestHandler.getAllUsers());

        model.addAttribute("artifactList", restReadRequestHandler.getArtifacatsFilterByDescription(desc));
        return "home";
    } // end_method

    @RequestMapping("/showArtifactFilterByCommentContent")
    public String showArtifactFilterByCommentContent(
            @RequestParam(value = "artifactCommentContent", required = false) String comment,
            Model model
    ) {

        // аттрибуты поиска - поиск по содержанию комментариев (comment)
        model.addAttribute("searchParamCategory",null);
        model.addAttribute("searchParamUser",null);
        model.addAttribute("searchParamDescription",null);
        model.addAttribute("searchParamComment",comment);

        model.addAttribute("categoriesList", restReadRequestHandler.getAllCategories());
        model.addAttribute("usersList", restReadRequestHandler.getAllUsers());

        model.addAttribute("artifactList", restReadRequestHandler.getArtifacatsFilterByCommentContent(comment));
        return "home";
    } // end_method






} // end_class