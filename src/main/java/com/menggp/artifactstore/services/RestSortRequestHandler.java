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

import java.util.List;

/* Методы возвращает отсортированные артифакты c фильтроми,
     параметры в запросе: содержание фильтра, поле сортировки, направление
        - фильтр по:  категории:
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

    private static final String REST_URL_ART_ALL_SORT = "http://localhost:8077/artAllSort";
    private static final String REST_URL_ART_FILTER_BY_CAT_SORT = "http://localhost:8077/artFilterByCatSort";
    private static final String REST_URL_ART_FILTER_BY_USER_SORT = "http://localhost:8077/artFilterByUserSort";
    private static final String REST_URL_ART_FILTER_BY_DESC_SORT = "http://localhost:8077/artFilterByDescSort";
    private static final String REST_URL_ART_FILTER_BY_COMMENT_SORT = "http://localhost:8077//artFilterByCommentSort";

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    RestBasicAuthHendler restBasicAuthHendler;

    // запрос без фильтра - сортировка по всем артифактам
    public List<Artifact> sortAllArtifact(int sortType, boolean sortDirection) {
        try {
            HttpHeaders headers = new HttpHeaders();
            HttpEntity<String> request = new HttpEntity<>(restBasicAuthHendler.getHeaders());
            ResponseEntity<ArtifactList> responseResult
                    = restTemplate.exchange(REST_URL_ART_ALL_SORT
                            +"?sortType="+sortType
                            +"&sortDirection="+sortDirection
                    , HttpMethod.GET, request, ArtifactList.class);

            return responseResult.getBody().getArtifactList();
        } catch ( ResourceAccessException | HttpClientErrorException | HttpServerErrorException ex ) {
            Log.debug( ex.getMessage() );
        }
        return null;
    } // end_method

    // запрос с фильторм по категории(category)
    public List<Artifact> sortArtifactFilteredByCategory(String cat, int sortType, boolean sortDirection) {
        try {
            HttpHeaders headers = new HttpHeaders();
            HttpEntity<String> request = new HttpEntity<>(restBasicAuthHendler.getHeaders());
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
        return null;
    } // end_method

    // запрос с фильторм по автору(userId)
    public List<Artifact> sortArtifactFilteredByUserId(String userId, int sortType, boolean sortDirection) {
        try {
            HttpHeaders headers = new HttpHeaders();
            HttpEntity<String> request = new HttpEntity<>(restBasicAuthHendler.getHeaders());
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
        return null;
    } // end_method

    // запрос с фильторм по описанию(description)
    public List<Artifact> sortArtifactFilteredByDescription(String desc, int sortType, boolean sortDirection) {
        try {
            HttpHeaders headers = new HttpHeaders();
            HttpEntity<String> request = new HttpEntity<>(restBasicAuthHendler.getHeaders());
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
        return null;
    } // end_method

    // запрос с фильторм по содержанию комментариев(comment - content)
    public List<Artifact> sortArtifactFilteredByComment(String comment, int sortType, boolean sortDirection) {
        try {
            HttpHeaders headers = new HttpHeaders();
            HttpEntity<String> request = new HttpEntity<>(restBasicAuthHendler.getHeaders());
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
        return null;
    } // end_method


} // end_class
