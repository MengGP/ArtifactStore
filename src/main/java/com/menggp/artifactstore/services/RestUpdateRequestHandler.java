package com.menggp.artifactstore.services;

import com.menggp.artifactstore.boot.ArtifactStoreApp;
import com.menggp.artifactstore.dao.Artifact;
import com.menggp.artifactstore.dao.Comment;
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

import java.util.Date;

import static com.menggp.artifactstore.boot.ArtifactStoreApp.APP_URL;

/*
    Обрабочтки посылающие REST запросы на обновлние
 */
@Service
public class RestUpdateRequestHandler {

    private static final Logger Log = LoggerFactory.getLogger(RestUpdateRequestHandler.class);

    private static final String REST_URL_UPDATE_ARTIFACT_REQUEST = APP_URL+"/updateArt";
    private static final String REST_URL_UPDATE_COMMENT_REQUEST = APP_URL+"/updateComment";

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    RestBasicAuthHendler restBasicAuthHendler;

    // PUT - запрос на изменение в БД артефакта
    public int updateArtifact(long id, String user, String cat, String desc, Date created) {
        // Предпологаем возможность ошибки создания, изменятеся на 1 при подтверждении создания сервером
        int result = -1;
        try {
            Artifact updatedArt = new Artifact();
            updatedArt.setId(id);
            updatedArt.setUserId(user);
            updatedArt.setCategory(cat);
            updatedArt.setDescription(desc);
            updatedArt.setCreated(created);

            HttpHeaders headers = new HttpHeaders();
            HttpEntity<Object> request = new HttpEntity<>(updatedArt, restBasicAuthHendler.getHeaders());
            ResponseEntity<Artifact> responseResult
                    = restTemplate.exchange(REST_URL_UPDATE_ARTIFACT_REQUEST, HttpMethod.PUT, request, Artifact.class);
            if ( responseResult.getStatusCode().toString().equals("200 OK") )
                result = 1;
        } catch ( ResourceAccessException | HttpClientErrorException | HttpServerErrorException ex ) {
            Log.debug( ex.getMessage() );
        }
        return result;
    } // end_method

    // PUT - запрос на ихменене в БД комментария
    public int updateComment(long id, String userId, String content, long artId) {
        // Предпологаем возможность ошибки создания, изменятеся на 1 при подтверждении создания сервером
        int result = -1;
        try {
            Comment updatedComment = new Comment();
            updatedComment.setId(id);
            updatedComment.setUserId(userId);
            updatedComment.setContent(content);
            updatedComment.setArtifactId(artId);

            HttpHeaders headers = new HttpHeaders();
            HttpEntity<Object> request = new HttpEntity<>(updatedComment, restBasicAuthHendler.getHeaders());
            ResponseEntity<Comment> responseResult
                    = restTemplate.exchange(REST_URL_UPDATE_COMMENT_REQUEST, HttpMethod.PUT, request, Comment.class);
            if ( responseResult.getStatusCode().toString().equals("200 OK") )
                result = 1;
        } catch ( ResourceAccessException | HttpClientErrorException | HttpServerErrorException ex ) {
            Log.debug( ex.getMessage() );
        }
        return result;
    } // end_method

} // end_class






















