package com.menggp.artifactstore.controllers;

import com.menggp.artifactstore.services.RestFindRequestHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UIPageSearchController {

    private static final Logger Log = LoggerFactory.getLogger(UIPageSearchController.class);

    @Autowired
    RestFindRequestHandler restFindRequestHandler;

    @RequestMapping("/")
    public String index(Model model) {

        // однуляем атрибуты поиска
        model.addAttribute("searchParamCategory",null);
        model.addAttribute("searchParamUser",null);
        model.addAttribute("searchParamDescription",null);
        model.addAttribute("searchParamComment",null);

        model.addAttribute("categoriesList", restFindRequestHandler.getAllCategories());
        model.addAttribute("usersList", restFindRequestHandler.getAllUsers());
        return "home";
    }

    @RequestMapping("/showAllArtifacts")
    public String showAllArtifacts(Model model) {

        // однуляем атрибуты поиска
        model.addAttribute("searchParamCategory",null);
        model.addAttribute("searchParamUser",null);
        model.addAttribute("searchParamDescription",null);
        model.addAttribute("searchParamComment",null);

        model.addAttribute("categoriesList", restFindRequestHandler.getAllCategories());
        model.addAttribute("usersList", restFindRequestHandler.getAllUsers());

        model.addAttribute("artifactList", restFindRequestHandler.getAllArtifacs());
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

        model.addAttribute("categoriesList", restFindRequestHandler.getAllCategories());
        model.addAttribute("usersList", restFindRequestHandler.getAllUsers());

        model.addAttribute("artifactList", restFindRequestHandler.getArtifacatsFilterByCategory(category));
        return "home";
    } // end_method

    @RequestMapping("/showArtifactFilterByUser")
    public String showArtifactFilterByUser(
            @RequestParam(value = "artifactUser", required = false) String user,
            Model model
    ) {

        model.addAttribute("categoriesList", restFindRequestHandler.getAllCategories());
        model.addAttribute("usersList", restFindRequestHandler.getAllUsers());

        model.addAttribute("artifactList", restFindRequestHandler.getArtifacatsFilterByUser(user));
        return "home";
    } // end_method

    @RequestMapping("/showArtifactFilterByDescription")
    public String showArtifactFilterByDescription(
            @RequestParam(value = "artifactDescription", required = false) String desc,
            Model model
    ) {

        model.addAttribute("categoriesList", restFindRequestHandler.getAllCategories());
        model.addAttribute("usersList", restFindRequestHandler.getAllUsers());

        model.addAttribute("artifactList", restFindRequestHandler.getArtifacatsFilterByDescription(desc));
        return "home";
    } // end_method

    @RequestMapping("/showArtifactFilterByCommentContent")
    public String showArtifactFilterByCommentContent(
            @RequestParam(value = "artifactCommentContent", required = false) String comment,
            Model model
    ) {

        model.addAttribute("categoriesList", restFindRequestHandler.getAllCategories());
        model.addAttribute("usersList", restFindRequestHandler.getAllUsers());

        model.addAttribute("artifactList", restFindRequestHandler.getArtifacatsFilterByCommentContent(comment));
        return "home";
    } // end_method






} // end_class