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

@Service
public class RestSortRequestHandler {

    private static final Logger Log = LoggerFactory.getLogger(RestSortRequestHandler.class);

    private static final String REST_URL_ART_FILTER_BY_CAT_SORT = "http://localhost:8077/artFilterByCatSort";

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    RestBasicAuthHendler restBasicAuthHendler;

    /* Метод возвращает отсортированные артифакты c фильтром по Категории
     параметры в запросе: фильтр по категории, поле сортировки, направление
        - фильтр по категории: String cat
        - поле сортривки: int sortType
            1 - Категория(cat)
            2 - Автор(user)
            3 - Время создания(created)
         - направлениe: boolean sortDirection
            ASK по возрастанию = true
            DESK по убыванию = false
     */
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


} // end_class
