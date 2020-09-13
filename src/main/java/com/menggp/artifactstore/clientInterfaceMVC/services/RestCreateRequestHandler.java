package com.menggp.artifactstore.clientInterfaceMVC.services;

import com.menggp.artifactstore.model.Artifact;
import com.menggp.artifactstore.model.Comment;
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

import static com.menggp.artifactstore.boot.ArtifactStoreApp.APP_URL;

/*
    Обрабочтки посылающие REST запросы на создание
 */
@Service
public class RestCreateRequestHandler {

    private static final Logger Log = LoggerFactory.getLogger(RestCreateRequestHandler.class);

    private static final String REST_URL_CREATE_ARTIFACT_REQUEST = APP_URL+"/createArt";
    private static final String REST_URL_CREATE_COMMENT_REQUEST = APP_URL+"/createComment";

    private static final String REST_URL_ARTIFACTS = APP_URL + "/artifacts";
    private static final String REST_URL_COMMENTS = APP_URL + "/comments";


    @Autowired
    RestTemplate restTemplate;

    @Autowired
    BasicAuthHandler basicAuthHandler;

    // POST - запрос на создание в БД нового артифакта
    public int createArtifact(String user, String cat, String desc) {
        // Предпологаем возможность ошибки создания, изменятеся на 1 при подтверждении создания сервером
        int result = -1;
        try {
            Artifact newArt = new Artifact();
            newArt.setUserId(user);
            newArt.setCategory(cat);
            newArt.setDescription(desc);

            HttpHeaders headers = new HttpHeaders();
            headers.addAll(basicAuthHandler.getHeaders());

            // Object[] uriVariables = new Object[] {} ;

            HttpEntity<Object> request = new HttpEntity<>(newArt, headers);
            String requestUri = REST_URL_ARTIFACTS;
            ResponseEntity<Artifact> responseResult
                    = restTemplate.exchange(requestUri, HttpMethod.POST, request, Artifact.class); //, uriVariables);
            if ( responseResult.getStatusCode().toString().equals("200 OK") )
                result = 1;

        } catch ( ResourceAccessException | HttpClientErrorException | HttpServerErrorException ex ) {
            Log.debug( ex.getMessage() );
        }
        return result;
    } // end_method

    // POST - запрос на создание в БД нового комментария
    public int createComment(String userId, String content, long artId) {
        // Предпологаем возможность ошибки создания, изменятеся на 1 при подтверждении создания сервером
        int result = -1;
        try {
            Comment newComment = new Comment();
            newComment.setUserId(userId);
            newComment.setContent(content);
            newComment.setArtifactId(artId);

            HttpHeaders headers = new HttpHeaders();
            headers.addAll(basicAuthHandler.getHeaders());

            HttpEntity<Object> request = new HttpEntity<>(newComment, headers);
            String requestUri = REST_URL_COMMENTS;
            ResponseEntity<Comment> responseResult
                    = restTemplate.exchange(requestUri, HttpMethod.POST, request, Comment.class);
            if ( responseResult.getStatusCode().toString().equals("200 OK") )
                result = 1;

        } catch ( ResourceAccessException | HttpClientErrorException | HttpServerErrorException ex ) {
            Log.debug( ex.getMessage() );
        }
        return result;
    } // end_method


} // end_class






















