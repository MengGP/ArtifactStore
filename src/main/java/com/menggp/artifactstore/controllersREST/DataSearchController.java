package com.menggp.artifactstore.controllersREST;

import com.menggp.artifactstore.dao.Artifact;
import com.menggp.artifactstore.services.ArtifactCrudSearchHandler;
import com.menggp.artifactstore.dto.ArtifactList;
import com.menggp.artifactstore.dto.CategoriesList;
import com.menggp.artifactstore.dto.UserList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class DataSearchController {

    @Autowired
    ArtifactCrudSearchHandler artifactCrudSearchHandler;

    @RequestMapping(value="/artifactById", method = RequestMethod.GET)
    public Artifact getArtifactById(
            @RequestParam Long id
    ) {
        return artifactCrudSearchHandler.findArtById( id );
    }

    @RequestMapping(value="/allArtifactsRequest", method = RequestMethod.GET)
    public ArtifactList getAllArtifacts() {
        ArrayList<Artifact> artList = new ArrayList<>();
        ArtifactList response = new ArtifactList();

        artList = artifactCrudSearchHandler.readAll();

        response.setArtifactList(artList);
        return response;
    } // end_method

    @RequestMapping(value="/artRequestByCategory", method = RequestMethod.GET)
    public ArtifactList getArtifactsByCategory(
            @RequestParam String cat
    ) {
        ArrayList<Artifact> artList = new ArrayList<>();
        ArtifactList response = new ArtifactList();

        artList = artifactCrudSearchHandler.findByCategory(cat);

        response.setArtifactList(artList);
        return response;
    } // end_method

    @RequestMapping(value="/artRequestByUser", method = RequestMethod.GET)
    public ArtifactList getArtifactsByUser(
            @RequestParam String user
    ) {
        ArrayList<Artifact> artList = new ArrayList<>();
        ArtifactList response = new ArtifactList();

        artList = artifactCrudSearchHandler.findByUser(user);

        response.setArtifactList(artList);
        return response;
    } // end_method

    @RequestMapping(value="/artRequestByDesc", method = RequestMethod.GET)
    public ArtifactList getArtifactsByDescription(
            @RequestParam String desc
    ) {
        ArrayList<Artifact> artList = new ArrayList<>();
        ArtifactList response = new ArtifactList();

        artList = artifactCrudSearchHandler.findByDescription(desc);

        response.setArtifactList(artList);
        return response;
    } // end_method

    @RequestMapping(value="/artRequestByCommentContent", method = RequestMethod.GET)
    public ArtifactList getArtifactsByCommentContent(
            @RequestParam String comment
    ) {
        ArrayList<Artifact> artList = new ArrayList<>();
        ArtifactList response = new ArtifactList();

        artList = artifactCrudSearchHandler.findByCommentContent(comment);

        response.setArtifactList(artList);
        return response;
    } // end_method

    @RequestMapping(value="/allCategories", method = RequestMethod.GET)
    public CategoriesList getAllCategories() {
        ArrayList<String> catList = new ArrayList<>();
        CategoriesList response = new CategoriesList();

        catList = artifactCrudSearchHandler.readAllCategories();

        response.setCategoriesList(catList);
        return response;
    } // end_method

    @RequestMapping(value = "/allUsers", method = RequestMethod.GET)
    public UserList getAllusers() {
        ArrayList<String> userList = new ArrayList<>();
        UserList response = new UserList();

        userList = artifactCrudSearchHandler.readAllUsers();

        response.setUserList(userList);
        return response;
    } // end_method

    @RequestMapping(value = "/commentsNum", method = RequestMethod.GET)
    public Long getAllusers(
            @RequestParam long id
    ) {
        return artifactCrudSearchHandler.readCommentsNumberByArtId( id );
    } // end_method




} // end_class
