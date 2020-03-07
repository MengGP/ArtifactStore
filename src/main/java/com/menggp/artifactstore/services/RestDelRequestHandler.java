package com.menggp.artifactstore.services;

import com.menggp.artifactstore.dao.Artifact;
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

@Service
public class RestDelRequestHandler {

    private static final Logger Log = LoggerFactory.getLogger(RestDelRequestHandler.class);

    private static final String REST_URL_DEL_ARTIFACT_REQUEST = "http://localhost:8077/delArt";

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    RestBasicAuthHendler restBasicAuthHendler;

    // DELETE - запрос на удаление в БД артефакта
    public int delArtifact(long id) {
        // Предпологаем возможность ошибки создания, изменятеся на 1 при подтверждении создания сервером
        int result = -1;
        try {
            HttpHeaders headers = new HttpHeaders();
            HttpEntity<String> request = new HttpEntity<>(restBasicAuthHendler.getHeaders());
            ResponseEntity<String> responseResult
                    = restTemplate.exchange(REST_URL_DEL_ARTIFACT_REQUEST+"?id="+id, HttpMethod.DELETE, request, String.class);
            if ( responseResult.getStatusCode().toString().equals("200 OK") )
                result = 1;
        } catch ( ResourceAccessException | HttpClientErrorException | HttpServerErrorException ex ) {
            Log.debug( ex.getMessage() );
        }
        return result;
    } // end_method



} // end_class
