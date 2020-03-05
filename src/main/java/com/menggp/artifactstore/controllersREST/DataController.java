package com.menggp.artifactstore.controllersREST;

import com.menggp.artifactstore.dao.Artifact;
import com.menggp.artifactstore.dao.ArtifactCrudHandler;
import com.menggp.artifactstore.dto.ArtifactList;
import com.menggp.artifactstore.dto.CategoriesList;
import com.menggp.artifactstore.dto.UserList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class DataController {

    @Autowired
    ArtifactCrudHandler artifactCrudHandler;

    @RequestMapping(value="/allArtifactsRequest", method = RequestMethod.GET)
    public ArtifactList getAllArtifacts() {
        ArrayList<Artifact> artList = new ArrayList<>();
        ArtifactList response = new ArtifactList();

        artList = artifactCrudHandler.readAll();

        response.setArtifactList(artList);
        return response;
    } // end_method

    @RequestMapping(value="/artRequestByCategory", method = RequestMethod.GET)
    public ArtifactList getArtifactsByCategory(
            @RequestParam String cat
    ) {
        ArrayList<Artifact> artList = new ArrayList<>();
        ArtifactList response = new ArtifactList();

        artList = artifactCrudHandler.findByCategory(cat);

        response.setArtifactList(artList);
        return response;
    } // end_method

    @RequestMapping(value="/artRequestByUser", method = RequestMethod.GET)
    public ArtifactList getArtifactsByUser(
            @RequestParam String user
    ) {
        ArrayList<Artifact> artList = new ArrayList<>();
        ArtifactList response = new ArtifactList();

        artList = artifactCrudHandler.findByUser(user);

        response.setArtifactList(artList);
        return response;
    } // end_method

    @RequestMapping(value="/allCategories", method = RequestMethod.GET)
    public CategoriesList getAllCategories() {
        ArrayList<String> catList = new ArrayList<>();
        CategoriesList response = new CategoriesList();

        catList = artifactCrudHandler.readAllCategories();

        response.setCategoriesList(catList);
        return response;
    } // end_method

    @RequestMapping(value = "/allUsers", method = RequestMethod.GET)
    public UserList getAllusers() {
        ArrayList<String> userList = new ArrayList<>();
        UserList response = new UserList();

        userList = artifactCrudHandler.readAllUsers();

        response.setUserList(userList);
        return response;
    } // end_method




} // end_class
