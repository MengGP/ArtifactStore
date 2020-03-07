package com.menggp.artifactstore.services;

import com.menggp.artifactstore.boot.ArtifactStoreApp;
import com.menggp.artifactstore.dao.Artifact;
import com.menggp.artifactstore.dao.Comment;
import com.menggp.artifactstore.dto.ArtifactList;
import com.menggp.artifactstore.dto.StringList;
import com.menggp.artifactstore.dto.CommentList;
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

import static com.menggp.artifactstore.boot.ArtifactStoreApp.APP_URL;

/*
    Обрабочтки посылающие REST запросы на чтение-поиск
 */
@Service
public class RestReadRequestHandler {

    private static final Logger Log = LoggerFactory.getLogger(RestReadRequestHandler.class);

    private static final String REST_URL_ARTIFACTS_BY_ID_REQUEST = APP_URL+"/artifactById";
    private static final String REST_URL_COMMENT_BY_ID_REQUEST = APP_URL+"/commentById";
    private static final String REST_URL_ALL_ARTIFACTS_REQUEST = APP_URL+"/allArtifactsRequest";
    private static final String REST_URL_ALL_CATEGORIES_REQUEST = APP_URL+"/allCategories";
    private static final String REST_URL_COMMENTS_NUM_REQUEST = APP_URL+"/commentsNum";
    private static final String REST_URL_ALL_USERS_REQUEST = APP_URL+"/allUsers";
    private static final String REST_URL_ARTIFACTS_REQUEST_BY_CAT = APP_URL+"/artRequestByCategory";
    private static final String REST_URL_ARTIFACTS_REQUEST_BY_USER = APP_URL+"/artRequestByUser";
    private static final String REST_URL_ARTIFACTS_REQUEST_BY_DESC = APP_URL+"/artRequestByDesc";
    private static final String REST_URL_ARTIFACTS_REQUEST_BY_COMMENT = APP_URL+"/artRequestByCommentContent";
    private static final String REST_URL_COMMENT_REQUEST_BY_ART = APP_URL+"/commentRequestByArt";

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
    } // end_method

    // Метод возвращает Комментарий по ID
    public Comment getCommentById(long id) {
        try {
            HttpHeaders headers = new HttpHeaders();
            HttpEntity<String> request = new HttpEntity<>(restBasicAuthHendler.getHeaders());
            ResponseEntity<Comment> responseResult
                    = restTemplate.exchange(REST_URL_COMMENT_BY_ID_REQUEST + "?id="+id, HttpMethod.GET, request, Comment.class);

            return responseResult.getBody();
        } catch ( ResourceAccessException | HttpClientErrorException | HttpServerErrorException ex ) {
            Log.debug( ex.getMessage() );
        }
        return null;
    } // end_method

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

    // Метод возвращвет комментарии к Артефаку (по artifactId)
    public List<Comment> getCommentariesByArtifactId(long artId) {
        try {
            HttpHeaders headers = new HttpHeaders();
            HttpEntity<String> request = new HttpEntity<>(restBasicAuthHendler.getHeaders());
            ResponseEntity<CommentList> responseResult
                    = restTemplate.exchange(REST_URL_COMMENT_REQUEST_BY_ART +"?id="+artId, HttpMethod.GET, request, CommentList.class);

            return responseResult.getBody().getCommentList();
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
            ResponseEntity<StringList> responseResult
                    = restTemplate.exchange(REST_URL_ALL_CATEGORIES_REQUEST, HttpMethod.GET, request, StringList.class);

            return responseResult.getBody().getStringList();
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
            ResponseEntity<StringList> responseResult
                    = restTemplate.exchange(REST_URL_ALL_USERS_REQUEST, HttpMethod.GET, request, StringList.class);

            return responseResult.getBody().getStringList();
        } catch ( ResourceAccessException | HttpClientErrorException | HttpServerErrorException ex ) {
            Log.debug( ex.getMessage() );
        }
        return null;
    } // end_method

    // Метод возвращает количество комментариев к артифату
    public long getCommentsNumber( long artId ) {
        try {
            HttpHeaders headers = new HttpHeaders();
            HttpEntity<String> request = new HttpEntity<>(restBasicAuthHendler.getHeaders());
            ResponseEntity<Long> responseResult
                    = restTemplate.exchange(REST_URL_COMMENTS_NUM_REQUEST+"?id="+artId, HttpMethod.GET, request, Long.class);

            return responseResult.getBody();
        } catch ( ResourceAccessException | HttpClientErrorException | HttpServerErrorException ex ) {
            Log.debug( ex.getMessage() );
        }
        return 0;
    } // end_method



} // end_class
