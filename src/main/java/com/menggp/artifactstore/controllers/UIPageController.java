package com.menggp.artifactstore.controllers;

import com.menggp.artifactstore.dao.Artifact;
import com.menggp.artifactstore.dto.ArtifactList;
import com.menggp.artifactstore.services.RestRequestHandler;
import org.apache.tomcat.util.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class UIPageController {

    private static final Logger Log = LoggerFactory.getLogger(UIPageController.class);

    @Autowired
    RestRequestHandler restRequestHandler;



    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("categoriesList", restRequestHandler.getAllCategories());
        return "home";
    }

    @RequestMapping("/showAllArtifacts")
    public String showAllArtifacts(Model model) {

        model.addAttribute("categoriesList", restRequestHandler.getAllCategories());
        model.addAttribute("artifactList", restRequestHandler.getAllArtifacs());
        return "home";
    } // end_method

    @RequestMapping("/showArtifactFilterByCategory")
    public String showArtifactFilterByCategory(
            @RequestParam(value = "artifactCatagory", required = false) String category,
            Model model) {
        model.addAttribute("categoriesList", restRequestHandler.getAllCategories());
        model.addAttribute("artifactList", restRequestHandler.getArtifacatsFilterByCategory(category));
        return "home";
    } // end_method






} // end_class
