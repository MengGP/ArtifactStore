package com.menggp.artifactstore.clientInterfaceMVC.controllers;

import com.menggp.artifactstore.clientInterfaceMVC.services.RequestHandler;
import com.menggp.artifactstore.model.Artifact;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *  Контроллер отображения страниц с базовой информацией (без фильтров и сортировок)
 *      - домашняя страница
 *      - страница комментариев
 *      - страница истории изменений артефактов
 */
@Controller
public class ReadPagesController {

    private static final Logger Log = LoggerFactory.getLogger(ReadPagesController.class);

    @Autowired
    RequestHandler requestHandler;

    /**
     * Обработчик корневой страницы - редирект
     * @param model - модель
     * @return  - имя вида
     */
    @RequestMapping("/")
    public String indexPage(Model model) {
        homePage(model);
        return "home";
    }

    /**
     * Обработчик домашней страницы
     * @param model - модель
     * @return - имя вида
     */
    @RequestMapping("/home")
    public String homePage(Model model) {

        // однуляем атрибуты поиска
        model.addAttribute("searchParamCategory",null);
        model.addAttribute("searchParamUser",null);
        model.addAttribute("searchParamDescription",null);
        model.addAttribute("searchParamComment",null);

        model.addAttribute("categoriesList", requestHandler.getAllCategories());
        model.addAttribute("usersList", requestHandler.getAllUsers());

        model.addAttribute("artifactList", requestHandler.getAllArtifacs());
        return "home";
    }

    /**
     * Обработчик страницы комментариев
     * @param artId - id артефакта
     * @param model - модель
     * @return - имя вида
     */
    @RequestMapping("/commentPage")
    public String commentPage(
            @RequestParam(value = "artifactId", required = true) long artId,
            Model model) {
        Artifact currArt = requestHandler.getArtById( artId );
        model.addAttribute("currArt", currArt);
        model.addAttribute("commentList", requestHandler.getCommentariesByArtifactId( artId ));

        return "commentPage";
    }

    /**
     * Обаботчик страницы истории изменения артифакта
     * @param artId - id артефакта
     * @param model - модель
     * @return  - имя вида
     */
    @RequestMapping("/artHistPage")
    public String artHistPage(
            @RequestParam(value = "artifactId", required = true) long artId,
            Model model
    ) {
        Artifact currArt = requestHandler.getArtById( artId );
        model.addAttribute("currArt", currArt);
        model.addAttribute("artifactsHistList", requestHandler.getArtifactsHistByArtifactId(artId));

        return "artHistPage";
    }

} // end_class

