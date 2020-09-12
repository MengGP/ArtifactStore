package com.menggp.artifactstore.clientInterfaceMVC.services;

import com.menggp.artifactstore.model.Artifact;
import com.menggp.artifactstore.model.Comment;
import com.menggp.artifactstore.model.dto.ArtifactList;
import com.menggp.artifactstore.model.dto.StringList;
import com.menggp.artifactstore.model.dto.CommentList;
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

    private static final String REST_URL_ARTIFACTS = APP_URL + "/artifacts";
    private static final String REST_URL_ARTIFACTS_ID = APP_URL + "/artifacts/{id}";
    private static final String REST_URL_ARTIFACTS_CAT = APP_URL + "/artifacts/categories";
    private static final String REST_URL_ARTIFACTS_USER = APP_URL + "/artifacts/users";
    private static final String REST_URL_ARTIFACTS_COMMENT_NUM = APP_URL + "/artifacts/comment_num";
    private static final String REST_URL_COMMENTS = APP_URL + "/comments";
    private static final String REST_URL_COMMENTS_ID = APP_URL + "/comments/{id}";




    @Autowired
    RestTemplate restTemplate;

    @Autowired
    BasicAuthHandler basicAuthHandler;

    // Метод возвращает Артифакт по ID
    public Artifact getArtById(long id) {
        /*
        try {
            HttpHeaders headers = new HttpHeaders();
            HttpEntity<String> request = new HttpEntity<>(basicAuthHandler.getHeaders());
            ResponseEntity<Artifact> responseResult
                    = restTemplate.exchange(REST_URL_ARTIFACTS_BY_ID_REQUEST + "?id="+id, HttpMethod.GET, request, Artifact.class);

            return responseResult.getBody();
        } catch ( ResourceAccessException | HttpClientErrorException | HttpServerErrorException ex ) {
            Log.debug( ex.getMessage() );
        }
        return null;*/
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.addAll(basicAuthHandler.getHeaders());
            HttpEntity<String> request = new HttpEntity<>(headers);

            Object[] uriVariables = new Object[] { id };
            ResponseEntity<Artifact> responseResult
                    = restTemplate.exchange(REST_URL_ARTIFACTS_ID, HttpMethod.GET, request, Artifact.class, uriVariables);

            return responseResult.getBody();
        } catch ( ResourceAccessException | HttpClientErrorException | HttpServerErrorException ex ) {
            Log.debug( ex.getMessage() );
        }
        return null;
    } // end_method

    // Метод возвращает Комментарий по ID
    public Comment getCommentById(long id) {
        /*try {
            HttpHeaders headers = new HttpHeaders();
            HttpEntity<String> request = new HttpEntity<>(basicAuthHandler.getHeaders());
            ResponseEntity<Comment> responseResult
                    = restTemplate.exchange(REST_URL_COMMENT_BY_ID_REQUEST + "?id="+id, HttpMethod.GET, request, Comment.class);

            return responseResult.getBody();
        } catch ( ResourceAccessException | HttpClientErrorException | HttpServerErrorException ex ) {
            Log.debug( ex.getMessage() );
        }
        return null;*/
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.addAll(basicAuthHandler.getHeaders());
            HttpEntity<String> request = new HttpEntity<>(headers);

            Object[] uriVariables = new Object[] { id };
            ResponseEntity<Comment> responseResult
                    = restTemplate.exchange(REST_URL_COMMENTS_ID, HttpMethod.GET, request, Comment.class, uriVariables);

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
            HttpEntity<String> request = new HttpEntity<>(basicAuthHandler.getHeaders());
            ResponseEntity<ArtifactList> responseResult
                    = restTemplate.exchange(REST_URL_ARTIFACTS, HttpMethod.GET, request, ArtifactList.class);

            return responseResult.getBody().getArtifactList();
        } catch ( ResourceAccessException | HttpClientErrorException | HttpServerErrorException ex ) {
            Log.debug( ex.getMessage() );
        }
        return null;
    } // end_method

    // Метод возвращает список артификтов - отфильтрованный по категории
    public List<Artifact> getArtifacatsFilterByCategory(String cat) {
        /*try {
            HttpHeaders headers = new HttpHeaders();
            HttpEntity<String> request = new HttpEntity<>(basicAuthHandler.getHeaders());
            ResponseEntity<ArtifactList> responseResult
                    = restTemplate.exchange(REST_URL_ARTIFACTS_REQUEST_BY_CAT +"?cat="+cat, HttpMethod.GET, request, ArtifactList.class);

            return responseResult.getBody().getArtifactList();
        } catch ( ResourceAccessException | HttpClientErrorException | HttpServerErrorException ex ) {
            Log.debug( ex.getMessage() );
        }
        return null;*/
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.addAll(basicAuthHandler.getHeaders());
            HttpEntity<String> request = new HttpEntity<>(headers);

            String requestUri = REST_URL_ARTIFACTS + "?cat="+cat;
            ResponseEntity<ArtifactList> responseResult
                    = restTemplate.exchange(requestUri, HttpMethod.GET, request, ArtifactList.class);

            return responseResult.getBody().getArtifactList();
        } catch ( ResourceAccessException | HttpClientErrorException | HttpServerErrorException ex ) {
            Log.debug( ex.getMessage() );
        }
        return null;
    }

    // Метод возвращает список артификтов - отфильтрованный по пользователю
    public List<Artifact> getArtifacatsFilterByUser(String user) {
        /*try {
            HttpHeaders headers = new HttpHeaders();
            HttpEntity<String> request = new HttpEntity<>(basicAuthHandler.getHeaders());
            ResponseEntity<ArtifactList> responseResult
                    = restTemplate.exchange(REST_URL_ARTIFACTS_REQUEST_BY_USER +"?user="+user, HttpMethod.GET, request, ArtifactList.class);

            return responseResult.getBody().getArtifactList();
        } catch ( ResourceAccessException | HttpClientErrorException | HttpServerErrorException ex ) {
            Log.debug( ex.getMessage() );
        }
        return null;*/
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.addAll(basicAuthHandler.getHeaders());
            HttpEntity<String> request = new HttpEntity<>(headers);

            String requestsUri = REST_URL_ARTIFACTS + "?user="+user;
            ResponseEntity<ArtifactList> responseResult
                    = restTemplate.exchange(requestsUri, HttpMethod.GET, request, ArtifactList.class);

            return responseResult.getBody().getArtifactList();
        } catch ( ResourceAccessException | HttpClientErrorException | HttpServerErrorException ex ) {
            Log.debug( ex.getMessage() );
        }
        return null;
    } // end_method

    // Метод возвращает список артификтов - отфильтрованный по описанию
    public List<Artifact> getArtifacatsFilterByDescription(String desc) {
        /*try {
            HttpHeaders headers = new HttpHeaders();
            HttpEntity<String> request = new HttpEntity<>(basicAuthHandler.getHeaders());
            ResponseEntity<ArtifactList> responseResult
                    = restTemplate.exchange(REST_URL_ARTIFACTS_REQUEST_BY_DESC +"?desc="+desc, HttpMethod.GET, request, ArtifactList.class);

            return responseResult.getBody().getArtifactList();
        } catch ( ResourceAccessException | HttpClientErrorException | HttpServerErrorException ex ) {
            Log.debug( ex.getMessage() );
        }
        return null;*/
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.addAll(basicAuthHandler.getHeaders());
            HttpEntity<String> request = new HttpEntity<>(headers);

            String requestUri = REST_URL_ARTIFACTS + "?desc="+desc;
            ResponseEntity<ArtifactList> responseResult
                    = restTemplate.exchange(requestUri, HttpMethod.GET, request, ArtifactList.class);

            return responseResult.getBody().getArtifactList();
        } catch ( ResourceAccessException | HttpClientErrorException | HttpServerErrorException ex ) {
            Log.debug( ex.getMessage() );
        }
        return null;
    } // end_method

    // Метод возвращает список артификтов - отфильтрованный по сожержанию комментариеы
    public List<Artifact> getArtifacatsFilterByCommentContent(String comment) {
        /*try {
            HttpHeaders headers = new HttpHeaders();
            HttpEntity<String> request = new HttpEntity<>(basicAuthHandler.getHeaders());
            ResponseEntity<ArtifactList> responseResult
                    = restTemplate.exchange(REST_URL_ARTIFACTS_REQUEST_BY_COMMENT +"?comment="+comment, HttpMethod.GET, request, ArtifactList.class);

            return responseResult.getBody().getArtifactList();
        } catch ( ResourceAccessException | HttpClientErrorException | HttpServerErrorException ex ) {
            Log.debug( ex.getMessage() );
        }
        return null;*/
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.addAll(basicAuthHandler.getHeaders());
            HttpEntity<String> request = new HttpEntity<>(headers);

            String requestUri = REST_URL_ARTIFACTS +"?comment="+comment;
            ResponseEntity<ArtifactList> responseResult
                    = restTemplate.exchange(requestUri, HttpMethod.GET, request, ArtifactList.class);

            return responseResult.getBody().getArtifactList();
        } catch ( ResourceAccessException | HttpClientErrorException | HttpServerErrorException ex ) {
            Log.debug( ex.getMessage() );
        }
        return null;
    } // end_method

    // Метод возвращвет комментарии к Артефаку (по artifactId)
    public List<Comment> getCommentariesByArtifactId(long artId) {
        /*try {
            HttpHeaders headers = new HttpHeaders();
            HttpEntity<String> request = new HttpEntity<>(basicAuthHandler.getHeaders());
            ResponseEntity<CommentList> responseResult
                    = restTemplate.exchange(REST_URL_COMMENT_REQUEST_BY_ART +"?id="+artId, HttpMethod.GET, request, CommentList.class);

            return responseResult.getBody().getCommentList();
        } catch ( ResourceAccessException | HttpClientErrorException | HttpServerErrorException ex ) {
            Log.debug( ex.getMessage() );
        }
        return null;*/
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.addAll(basicAuthHandler.getHeaders());
            HttpEntity<String> request = new HttpEntity<>(headers);

            String requestUri = REST_URL_COMMENTS +"?artId="+artId;
            ResponseEntity<CommentList> responseResult
                    = restTemplate.exchange(requestUri, HttpMethod.GET, request, CommentList.class);

            return responseResult.getBody().getCommentList();
        } catch ( ResourceAccessException | HttpClientErrorException | HttpServerErrorException ex ) {
            Log.debug( ex.getMessage() );
        }
        return null;
    } // end_method

    // Метод возвращает категории
    public List<String> getAllCategories() {
        /*try {
            HttpHeaders headers = new HttpHeaders();
            HttpEntity<String> request = new HttpEntity<>(basicAuthHandler.getHeaders());
            ResponseEntity<StringList> responseResult
                    = restTemplate.exchange(REST_URL_ALL_CATEGORIES_REQUEST, HttpMethod.GET, request, StringList.class);

            return responseResult.getBody().getStringList();
        } catch ( ResourceAccessException | HttpClientErrorException | HttpServerErrorException ex ) {
            Log.debug( ex.getMessage() );
        }
        return null;*/
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.addAll(basicAuthHandler.getHeaders());
            HttpEntity<String> request = new HttpEntity<>(headers);

            String requestUri = REST_URL_ARTIFACTS_CAT;
            ResponseEntity<StringList> responseResult
                    = restTemplate.exchange(requestUri, HttpMethod.GET, request, StringList.class);

            return responseResult.getBody().getStringList();
        } catch ( ResourceAccessException | HttpClientErrorException | HttpServerErrorException ex ) {
            Log.debug( ex.getMessage() );
        }
        return null;
    } // end_method

    // Метод возвращает пользователей - из таблицы ARTEFACTS
    public List<String> getAllUsers() {
        /*try {
            HttpHeaders headers = new HttpHeaders();
            HttpEntity<String> request = new HttpEntity<>(basicAuthHandler.getHeaders());
            ResponseEntity<StringList> responseResult
                    = restTemplate.exchange(REST_URL_ALL_USERS_REQUEST, HttpMethod.GET, request, StringList.class);

            return responseResult.getBody().getStringList();
        } catch ( ResourceAccessException | HttpClientErrorException | HttpServerErrorException ex ) {
            Log.debug( ex.getMessage() );
        }
        return null;*/
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.addAll(basicAuthHandler.getHeaders());
            HttpEntity<String> request = new HttpEntity<>(headers);

            String requestUri = REST_URL_ARTIFACTS_USER;
            ResponseEntity<StringList> responseResult
                    = restTemplate.exchange(requestUri, HttpMethod.GET, request, StringList.class);

            return responseResult.getBody().getStringList();
        } catch ( ResourceAccessException | HttpClientErrorException | HttpServerErrorException ex ) {
            Log.debug( ex.getMessage() );
        }
        return null;
    } // end_method

    // Метод возвращает количество комментариев к артифату
    public long getCommentsNumber( long artId ) {
        /* try {
            HttpHeaders headers = new HttpHeaders();
            HttpEntity<String> request = new HttpEntity<>(basicAuthHandler.getHeaders());
            ResponseEntity<Long> responseResult
                    = restTemplate.exchange(REST_URL_COMMENTS_NUM_REQUEST+"?id="+artId, HttpMethod.GET, request, Long.class);

            return responseResult.getBody();
        } catch ( ResourceAccessException | HttpClientErrorException | HttpServerErrorException ex ) {
            Log.debug( ex.getMessage() );
        }
        return 0;*/
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.addAll(basicAuthHandler.getHeaders());
            HttpEntity<String> request = new HttpEntity<>(headers);

            String requestUri = REST_URL_ARTIFACTS_COMMENT_NUM +"?artId="+artId;
            ResponseEntity<Long> responseResult
                    = restTemplate.exchange(requestUri, HttpMethod.GET, request, Long.class);

            return responseResult.getBody();
        } catch ( ResourceAccessException | HttpClientErrorException | HttpServerErrorException ex ) {
            Log.debug( ex.getMessage() );
        }
        return 0;
    } // end_method



} // end_class
