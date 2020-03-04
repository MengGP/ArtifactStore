package com.menggp.artifactstore.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UIPageController {

    @RequestMapping("/")
    public String index(Model model) {
        return "home";
    }

} // end_class
