package com.menggp.artifactstore.services;

import com.menggp.artifactstore.dao.Artifact;
import com.menggp.artifactstore.dto.ArtifactList;
import com.menggp.artifactstore.dto.CategoriesList;
import com.menggp.artifactstore.dto.UserList;
import org.apache.tomcat.util.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class RestFindRequestHandler {

    private static final Logger Log = LoggerFactory.getLogger(RestFindRequestHandler.class);

    private static final String REST_URL_ARTIFACTS_BY_ID_REQUEST = "http://localhost:8077/artifactById";
    private static final String REST_URL_ALL_ARTIFACTS_REQUEST = "http://localhost:8077/allArtifactsRequest";
    private static final String REST_URL_ALL_CATEGORIES_REQUEST = "http://localhost:8077/allCategories";
    private static final String REST_URL_ALL_USERS_REQUEST = "http://localhost:8077/allUsers";
    private static final String REST_URL_ARTIFACTS_REQUEST_BY_CAT = "http://localhost:8077/artRequestByCategory";
    private static final String REST_URL_ARTIFACTS_REQUEST_BY_USER = "http://localhost:8077/artRequestByUser";
    private static final String REST_URL_ARTIFACTS_REQUEST_BY_DESC = "http://localhost:8077/artRequestByDesc";
    private static final String REST_URL_ARTIFACTS_REQUEST_BY_COMMENT = "http://localhost:8077/artRequestByCommentContent";

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    RestBasicAuthHendler restBasicAuthHendler;

    // Метод возвращает Артифакт по ID
    public Artifact getArtById(long id) {
        try {
            HttpHeaders headers = new HttpHeaders();
            HttpEntity<String> request = new HttpEntity<>(restBasicAuthHendler.getHeaders());
            ResponseEntity<Artifact> responseResult
                    = restTemplate.exchange(REST_URL_ARTIFACTS_BY_ID_REQUEST + "?id="+id, HttpMethod.GET, request, Artifact.class);

            return responseResult.getBody();
        } catch ( ResourceAccessException | HttpClientErrorException | HttpServerErrorException ex ) {
            Log.debug( ex.getMessage() );
        }
        return null;
    }

    // Метод возвращает список всех артификтов
    public List<Artifact> getAllArtifacs() {
        try {
            HttpHeaders headers = new HttpHeaders();
            HttpEntity<String> request = new HttpEntity<>(restBasicAuthHendler.getHeaders());
            ResponseEntity<ArtifactList> responseResult
                    = restTemplate.exchange(REST_URL_ALL_ARTIFACTS_REQUEST, HttpMethod.GET, request, ArtifactList.class);

            return responseResult.getBody().getArtifactList();
        } catch ( ResourceAccessException | HttpClientErrorException | HttpServerErrorException ex ) {
            Log.debug( ex.getMessage() );
        }
        return null;
    } // end_method

    // Метод возвращает список артификтов - отфильтрованный по категории
    public List<Artifact> getArtifacatsFilterByCategory(String cat) {
        try {
            HttpHeaders headers = new HttpHeaders();
            HttpEntity<String> request = new HttpEntity<>(restBasicAuthHendler.getHeaders());
            ResponseEntity<ArtifactList> responseResult
                    = restTemplate.exchange(REST_URL_ARTIFACTS_REQUEST_BY_CAT +"?cat="+cat, HttpMethod.GET, request, ArtifactList.class);

            return responseResult.getBody().getArtifactList();
        } catch ( ResourceAccessException | HttpClientErrorException | HttpServerErrorException ex ) {
            Log.debug( ex.getMessage() );
        }
        return null;
    } // end_method

    // Метод возвращает список артификтов - отфильтрованный по пользователю
    public List<Artifact> getArtifacatsFilterByUser(String user) {
        try {
            HttpHeaders headers = new HttpHeaders();
            HttpEntity<String> request = new HttpEntity<>(restBasicAuthHendler.getHeaders());
            ResponseEntity<ArtifactList> responseResult
                    = restTemplate.exchange(REST_URL_ARTIFACTS_REQUEST_BY_USER +"?user="+user, HttpMethod.GET, request, ArtifactList.class);

            return responseResult.getBody().getArtifactList();
        } catch ( ResourceAccessException | HttpClientErrorException | HttpServerErrorException ex ) {
            Log.debug( ex.getMessage() );
        }
        return null;
    } // end_method

    // Метод возвращает список артификтов - отфильтрованный по описанию
    public List<Artifact> getArtifacatsFilterByDescription(String desc) {
        try {
            HttpHeaders headers = new HttpHeaders();
            HttpEntity<String> request = new HttpEntity<>(restBasicAuthHendler.getHeaders());
            ResponseEntity<ArtifactList> responseResult
                    = restTemplate.exchange(REST_URL_ARTIFACTS_REQUEST_BY_DESC +"?desc="+desc, HttpMethod.GET, request, ArtifactList.class);

            return responseResult.getBody().getArtifactList();
        } catch ( ResourceAccessException | HttpClientErrorException | HttpServerErrorException ex ) {
            Log.debug( ex.getMessage() );
        }
        return null;
    } // end_method

    // Метод возвращает список артификтов - отфильтрованный по сожержанию комментариеы
    public List<Artifact> getArtifacatsFilterByCommentContent(String comment) {
        try {
            HttpHeaders headers = new HttpHeaders();
            HttpEntity<String> request = new HttpEntity<>(restBasicAuthHendler.getHeaders());
            ResponseEntity<ArtifactList> responseResult
                    = restTemplate.exchange(REST_URL_ARTIFACTS_REQUEST_BY_COMMENT +"?comment="+comment, HttpMethod.GET, request, ArtifactList.class);

            return responseResult.getBody().getArtifactList();
        } catch ( ResourceAccessException | HttpClientErrorException | HttpServerErrorException ex ) {
            Log.debug( ex.getMessage() );
        }
        return null;
    } // end_method

    // Метод возвращает категории
    public List<String> getAllCategories() {
        try {
            HttpHeaders headers = new HttpHeaders();
            HttpEntity<String> request = new HttpEntity<>(restBasicAuthHendler.getHeaders());
            ResponseEntity<CategoriesList> responseResult
                    = restTemplate.exchange(REST_URL_ALL_CATEGORIES_REQUEST, HttpMethod.GET, request, CategoriesList.class);

            return responseResult.getBody().getCategoriesList();
        } catch ( ResourceAccessException | HttpClientErrorException | HttpServerErrorException ex ) {
            Log.debug( ex.getMessage() );
        }
        return null;
    } // end_method

    // Метод возвращает пользователей - из таблицы ARTEFACTS
    public List<String> getAllUsers() {
        try {
            HttpHeaders headers = new HttpHeaders();
            HttpEntity<String> request = new HttpEntity<>(restBasicAuthHendler.getHeaders());
            ResponseEntity<UserList> responseResult
                    = restTemplate.exchange(REST_URL_ALL_USERS_REQUEST, HttpMethod.GET, request, UserList.class);

            return responseResult.getBody().getUserList();
        } catch ( ResourceAccessException | HttpClientErrorException | HttpServerErrorException ex ) {
            Log.debug( ex.getMessage() );
        }
        return null;
    } // end_method




} // end_class
