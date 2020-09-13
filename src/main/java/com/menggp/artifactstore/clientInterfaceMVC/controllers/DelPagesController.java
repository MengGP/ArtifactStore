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
    Обработчка задачь "удаления" с пользовательского интерфейса
 */
@Controller
public class DelPagesController {

    private static final Logger Log = LoggerFactory.getLogger(DelPagesController.class);

    @Autowired
    RequestHandler requestHandler;

    @Autowired
    ReadPagesController readPagesController;

    // Загрука страницы удаления артефакта
    @RequestMapping("/delArtifactPage")
    public String delArtifactPage(
            @RequestParam(value = "artifactId", required = true) long id,
            Model model) {

        Artifact currArt = requestHandler.getArtById( id );
        long commentsNumber = requestHandler.getCommentsNumber( id );

        model.addAttribute("commentsNum", commentsNumber);
        model.addAttribute("currArt", currArt);
        return "delArtifactPage";
    } // end_method

    /* Обработка удаления артефакта, коды результата:
                     1 - успех
                    -1 - ошибка БД  */
    @RequestMapping("/delArtifact")
    public String deleteArtifact(
            @RequestParam(value = "artifactId", required = true) long id,
            Model model) {

        int result = -1;
        result = requestHandler.delArtifact(id);

        if (result==-1) {
            Artifact currArt = requestHandler.getArtById( id );
            long commentsNumber = requestHandler.getCommentsNumber( id );
            model.addAttribute("currArt", currArt);
            model.addAttribute("commentsNum", commentsNumber);

            model.addAttribute("result", result);
            return "delArtifactPage";
        }

        readPagesController.homePage(model);
        return "home";
    } // end_method

    // Загрука страницы удаления комментария
    @RequestMapping("/delCommentPage")
    public String delCommentPage(
            @RequestParam(value = "artifactId", required = true) long artId,
            @RequestParam(value = "commentId", required = true) long commentId,
            Model model) {

        Artifact currArt = requestHandler.getArtById( artId );
        Comment currComment = requestHandler.getCommentById( commentId );

        model.addAttribute("currComment", currComment);
        model.addAttribute("currArt", currArt);
        return "delCommentPage";
    } // end_method

    /* Обработка удаления комментария, коды результата:
                 1 - успех
                -1 - ошибка БД  */
    @RequestMapping("/delComment")
    public String delComment(
            @RequestParam(value = "artifactId", required = true) long artId,
            @RequestParam(value = "commentId", required = true) long commentId,
            Model model) {

        Artifact currArtifact = requestHandler.getArtById( artId );
        model.addAttribute("currArt",currArtifact);

        int result = -1;
        result = requestHandler.delComment(commentId);

        if (result==-1) {
            Comment currComment = requestHandler.getCommentById( commentId );
            model.addAttribute("currComment", currComment);

            model.addAttribute("result", result);
            return "delCommentPage";
        }

        model.addAttribute("commentList", requestHandler.getCommentariesByArtifactId(artId));
        return "commentPage";
    } // end_method

} // end_class
