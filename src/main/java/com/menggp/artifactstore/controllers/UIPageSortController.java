package com.menggp.artifactstore.controllers;

import com.menggp.artifactstore.services.RestFindRequestHandler;
import com.menggp.artifactstore.services.RestSortRequestHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UIPageSortController {

    private static final Logger Log = LoggerFactory.getLogger(UIPageSortController.class);

    @Autowired
    RestFindRequestHandler restFindRequestHandler;

    @Autowired
    RestSortRequestHandler restSortRequestHandler;

    // Сортировка по категории - по возрастанию
    // sortType = 1 - по категории
    // sortDirection = true - ASK по возрастанию
    @RequestMapping("/sortByCatASC")
    public String sortByCatASC(
            @RequestParam(value = "searchParamCategory", required = false) String cat,
            @RequestParam(value = "searchParamUser", required = false) String user,
            @RequestParam(value = "searchParamDescription", required = false) String desc,
            @RequestParam(value = "searchParamComment", required = false) String comment,
            Model model) {

        model.addAttribute("categoriesList", restFindRequestHandler.getAllCategories());
        model.addAttribute("usersList", restFindRequestHandler.getAllUsers());

        int sortType = 1;
        boolean sortDirection = true;

        // Определяем по какому параметру установлен фильтр
        if ( cat != null )
            model.addAttribute("artifactList",
                    restSortRequestHandler.sortArtifactFilteredByCategory(cat, sortType, sortDirection) );
//        else if ( user != null ) param=2;   // 2 - по автору
//        else if ( desc !=null ) param=3;    // 3 - по описанию
//        else if ( comment !=null) param=4;  // 4 - по комментарию

        return "home";
    }


} // end_class
