package com.menggp.artifactstore.clientInterfaceMVC.services;

import com.menggp.artifactstore.model.Artifact;
import com.menggp.artifactstore.model.dto.ArtifactList;
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
    Обрабочтки посылающие REST запросы на чтение-сортировку
        параметры в запросе: содержание фильтра, поле сортировки, направление
        - фильтр - по категории:
            - Категории - String cat
            - Автору - String userId
            - Описаиню - String desc
            - Содержанию комментариев - String comment
         - поле сортривки: int sortType
            1 - Категория(cat)
            2 - Автор(user)
            3 - Время создания(created)
         - направлениe: boolean sortDirection
            ASC по возрастанию = true
            DESK по убыванию = false
*/
@Service
public class RestSortRequestHandler {

    private static final Logger Log = LoggerFactory.getLogger(RestSortRequestHandler.class);

    private static final String REST_URL_ART_ALL_SORT = APP_URL+"/artAllSort";
    private static final String REST_URL_ART_FILTER_BY_CAT_SORT = APP_URL+"/artFilterByCatSort";
    private static final String REST_URL_ART_FILTER_BY_USER_SORT = APP_URL+"/artFilterByUserSort";
    private static final String REST_URL_ART_FILTER_BY_DESC_SORT = APP_URL+"/artFilterByDescSort";
    private static final String REST_URL_ART_FILTER_BY_COMMENT_SORT = APP_URL+"/artFilterByCommentSort";

    private static final String REST_URL_ARTIFACTS = APP_URL + "/artifacts";
    private static final String REST_URL_COMMENTS = APP_URL + "/comments";

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    BasicAuthHandler basicAuthHandler;

    // запрос без фильтра - сортировка по всем артифактам
    public List<Artifact> sortAllArtifact(int sortType, boolean sortDirection) {
        /*try {
            HttpHeaders headers = new HttpHeaders();
            HttpEntity<String> request = new HttpEntity<>(basicAuthHandler.getHeaders());
            ResponseEntity<ArtifactList> responseResult
                    = restTemplate.exchange(REST_URL_ART_ALL_SORT
                            +"?sortType="+sortType
                            +"&sortDirection="+sortDirection
                    , HttpMethod.GET, request, ArtifactList.class);

            return responseResult.getBody().getArtifactList();
        } catch ( ResourceAccessException | HttpClientErrorException | HttpServerErrorException ex ) {
            Log.debug( ex.getMessage() );
        }
        return null;*/
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.addAll(basicAuthHandler.getHeaders());
            HttpEntity<String> request = new HttpEntity<>(basicAuthHandler.getHeaders());

            String requestUri = REST_URL_ARTIFACTS
                    +"?sortType="+sortType
                    +"&sortDirection="+sortDirection;
            ResponseEntity<ArtifactList> responseResult
                    = restTemplate.exchange(requestUri, HttpMethod.GET, request, ArtifactList.class);

            return responseResult.getBody().getArtifactList();
        } catch ( ResourceAccessException | HttpClientErrorException | HttpServerErrorException ex ) {
            Log.debug( ex.getMessage() );
        }
        return null;
    } // end_method

    // запрос с фильторм по категории(category)
    public List<Artifact> sortArtifactFilteredByCategory(String cat, int sortType, boolean sortDirection) {
        /*try {
            HttpHeaders headers = new HttpHeaders();
            HttpEntity<String> request = new HttpEntity<>(basicAuthHandler.getHeaders());
            ResponseEntity<ArtifactList> responseResult
                    = restTemplate.exchange(REST_URL_ART_FILTER_BY_CAT_SORT
                        +"?cat="+cat
                        +"&sortType="+sortType
                        +"&sortDirection="+sortDirection
                    , HttpMethod.GET, request, ArtifactList.class);

            return responseResult.getBody().getArtifactList();
        } catch ( ResourceAccessException | HttpClientErrorException | HttpServerErrorException ex ) {
            Log.debug( ex.getMessage() );
        }
        return null;*/
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.addAll(basicAuthHandler.getHeaders());
            HttpEntity<String> request = new HttpEntity<>(headers);

            String requstUri = REST_URL_ARTIFACTS
                    +"?cat="+cat
                    +"&sortType="+sortType
                    +"&sortDirection="+sortDirection;
            ResponseEntity<ArtifactList> responseResult
                    = restTemplate.exchange(requstUri, HttpMethod.GET, request, ArtifactList.class);

            return responseResult.getBody().getArtifactList();
        } catch ( ResourceAccessException | HttpClientErrorException | HttpServerErrorException ex ) {
            Log.debug( ex.getMessage() );
        }
        return null;
    } // end_method

    // запрос с фильторм по автору(userId)
    public List<Artifact> sortArtifactFilteredByUserId(String user, int sortType, boolean sortDirection) {
        /*try {
            HttpHeaders headers = new HttpHeaders();
            HttpEntity<String> request = new HttpEntity<>(basicAuthHandler.getHeaders());
            ResponseEntity<ArtifactList> responseResult
                    = restTemplate.exchange(REST_URL_ART_FILTER_BY_USER_SORT
                            +"?userId="+userId
                            +"&sortType="+sortType
                            +"&sortDirection="+sortDirection
                    , HttpMethod.GET, request, ArtifactList.class);

            return responseResult.getBody().getArtifactList();
        } catch ( ResourceAccessException | HttpClientErrorException | HttpServerErrorException ex ) {
            Log.debug( ex.getMessage() );
        }
        return null;*/
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.addAll(basicAuthHandler.getHeaders());
            HttpEntity<String> request = new HttpEntity<>(headers);

            String requestUri = REST_URL_ARTIFACTS
                    +"?user="+user
                    +"&sortType="+sortType
                    +"&sortDirection="+sortDirection;
            ResponseEntity<ArtifactList> responseResult
                    = restTemplate.exchange(requestUri, HttpMethod.GET, request, ArtifactList.class);

            return responseResult.getBody().getArtifactList();
        } catch ( ResourceAccessException | HttpClientErrorException | HttpServerErrorException ex ) {
            Log.debug( ex.getMessage() );
        }
        return null;
    } // end_method

    // запрос с фильторм по описанию(description)
    public List<Artifact> sortArtifactFilteredByDescription(String desc, int sortType, boolean sortDirection) {
        /*try {
            HttpHeaders headers = new HttpHeaders();
            HttpEntity<String> request = new HttpEntity<>(basicAuthHandler.getHeaders());
            ResponseEntity<ArtifactList> responseResult
                    = restTemplate.exchange(REST_URL_ART_FILTER_BY_DESC_SORT
                            +"?desc="+desc
                            +"&sortType="+sortType
                            +"&sortDirection="+sortDirection
                    , HttpMethod.GET, request, ArtifactList.class);

            return responseResult.getBody().getArtifactList();
        } catch ( ResourceAccessException | HttpClientErrorException | HttpServerErrorException ex ) {
            Log.debug( ex.getMessage() );
        }
        return null;*/
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.addAll(basicAuthHandler.getHeaders());
            HttpEntity<String> request = new HttpEntity<>(headers);

            String requestUri = REST_URL_ARTIFACTS
                    +"?desc="+desc
                    +"&sortType="+sortType
                    +"&sortDirection="+sortDirection;
            ResponseEntity<ArtifactList> responseResult
                    = restTemplate.exchange(requestUri, HttpMethod.GET, request, ArtifactList.class);

            return responseResult.getBody().getArtifactList();
        } catch ( ResourceAccessException | HttpClientErrorException | HttpServerErrorException ex ) {
            Log.debug( ex.getMessage() );
        }
        return null;
    } // end_method

    // запрос с фильторм по содержанию комментариев(comment - content)
    public List<Artifact> sortArtifactFilteredByComment(String comment, int sortType, boolean sortDirection) {
        /*try {
            HttpHeaders headers = new HttpHeaders();
            HttpEntity<String> request = new HttpEntity<>(basicAuthHandler.getHeaders());
            ResponseEntity<ArtifactList> responseResult
                    = restTemplate.exchange(REST_URL_ART_FILTER_BY_COMMENT_SORT
                            +"?comment="+comment
                            +"&sortType="+sortType
                            +"&sortDirection="+sortDirection
                    , HttpMethod.GET, request, ArtifactList.class);

            return responseResult.getBody().getArtifactList();
        } catch ( ResourceAccessException | HttpClientErrorException | HttpServerErrorException ex ) {
            Log.debug( ex.getMessage() );
        }
        return null;*/
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.addAll(basicAuthHandler.getHeaders());
            HttpEntity<String> request = new HttpEntity<>(headers);

            String requestUri = REST_URL_ARTIFACTS
                    +"?comment="+comment
                    +"&sortType="+sortType
                    +"&sortDirection="+sortDirection;
            ResponseEntity<ArtifactList> responseResult
                    = restTemplate.exchange(requestUri, HttpMethod.GET, request, ArtifactList.class);

            return responseResult.getBody().getArtifactList();
        } catch ( ResourceAccessException | HttpClientErrorException | HttpServerErrorException ex ) {
            Log.debug( ex.getMessage() );
        }
        return null;
    } // end_method


} // end_class
