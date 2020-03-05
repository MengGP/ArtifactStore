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
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class RestRequestHandler {

    private static final Logger Log = LoggerFactory.getLogger(RestRequestHandler.class);

    private static final String REST_URL_ALL_ARTIFACTS_REQUEST = "http://localhost:8077/allArtifactsRequest";
    private static final String REST_URL_ALL_CATEGORIES_REQUEST = "http://localhost:8077/allCategories";
    private static final String REST_URL_ALL_USERS_REQUEST = "http://localhost:8077/allUsers";
    private static final String REST_URL_ARTIFACTS_REQUEST_BY_CAT = "http://localhost:8077/artRequestByCategory";
    private static final String REST_URL_ARTIFACTS_REQUEST_BY_USER = "http://localhost:8077/artRequestByUser";

    @Autowired
    RestTemplate restTemplate;

    // Метод возвращает список всех артификтов
    public List<Artifact> getAllArtifacs() {
        try {
            HttpHeaders headers = new HttpHeaders();
            HttpEntity<String> request = new HttpEntity<>(getHeaders());
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
            HttpEntity<String> request = new HttpEntity<>(getHeaders());
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
            HttpEntity<String> request = new HttpEntity<>(getHeaders());
            ResponseEntity<ArtifactList> responseResult
                    = restTemplate.exchange(REST_URL_ARTIFACTS_REQUEST_BY_USER +"?user="+user, HttpMethod.GET, request, ArtifactList.class);

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
            HttpEntity<String> request = new HttpEntity<>(getHeaders());
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
            HttpEntity<String> request = new HttpEntity<>(getHeaders());
            ResponseEntity<UserList> responseResult
                    = restTemplate.exchange(REST_URL_ALL_USERS_REQUEST, HttpMethod.GET, request, UserList.class);

            return responseResult.getBody().getUserList();
        } catch ( ResourceAccessException | HttpClientErrorException | HttpServerErrorException ex ) {
            Log.debug( ex.getMessage() );
        }
        return null;
    } // end_method

    //  Метод формирует HTTP-headers для использования Basic-Authentication в REST запросах
    public static HttpHeaders getHeaders(){
        String plainCredentials="user:user";
        String base64Credentials = new String(Base64.encodeBase64(plainCredentials.getBytes()));

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Basic " + base64Credentials);
        // headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        return headers;
    } // end_class


} // end_class
