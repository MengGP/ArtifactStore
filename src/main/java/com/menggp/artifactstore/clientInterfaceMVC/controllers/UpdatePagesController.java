package com.menggp.artifactstore.clientInterfaceMVC.controllers;

import com.menggp.artifactstore.clientInterfaceMVC.services.RequestHandler;
import com.menggp.artifactstore.model.Artifact;
import com.menggp.artifactstore.model.Comment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/*
    Обработчка задачь "обновления" данных с пользовательского интерфейса
 */
@Controller
public class UpdatePagesController {

    private static final Logger Log = LoggerFactory.getLogger(UpdatePagesController.class);

    @Autowired
    RequestHandler requestHandler;

    // Загрузка страницы измененияя артефакта
    @RequestMapping("/editArtifactPage")
    public String editArtifactPage(
            @RequestParam(value = "artifactId", required = true) long id,
            Model model) {

        Artifact currArt = requestHandler.getArtById( id );

        model.addAttribute("currArt", currArt);
        return "editArtifactPage";
    } // end_method

    /*  Обратка изменения артефакта, коды результата:
                 0 - заполенены не все поля
                 1 - успех
                -1 - ошибка БД  */
    @RequestMapping("/updateArtifact")
    public String updateAtifact(
            @RequestParam(value = "artifactId", required = true) long id,
            @RequestParam(value = "userId", required = false) String userId,
            @RequestParam(value = "category", required = false) String category,
            @RequestParam(value = "description", required = false) String description,
            Model model) {

        Artifact currArt = requestHandler.getArtById( id );

        int result = -1;
        if ( userId.length()==0 || description.length()==0 )
            result = 0;
        else {
            result = requestHandler.updateArtifact(id, userId, category, description, currArt.getCreated() );
            currArt = requestHandler.getArtById( id );
        }

        model.addAttribute("result", result);
        model.addAttribute("currArt", currArt);
        return "editArtifactPage";
    } // end_method

    // Загразка страницы изменения комметания
    @RequestMapping("/editCommentPage")
    public String editArtifactPage(
            @RequestParam(value = "artifactId", required = true) long artId,
            @RequestParam(value = "commentId", required = true) long commentId,
            Model model) {

        Artifact currArt = requestHandler.getArtById( artId );
        Comment currComment = requestHandler.getCommentById( commentId );

        model.addAttribute("currArt", currArt);
        model.addAttribute("currComment", currComment);
        return "editCommentPage";
    } // end_method

    /*  Обратка изменения комментария, коды результата:
                 0 - заполенены не все поля
                 1 - успех
                -1 - ошибка БД  */
    @RequestMapping("/updateComment")
    public String updateComment(
            @RequestParam(value = "artifactId", required = true) long artId,
            @RequestParam(value = "commentId", required = true) long commentId,
            @RequestParam(value = "userId", required = false) String userId,
            @RequestParam(value = "content", required = false) String content,
            Model model) {

        Artifact currArt = requestHandler.getArtById( artId );
        Comment currComment = requestHandler.getCommentById( commentId );

        int result = -1;
        if ( userId.length()==0 || content.length()==0 )
            result = 0;
        else {
            result = requestHandler.updateComment(commentId, userId, content, artId);
            currComment = requestHandler.getCommentById( commentId );
        }

        model.addAttribute("result", result);
        model.addAttribute("currArt", currArt);
        model.addAttribute("currComment", currComment);
        return "editCommentPage";
    } // end_method

} // end_class
