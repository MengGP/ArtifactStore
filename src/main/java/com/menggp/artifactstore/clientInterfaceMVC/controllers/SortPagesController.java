package com.menggp.artifactstore.clientInterfaceMVC.controllers;

import com.menggp.artifactstore.clientInterfaceMVC.services.RequestHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


/*
   Обработка "сотрировки" на главной странице
       Сортировка с фильтром (адин из параметров) и параметрами сортировки:
        - поле сортривки: int sortType
            1 - Категория(cat)
            2 - Автор(user)
            3 - Время создания(created)
         - направлениe: boolean sortDirection
            ASK по возрастанию = true
            DESK по убыванию = false
 */
@Controller
public class SortPagesController {

    private static final Logger Log = LoggerFactory.getLogger(SortPagesController.class);

    @Autowired
    RequestHandler requestHandler;

    @RequestMapping("/sortArtifacts")
    public String sortByCatASC(
            @RequestParam(value = "searchParamCategory", required = false) String cat,
            @RequestParam(value = "searchParamUser", required = false) String user,
            @RequestParam(value = "searchParamDescription", required = false) String desc,
            @RequestParam(value = "searchParamComment", required = false) String comment,
            @RequestParam(value = "sortType", required = true) int sortType,
            @RequestParam(value = "sortDirection", required = true) boolean sortDirection,
            Model model) {

        model.addAttribute("categoriesList", requestHandler.getAllCategories());
        model.addAttribute("usersList", requestHandler.getAllUsers());

        // Определяем по какому параметру установлен фильтр
        if ( cat.length() != 0 ) {
            // аттрибуты фильтра - фильтр по категории (cat)
            model.addAttribute("searchParamCategory",cat);
            model.addAttribute("searchParamUser",null);
            model.addAttribute("searchParamDescription",null);
            model.addAttribute("searchParamComment",null);

            // получаем отсортированные данные с фильтром и заданными параметрами сортировки
            model.addAttribute("artifactList", requestHandler.sortArtifactFilteredByCategory(cat, sortType, sortDirection));
        }
        else if ( user.length() != 0 ) {
            // аттрибуты фильтра - фильтр по автору (user)
            model.addAttribute("searchParamCategory",null);
            model.addAttribute("searchParamUser",user);
            model.addAttribute("searchParamDescription",null);
            model.addAttribute("searchParamComment",null);

            // получаем отсортированные данные с фильтром и заданными параметрами сортировки
            model.addAttribute("artifactList", requestHandler.sortArtifactFilteredByUserId(user, sortType, sortDirection));
        }
        else if ( desc.length() != 0 ) {
            // аттрибуты фильтра - фильтр по описанию (desc)
            model.addAttribute("searchParamCategory",null);
            model.addAttribute("searchParamUser",null);
            model.addAttribute("searchParamDescription",desc);
            model.addAttribute("searchParamComment",null);

            // получаем отсортированные данные с фильтром и заданными параметрами сортировки
            model.addAttribute("artifactList", requestHandler.sortArtifactFilteredByDescription(desc, sortType, sortDirection));
        }
        else if ( comment.length() != 0 ) {
            // аттрибуты фильтра - фильтр по содержанию комментариев (comment)
            model.addAttribute("searchParamCategory",null);
            model.addAttribute("searchParamUser",null);
            model.addAttribute("searchParamDescription",null);
            model.addAttribute("searchParamComment",comment);

            // получаем отсортированные данные с фильтром и заданными параметрами сортировки
            model.addAttribute("artifactList", requestHandler.sortArtifactFilteredByComment(comment, sortType, sortDirection));
        }
        else {
            // аттрибуты фильтра - фильтр по содержанию комментариев (comment)
            model.addAttribute("searchParamCategory",null);
            model.addAttribute("searchParamUser",null);
            model.addAttribute("searchParamDescription",null);
            model.addAttribute("searchParamComment",null);

            // получаем отсортированные данные с фильтром и заданными параметрами сортировки
            model.addAttribute("artifactList", requestHandler.sortAllArtifact(sortType, sortDirection));
        }
        return "home";
    } // end_method

} // end_class
