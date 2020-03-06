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
public class RestUpdateRequestHandler {

    private static final Logger Log = LoggerFactory.getLogger(RestUpdateRequestHandler.class);

    private static final String REST_URL_UPDATE_ARTIFACT_REQUEST = "http://localhost:8077/updateArt";

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

            Log.info( String.valueOf( updatedArt.getId() ));

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

} // end_class






















