package com.menggp.artifactstore.clientInterfaceMVC.services;

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
    Обрабочтки посылающие REST запросы на удаление
 */
@Service
public class RestDelRequestHandler {

    private static final Logger Log = LoggerFactory.getLogger(RestDelRequestHandler.class);

    private static final String REST_URL_DEL_ARTIFACT_REQUEST = APP_URL+"/delArt";
    private static final String REST_URL_DEL_COMMENT_REQUEST = APP_URL+"/delComment";

    private static final String REST_URL_ARTIFACTS = APP_URL + "/artifacts";
    private static final String REST_URL_ARTIFACTS_ID = APP_URL + "/artifacts/{id}";
    private static final String REST_URL_COMMENTS = APP_URL + "/comments";
    private static final String REST_URL_COMMENTS_ID = APP_URL + "/comments/{id}";

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    BasicAuthHandler basicAuthHandler;

    // DELETE - запрос на удаление в БД артефакта
    public int delArtifact(long id) {
        /*
        // Предпологаем возможность ошибки создания, изменятеся на 1 при подтверждении создания сервером
        int result = -1;
        try {
            HttpHeaders headers = new HttpHeaders();
            HttpEntity<String> request = new HttpEntity<>(basicAuthHandler.getHeaders());
            ResponseEntity<String> responseResult
                    = restTemplate.exchange(REST_URL_DEL_ARTIFACT_REQUEST+"?id="+id, HttpMethod.DELETE, request, String.class);
            if ( responseResult.getStatusCode().toString().equals("200 OK") )
                result = 1;
        } catch ( ResourceAccessException | HttpClientErrorException | HttpServerErrorException ex ) {
            Log.debug( ex.getMessage() );
        }
        return result;*/
        // Предпологаем возможность ошибки создания, изменятеся на 1 при подтверждении создания сервером
        int result = -1;
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.addAll(basicAuthHandler.getHeaders());
            HttpEntity<String> request = new HttpEntity<>(headers);

            String requestUri = REST_URL_ARTIFACTS_ID;
            Object[] uriVariables = new Object[] { id };
            ResponseEntity<String> responseResult
                    = restTemplate.exchange(requestUri, HttpMethod.DELETE, request, String.class, uriVariables);
            if ( responseResult.getStatusCode().toString().equals("200 OK") )
                result = 1;
        } catch ( ResourceAccessException | HttpClientErrorException | HttpServerErrorException ex ) {
            Log.debug( ex.getMessage() );
        }
        return result;
    } // end_method

    // DELETE - запрос на удаление в БД комментария
    public int delComment(long id) {
        /*
        // Предпологаем возможность ошибки создания, изменятеся на 1 при подтверждении создания сервером
        int result = -1;
        try {
            HttpHeaders headers = new HttpHeaders();
            HttpEntity<String> request = new HttpEntity<>(basicAuthHandler.getHeaders());
            ResponseEntity<String> responseResult
                    = restTemplate.exchange(REST_URL_DEL_COMMENT_REQUEST+"?id="+id, HttpMethod.DELETE, request, String.class);
            if ( responseResult.getStatusCode().toString().equals("200 OK") )
                result = 1;
        } catch ( ResourceAccessException | HttpClientErrorException | HttpServerErrorException ex ) {
            Log.debug( ex.getMessage() );
        }
        return result;*/
        // Предпологаем возможность ошибки создания, изменятеся на 1 при подтверждении создания сервером
        int result = -1;
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.addAll(basicAuthHandler.getHeaders());
            HttpEntity<String> request = new HttpEntity<>(headers);

            String requestUri = REST_URL_COMMENTS_ID;
            Object[] uriVariables = new Object[] { id };
            ResponseEntity<String> responseResult
                    = restTemplate.exchange(requestUri, HttpMethod.DELETE, request, String.class, uriVariables);
            if ( responseResult.getStatusCode().toString().equals("200 OK") )
                result = 1;
        } catch ( ResourceAccessException | HttpClientErrorException | HttpServerErrorException ex ) {
            Log.debug( ex.getMessage() );
        }
        return result;
    } // end_method


} // end_class
