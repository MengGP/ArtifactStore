package com.menggp.artifactstore.controllers;

import com.menggp.artifactstore.services.RestCreateRequestHandler;
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

    /*  Обратка создания артефакта
            коды результата:
                0 - заполенены не все поля
                1 - успех
                -1 - ошибка БД
     */
    @RequestMapping("/createArtifact")
    public String sortByCatASC(
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
    }

} // end_class
