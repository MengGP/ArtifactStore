package com.menggp.artifactstore.controllers;

import com.menggp.artifactstore.services.RestCreateRequestHandler;
import com.menggp.artifactstore.services.RestReadRequestHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CreatePagesController {

    private static final Logger Log = LoggerFactory.getLogger(CreatePagesController.class);

    @Autowired
    RestCreateRequestHandler restCreateRequestHandler;

    @Autowired
    RestReadRequestHandler restReadRequestHandler;

    /*  Обратка создания артефакта
            коды результата:
                0 - заполенены не все поля
                1 - успех
                -1 - ошибка БД
     */
    @RequestMapping("/createArtifact")
    public String createArtifact(
            @RequestParam(value = "userId", required = false) String userId,
            @RequestParam(value = "category", required = false) String category,
            @RequestParam(value = "description", required = false) String description,
            Model model) {

        int result = -1;
        if ( userId.length()==0 || description.length()==0 )
            result = 0;
        else {
            result = restCreateRequestHandler.createArtifact(userId, category, description);
        }

        model.addAttribute("result", result);
        return "createArtifactPage";
    } // end_method

    /*  Обратка создания комментария
        коды результата:
            0 - заполенены не все поля
            1 - успех
            -1 - ошибка БД
    */
    @RequestMapping("/createComment")
    public String createComment(
            @RequestParam(value = "userId", required = false) String userId,
            @RequestParam(value = "content", required = false) String content,
            @RequestParam(value = "artifactId", required = true) long artId,
            Model model) {

        int result = -1;
        if ( userId.length()==0 || content.length()==0 )
            result = 0;
        else {
            result = restCreateRequestHandler.createComment(userId, content, artId);
        }

        // Возвращам на страницу код результата, текущий артефакт и список комментариев
        model.addAttribute("result", result);
        model.addAttribute("currArt", restReadRequestHandler.getArtById(artId));
        model.addAttribute("commentList", restReadRequestHandler.getCommentariesByArtifactId( artId ));
        return "commentPage";
    }

} // end_class
