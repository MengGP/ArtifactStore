package com.menggp.artifactstore.services;

import com.menggp.artifactstore.dao.Artifact;
import com.menggp.artifactstore.dto.ArtifactList;
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

import java.net.URI;

@Service
public class RestCreateRequestHandler {

    private static final Logger Log = LoggerFactory.getLogger(RestCreateRequestHandler.class);

    private static final String REST_URL_CREATE_ARTIFACT_REQUEST = "http://localhost:8077/createArt";

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    RestBasicAuthHendler restBasicAuthHendler;

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
            HttpEntity<Object> request = new HttpEntity<>(newArt, restBasicAuthHendler.getHeaders());
            ResponseEntity<Artifact> responseResult
                    = restTemplate.exchange(REST_URL_CREATE_ARTIFACT_REQUEST, HttpMethod.POST, request, Artifact.class);
            if ( responseResult.getStatusCode().toString().equals("200 OK") )
                result = 1;

        } catch ( ResourceAccessException | HttpClientErrorException | HttpServerErrorException ex ) {
            Log.debug( ex.getMessage() );
        }
        return result;
    } // end_method

} // end_class






















