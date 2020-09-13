package com.menggp.artifactstore.clientInterfaceMVC.services;

import com.menggp.artifactstore.model.Artifact;
import com.menggp.artifactstore.model.ArtifactHist;
import com.menggp.artifactstore.model.Comment;
import com.menggp.artifactstore.model.dto.ArtifactHistList;
import com.menggp.artifactstore.model.dto.ArtifactList;
import com.menggp.artifactstore.model.dto.CommentList;
import com.menggp.artifactstore.model.dto.StringList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.List;

import static com.menggp.artifactstore.boot.ArtifactStoreApp.APP_URL;

/**
 * Класс реалзует интерфейс RequestHandler
 */
@Service
public class RequestHandlerImpl implements RequestHandler{

    private static final Logger Log = LoggerFactory.getLogger(RequestHandlerImpl.class);

    private static final String REST_URL_ARTIFACTS = APP_URL + "/artifacts";
    private static final String REST_URL_ARTIFACTS_ID = APP_URL + "/artifacts/{id}";
    private static final String REST_URL_ARTIFACTS_CAT = APP_URL + "/artifacts/categories";
    private static final String REST_URL_ARTIFACTS_USER = APP_URL + "/artifacts/users";
    private static final String REST_URL_ARTIFACTS_COMMENT_NUM = APP_URL + "/artifacts/comment_num";
    private static final String REST_URL_ARTIFACTS_HIST = APP_URL + "/artifacts/history";
    private static final String REST_URL_COMMENTS = APP_URL + "/comments";
    private static final String REST_URL_COMMENTS_ID = APP_URL + "/comments/{id}";

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    BasicAuthHandler basicAuthHandler;

    @Override
    public int createArtifact(String user, String cat, String desc) {
        return this.artifactChangeRequest(
                new Artifact(user, cat, desc),
                REST_URL_ARTIFACTS,
                HttpMethod.POST,
                new Object[] {}
        );
    }

    @Override
    public int createComment(String userId, String content, long artId) {
        return this.commentChangeRequest(
                new Comment(userId, content, artId),
                REST_URL_COMMENTS,
                HttpMethod.POST,
                new Object[] {}
        );
    }

    @Override
    public int delArtifact(long id) {
        return this.artifactChangeRequest(
                null,
                REST_URL_ARTIFACTS_ID,
                HttpMethod.DELETE,
                new Object[] { id }
        );
    }

    @Override
    public int delComment(long id) {
        return this.commentChangeRequest(
                null,
                REST_URL_COMMENTS_ID,
                HttpMethod.DELETE,
                new Object[] { id }
        );
    }

    @Override
    public int updateArtifact(long id, String user, String cat, String desc, Date created) {
        return  this.artifactChangeRequest(
                new Artifact(id, user, cat, desc, created),
                REST_URL_ARTIFACTS,
                HttpMethod.PUT,
                new Object[] {}
        );
    }

    @Override
    public int updateComment(long id, String userId, String content, long artId) {
        return this.commentChangeRequest(
                new Comment(id, userId, content, artId),
                REST_URL_COMMENTS,
                HttpMethod.PUT,
                new Object[] {}
        );
    }

    @Override
    public Artifact getArtById(long id) {
        return this.artifactSingleReadRequest(
                REST_URL_ARTIFACTS_ID,
                HttpMethod.GET,
                new Object[] { id }
        );
    }

    @Override
    public Comment getCommentById(long id) {
        return this.commentSingleReadRequest(
                REST_URL_COMMENTS_ID,
                HttpMethod.GET,
                new Object[] { id }
        );
   }

    @Override
    public List<String> getAllCategories() {
        return this.stringListReadRequest(
                REST_URL_ARTIFACTS_CAT,
                HttpMethod.GET,
                new Object[] {}
        );
    }

    @Override
    public List<String> getAllUsers() {
        return this.stringListReadRequest(
                REST_URL_ARTIFACTS_USER,
                HttpMethod.GET,
                new Object[] {}
        );
    }

    @Override
    public long getCommentsNumber( long artId ) {
        return this.longReadRequest(
                REST_URL_ARTIFACTS_COMMENT_NUM +"?artId="+artId,
                HttpMethod.GET,
                new Object[] { }
        );
    }

    @Override
    public List<Artifact> getAllArtifacs() {
        return this.artifactListReadRequest(
                REST_URL_ARTIFACTS,
                HttpMethod.GET,
                new Object[] {}
        );
    }

    @Override
    public List<Artifact> getArtifacatsFilterByCategory(String cat) {
        return this.artifactListReadRequest(
                REST_URL_ARTIFACTS + "?cat="+cat,
                HttpMethod.GET,
                new Object[] {}
        );
    }

    @Override
    public List<Artifact> getArtifacatsFilterByUser(String user) {
        return this.artifactListReadRequest(
                REST_URL_ARTIFACTS + "?user="+user,
                HttpMethod.GET,
                new Object[] {}
        );
    }

    @Override
    public List<Artifact> getArtifacatsFilterByDescription(String desc) {
        return this.artifactListReadRequest(
                REST_URL_ARTIFACTS + "?desc="+desc,
                HttpMethod.GET,
                new Object[] {}
        );
    }

    @Override
    public List<Artifact> getArtifacatsFilterByCommentContent(String comment) {
        return this.artifactListReadRequest(
                REST_URL_ARTIFACTS +"?comment="+comment,
                HttpMethod.GET,
                new Object[] {}
        );
    }

    @Override
    public List<Artifact> sortAllArtifact(int sortType, boolean sortDirection) {
        return this.artifactListReadRequest(
                REST_URL_ARTIFACTS
                        +"?sortType="+sortType
                        +"&sortDirection="+sortDirection,
                HttpMethod.GET,
                new Object[] {}
        );
    }

    @Override
    public List<Artifact> sortArtifactFilteredByCategory(String cat, int sortType, boolean sortDirection) {
        return this.artifactListReadRequest(
                REST_URL_ARTIFACTS
                        +"?cat="+cat
                        +"&sortType="+sortType
                        +"&sortDirection="+sortDirection,
                HttpMethod.GET,
                new Object[] {}
        );
    }

    @Override
    public List<Artifact> sortArtifactFilteredByUserId(String user, int sortType, boolean sortDirection) {
        return this.artifactListReadRequest(
                REST_URL_ARTIFACTS
                        +"?user="+user
                        +"&sortType="+sortType
                        +"&sortDirection="+sortDirection,
                HttpMethod.GET,
                new Object[] {}
        );
    }

    @Override
    public List<Artifact> sortArtifactFilteredByDescription(String desc, int sortType, boolean sortDirection) {
        return this.artifactListReadRequest(
                REST_URL_ARTIFACTS
                        +"?desc="+desc
                        +"&sortType="+sortType
                        +"&sortDirection="+sortDirection,
                HttpMethod.GET,
                new Object[] {}
        );
    }

    @Override
    public List<Artifact> sortArtifactFilteredByComment(String comment, int sortType, boolean sortDirection) {
        return this.artifactListReadRequest(
                REST_URL_ARTIFACTS
                        +"?comment="+comment
                        +"&sortType="+sortType
                        +"&sortDirection="+sortDirection,
                HttpMethod.GET,
                new Object[] {}
        );
    }

    @Override
    public List<Comment> getCommentariesByArtifactId(long artId) {
        return this.commentListReadRequest(
                REST_URL_COMMENTS +"?artId="+artId,
                HttpMethod.GET,
                new Object[] {}
        );
    }

    @Override
    public List<ArtifactHist> getArtifactsHistByArtifactId(long artId) {
        return this.artifactHistListReadRequest(
                REST_URL_ARTIFACTS_HIST +"?artId="+artId,
                HttpMethod.GET,
                new Object[] {}
        );
    }

    /**
     * Метод генерирует запрос на получение списка истории изменения артефакта по id артефакта
     * @param requestUri    - строка URI - запроса
     * @param httpMethod    - тип HTTP метода
     * @param uriVariables  - переменные запроса
     * @return - список исторических комментариев
     */
    private List<ArtifactHist> artifactHistListReadRequest(String requestUri, HttpMethod httpMethod, Object[] uriVariables) {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.addAll(basicAuthHandler.getHeaders());
            HttpEntity<String> request = new HttpEntity<>(headers);

            ResponseEntity<ArtifactHistList> responseResult
                    = restTemplate.exchange(requestUri, httpMethod, request, ArtifactHistList.class, uriVariables);

            return responseResult.getBody().getArtifactHistList();
        } catch ( ResourceAccessException | HttpClientErrorException | HttpServerErrorException ex ) {
            Log.debug( ex.getMessage() );
        }
        return null;
    }


    /**
     * Метод генерирует запрос на получение списка комментариев
     * @param requestUri    - строка URI - запроса
     * @param httpMethod    - тип HTTP метода
     * @param uriVariables  - переменные запроса
     * @return - список комментариев
     */
    private List<Comment> commentListReadRequest(String requestUri, HttpMethod httpMethod, Object[] uriVariables) {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.addAll(basicAuthHandler.getHeaders());
            HttpEntity<String> request = new HttpEntity<>(headers);

            ResponseEntity<CommentList> responseResult
                    = restTemplate.exchange(requestUri, httpMethod, request, CommentList.class, uriVariables);

            return responseResult.getBody().getCommentList();
        } catch ( ResourceAccessException | HttpClientErrorException | HttpServerErrorException ex ) {
            Log.debug( ex.getMessage() );
        }
        return null;
    }

    /**
     * Метод генерирует запрос на получение списка артефактов
     * @param requestUri    - строка URI - запроса
     * @param httpMethod    - тип HTTP метода
     * @param uriVariables  - переменные запроса
     * @return - список артефактов
     */
    private List<Artifact> artifactListReadRequest(String requestUri, HttpMethod httpMethod, Object[] uriVariables) {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.addAll(basicAuthHandler.getHeaders());
            HttpEntity<String> request = new HttpEntity<>(headers);

            ResponseEntity<ArtifactList> responseResult
                    = restTemplate.exchange(requestUri, httpMethod, request, ArtifactList.class, uriVariables);

            return responseResult.getBody().getArtifactList();
        } catch ( ResourceAccessException | HttpClientErrorException | HttpServerErrorException ex ) {
            Log.debug( ex.getMessage() );
        }
        return null;
    }

    /**
     * Метод генерирует запрос по получение данных, представляющих число - long
     * @param requestUri    - строка URI - запроса
     * @param httpMethod    - тип HTTP метода
     * @param uriVariables  - переменные запроса
     * @return - число long
     */
    private long longReadRequest(String requestUri, HttpMethod httpMethod, Object[] uriVariables) {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.addAll(basicAuthHandler.getHeaders());
            HttpEntity<String> request = new HttpEntity<>(headers);

            ResponseEntity<Long> responseResult
                    = restTemplate.exchange(requestUri, httpMethod, request, Long.class, uriVariables);

            return responseResult.getBody();
        } catch ( ResourceAccessException | HttpClientErrorException | HttpServerErrorException ex ) {
            Log.debug( ex.getMessage() );
        }
        return 0;
    }

    /**
     * Метод генерирует запрос на получение данных, представляющих список строк
     * @param requestUri    - строка URI - запроса
     * @param httpMethod    - тип HTTP метода
     * @param uriVariables  - переменные запроса
     * @return - список строк
     */
    private List<String> stringListReadRequest(String requestUri, HttpMethod httpMethod, Object[] uriVariables) {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.addAll(basicAuthHandler.getHeaders());
            HttpEntity<String> request = new HttpEntity<>(headers);

            ResponseEntity<StringList> responseResult
                    = restTemplate.exchange(requestUri, httpMethod, request, StringList.class, uriVariables);

            return responseResult.getBody().getStringList();
        } catch ( ResourceAccessException | HttpClientErrorException | HttpServerErrorException ex ) {
            Log.debug( ex.getMessage() );
        }
        return null;
    }

    /**
     * Метод генерирует запрос на получение комментария по id
     * @param requestUri    - строка URI - запроса
     * @param httpMethod    - тип HTTP метода
     * @param uriVariables  - переменные запроса
     * @return  - комментарий
     */
    private Comment commentSingleReadRequest(String requestUri, HttpMethod httpMethod, Object[] uriVariables) {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.addAll(basicAuthHandler.getHeaders());
            HttpEntity<String> request = new HttpEntity<>(headers);

            ResponseEntity<Comment> responseResult
                    = restTemplate.exchange(requestUri, httpMethod, request, Comment.class, uriVariables);

            return responseResult.getBody();
        } catch ( ResourceAccessException | HttpClientErrorException | HttpServerErrorException ex ) {
            Log.debug( ex.getMessage() );
        }
        return null;
    }

    /**
     * Метод генерирует запрос на получение артефакта по id
     * @param requestUri    - строка URI - запроса
     * @param httpMethod    - тип HTTP метода
     * @param uriVariables  - переменные запроса
     * @return  - артефакт
     */
    private Artifact artifactSingleReadRequest(String requestUri, HttpMethod httpMethod, Object[] uriVariables) {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.addAll(basicAuthHandler.getHeaders());
            HttpEntity<String> request = new HttpEntity<>(headers);

            ResponseEntity<Artifact> responseResult
                    = restTemplate.exchange(requestUri, httpMethod, request, Artifact.class, uriVariables);

            return responseResult.getBody();
        } catch ( ResourceAccessException | HttpClientErrorException | HttpServerErrorException ex ) {
            Log.debug( ex.getMessage() );
        }
        return null;
    }

    /**
     * Метод генерирует запрос на изменения артефакта (создание, обновление, удаление) к REST-сервису
     * @param art           - артефакт (создаваемый / изменяемый)
     * @param requestUri    - строка URI - запроса
     * @param httpMethod    - тип HTTP метода
     * @param uriVariables  - переменные запроса
     * @return  -   результат выполнения
     */
    private int artifactChangeRequest(Artifact art, String requestUri, HttpMethod httpMethod, Object[] uriVariables) {
        // Предпологаем возможность ошибки создания, изменятеся на 1 при подтверждении создания сервером
        int result = -1;
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.addAll(basicAuthHandler.getHeaders());

            HttpEntity<Object> request = new HttpEntity<>(art, headers);
            ResponseEntity<Artifact> responseResult
                    = restTemplate.exchange(requestUri, httpMethod, request, Artifact.class, uriVariables);
            if ( responseResult.getStatusCode() == HttpStatus.OK )
                result = 1;

        } catch ( ResourceAccessException | HttpClientErrorException | HttpServerErrorException ex ) {
            Log.debug( ex.getMessage() );
        }
        return result;
    }

    /**
     * Метод генерирует запрос на изменения артефакта (создание, обновление, удаление) к REST-сервису
     * @param comment       - комментарий (создаваемый / изменяемый)
     * @param requestUri    - строка URI - запроса
     * @param httpMethod    - тип HTTP метода
     * @param uriVariables  - переменные запроса
     * @return  -   результат выполнения
     */
    private int commentChangeRequest(Comment comment, String requestUri, HttpMethod httpMethod, Object[] uriVariables) {
        // Предпологаем возможность ошибки создания, изменятеся на 1 при подтверждении создания сервером
        int result = -1;
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.addAll(basicAuthHandler.getHeaders());

            HttpEntity<Object> request = new HttpEntity<>(comment, headers);
            ResponseEntity<Comment> responseResult
                    = restTemplate.exchange(requestUri, httpMethod, request, Comment.class, uriVariables);
            if ( responseResult.getStatusCode() == HttpStatus.OK )
                result = 1;

        } catch ( ResourceAccessException | HttpClientErrorException | HttpServerErrorException ex ) {
            Log.debug( ex.getMessage() );
        }
        return result;

    }


}
