package com.menggp.artifactstore.controllersREST;

import com.menggp.artifactstore.dao.Artifact;
import com.menggp.artifactstore.dao.Comment;
import com.menggp.artifactstore.dto.CommentList;
import com.menggp.artifactstore.services.ArtifactCrudReadHandler;
import com.menggp.artifactstore.dto.ArtifactList;
import com.menggp.artifactstore.dto.StringList;
import com.menggp.artifactstore.services.CommentCrudHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/*
    REST-контроллеры задач на "чтение-поиск данных"
 */
@RestController
public class DataReadController {

    @Autowired
    ArtifactCrudReadHandler artifactCrudReadHandler;

    @Autowired
    CommentCrudHandler commentCrudHandler;

    // Артефакт по Id
    @RequestMapping(value="/artifactById", method = RequestMethod.GET)
    public Artifact getArtifactById(
            @RequestParam Long id
    ) {
        return artifactCrudReadHandler.findArtById( id );
    } // emd_method

    // Комментарий по Id
    @RequestMapping(value="/commentById", method = RequestMethod.GET)
    public Comment getCommentById(
            @RequestParam Long id
    ) {
        return commentCrudHandler.findCommentById( id );
    } // emd_method

    // Все артефакты
    @RequestMapping(value="/allArtifactsRequest", method = RequestMethod.GET)
    public ArtifactList getAllArtifacts() {
        ArrayList<Artifact> artList = new ArrayList<>();
        ArtifactList response = new ArtifactList();

        artList = artifactCrudReadHandler.readAll();

        response.setArtifactList(artList);
        return response;
    } // end_method

    // Артефакты с фильтром по категории
    @RequestMapping(value="/artRequestByCategory", method = RequestMethod.GET)
    public ArtifactList getArtifactsByCategory(
            @RequestParam String cat
    ) {
        ArrayList<Artifact> artList = new ArrayList<>();
        ArtifactList response = new ArtifactList();

        artList = artifactCrudReadHandler.findByCategory(cat);

        response.setArtifactList(artList);
        return response;
    } // end_method

    // Артефакты с фильтром по автору
    @RequestMapping(value="/artRequestByUser", method = RequestMethod.GET)
    public ArtifactList getArtifactsByUser(
            @RequestParam String user
    ) {
        ArrayList<Artifact> artList = new ArrayList<>();
        ArtifactList response = new ArtifactList();

        artList = artifactCrudReadHandler.findByUser(user);

        response.setArtifactList(artList);
        return response;
    } // end_method

    // Артефакты с фильтром по описанию
    @RequestMapping(value="/artRequestByDesc", method = RequestMethod.GET)
    public ArtifactList getArtifactsByDescription(
            @RequestParam String desc
    ) {
        ArrayList<Artifact> artList = new ArrayList<>();
        ArtifactList response = new ArtifactList();

        artList = artifactCrudReadHandler.findByDescription(desc);

        response.setArtifactList(artList);
        return response;
    } // end_method

    // Артефакты с фильтром по содержанию комментариев
    @RequestMapping(value="/artRequestByCommentContent", method = RequestMethod.GET)
    public ArtifactList getArtifactsByCommentContent(
            @RequestParam String comment
    ) {
        ArrayList<Artifact> artList = new ArrayList<>();
        ArtifactList response = new ArtifactList();

        artList = artifactCrudReadHandler.findByCommentContent(comment);

        response.setArtifactList(artList);
        return response;
    } // end_method

    // Комментарии по артефакту
    @RequestMapping(value="/commentRequestByArt", method = RequestMethod.GET)
    public CommentList getCommentsByArtifact(
            @RequestParam long id
    ) {
        ArrayList<Comment> commentList = new ArrayList<>();
        CommentList response = new CommentList();

        commentList = commentCrudHandler.findByArtifactId( id );

        response.setCommentList( commentList );
        return response;
    } // end_method

    // Список категорий
    @RequestMapping(value="/allCategories", method = RequestMethod.GET)
    public StringList getAllCategories() {
        StringList response = new StringList();
        response.setStringList( artifactCrudReadHandler.readAllCategories() );
        return response;
    } // end_method

    // Список авторов артефактов
    @RequestMapping(value = "/allUsers", method = RequestMethod.GET)
    public StringList getAllusers() {
        StringList response = new StringList();
        response.setStringList( artifactCrudReadHandler.readAllUsers() );
        return response;
    } // end_method

    // Количество комментариев у артефакта
    @RequestMapping(value = "/commentsNum", method = RequestMethod.GET)
    public Long commentsNumByArtifact(
            @RequestParam long id
    ) {
        return artifactCrudReadHandler.readCommentsNumberByArtId( id );
    } // end_method

} // end_class
