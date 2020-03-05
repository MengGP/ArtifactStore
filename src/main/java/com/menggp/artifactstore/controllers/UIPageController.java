package com.menggp.artifactstore.controllers;

import com.menggp.artifactstore.dao.Artifact;
import com.menggp.artifactstore.dto.ArtifactList;
import org.apache.tomcat.util.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class UIPageController {

    private static final Logger Log = LoggerFactory.getLogger(UIPageController.class);

    private static final String REST_URL_ALL_ARTIFACTS_REQUEST = "http://localhost:8077/allArtifactsRequest";

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/")
    public String index(Model model) {
        return "home";
    }

    @RequestMapping("/showAllArtifacts")
    public String showAllArtifacts(Model model) {

        try {

            HttpHeaders headers = new HttpHeaders();
            HttpEntity<String> request = new HttpEntity<>(getHeaders());
            ResponseEntity<ArtifactList> responseResult
                    // = restTemplate.getForEntity(REST_URL_ALL_ARTIFACTS_REQUEST, request, String.class);
                    = restTemplate.exchange(REST_URL_ALL_ARTIFACTS_REQUEST, HttpMethod.GET, request, ArtifactList.class);

            List<Artifact> allArtifacts = new ArrayList<>();
            allArtifacts = responseResult.getBody().getArtifactList();

            model.addAttribute("artifactList", allArtifacts);
        } catch ( ResourceAccessException | HttpClientErrorException | HttpServerErrorException ex ) {
            Log.debug( ex.getMessage() );
        }

        return "home";
    } // end_method

    //  Метод формирует HTTP-headers для использования Basic-Authentication в REST запросах
    private static HttpHeaders getHeaders(){
        String plainCredentials="user:user";
        String base64Credentials = new String(Base64.encodeBase64(plainCredentials.getBytes()));

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Basic " + base64Credentials);
        // headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        return headers;
    } // end_class


} // end_class
