package com.menggp.artifactstore.restService.controllersRest;

import com.menggp.artifactstore.model.Artifact;
import com.menggp.artifactstore.model.dto.ArtifactList;
import com.menggp.artifactstore.restService.services.ArtifactCrudSortHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/*
    REST-контроллеры задач на "чтение-сортировку данных"
 */
@RestController
public class DataSortController {

    private static final Logger Log = LoggerFactory.getLogger(DataSortController.class);

    @Autowired
    ArtifactCrudSortHandler artifactCrudSorthHandler;

    // Сортировка артифактов - без фильтра
    @RequestMapping(value="/artAllSort", method = RequestMethod.GET)
    public ArtifactList getAllArtifactsSorted(
            @RequestParam(value = "sortType") int sortType,
            @RequestParam(value = "sortDirection") boolean sortDirection
    ) {
        ArrayList<Artifact> artList = new ArrayList<>();
        ArtifactList response = new ArtifactList();

        artList = artifactCrudSorthHandler.sortAllArtifacts(sortType, sortDirection);

        response.setArtifactList(artList);
        return response;
    } // end_method

    // Сортировка артификтов - отфильтрованных по категории
    @RequestMapping(value="/artFilterByCatSort", method = RequestMethod.GET)
    public ArtifactList getArtifactsByCatSorted(
            @RequestParam(value = "cat") String cat,
            @RequestParam(value = "sortType") int sortType,
            @RequestParam(value = "sortDirection") boolean sortDirection
    ) {
        ArrayList<Artifact> artList = new ArrayList<>();
        ArtifactList response = new ArtifactList();

        artList = artifactCrudSorthHandler.sortArtFilteredByCategory(cat, sortType, sortDirection);

        response.setArtifactList(artList);
        return response;
    } // end_method

    // Сортировка артификтов - отфильтрованных по автору(userId)
    @RequestMapping(value="/artFilterByUserSort", method = RequestMethod.GET)
    public ArtifactList getArtifactsByUserIdSorted(
            @RequestParam(value = "userId") String userId,
            @RequestParam(value = "sortType") int sortType,
            @RequestParam(value = "sortDirection") boolean sortDirection
    ) {
        ArrayList<Artifact> artList = new ArrayList<>();
        ArtifactList response = new ArtifactList();

        artList = artifactCrudSorthHandler.sortArtFilteredByUserId(userId, sortType, sortDirection);

        response.setArtifactList(artList);
        return response;
    } // end_method

    // Сортировка артификтов - отфильтрованных по описанию(desctiption)
    @RequestMapping(value="/artFilterByDescSort", method = RequestMethod.GET)
    public ArtifactList getArtifactsByDescriptionSorted(
            @RequestParam(value = "desc") String desc,
            @RequestParam(value = "sortType") int sortType,
            @RequestParam(value = "sortDirection") boolean sortDirection
    ) {
        ArrayList<Artifact> artList = new ArrayList<>();
        ArtifactList response = new ArtifactList();

        artList = artifactCrudSorthHandler.sortArtFilteredByDescription(desc, sortType, sortDirection);

        response.setArtifactList(artList);
        return response;
    } // end_method

    // Сортировка артификтов - отфильтрованных по содержанию комментариев
    @RequestMapping(value="/artFilterByCommentSort", method = RequestMethod.GET)
    public ArtifactList getArtifactsByCommentSorted(
            @RequestParam(value = "comment") String comment,
            @RequestParam(value = "sortType") int sortType,
            @RequestParam(value = "sortDirection") boolean sortDirection
    ) {
        ArrayList<Artifact> artList = new ArrayList<>();
        ArtifactList response = new ArtifactList();

        artList = artifactCrudSorthHandler.sortArtFilteredByCommentContent(comment, sortType, sortDirection);

        response.setArtifactList(artList);
        return response;
    } // end_method

} // end_class
