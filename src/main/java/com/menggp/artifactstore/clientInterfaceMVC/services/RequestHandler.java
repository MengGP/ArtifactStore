package com.menggp.artifactstore.clientInterfaceMVC.services;

import com.menggp.artifactstore.model.Artifact;
import com.menggp.artifactstore.model.Comment;
import com.menggp.artifactstore.model.dto.ArtifactList;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResourceAccessException;

import java.util.Date;
import java.util.List;

/**
 * Интерфес описывающий заропсы от клиента к REST-сервису
 *          - поле сортривки: int sortType
 *             1 - Категория(cat)
 *             2 - Автор(user)
 *             3 - Время создания(created)
 *          - направлениe: boolean sortDirection
 *             ASK по возрастанию = true
 *             DESK по убыванию = false
 */
public interface RequestHandler {

    // POST - запрос на создание в БД нового артифакта

    /**
     * Запрос на создание нового артефакта
     * @param user  - автор
     * @param cat   - категория
     * @param desc  - описание
     * @return  - результат выполнения
     */
    int createArtifact(String user, String cat, String desc);

    // POST - запрос на создание в БД нового комментария

    /**
     * Запрос на создание нового комментария
     * @param userId - автор
     * @param content - содержание
     * @param artId - id артефакта
     * @return  - результат выполнения
     */
    int createComment(String userId, String content, long artId);

    /**
     * Запрос на удаление артефакта
     * @param id - id артефакта
     * @return - результат выполнения
     */
    int delArtifact(long id);

    /**
     * Запрос на удаление комментария
     * @param id  - id комментария
     * @return - результат выполнения
     */
    int delComment(long id);

    /**
     * Запрос на обновление артефакта
     * @param id    - id артефакта
     * @param user  - автор
     * @param cat   - категория
     * @param desc  - описание
     * @param created - дата создания
     * @return - резкльтат выполнения
     */
    int updateArtifact(long id, String user, String cat, String desc, Date created);

    /**
     * Запрос на обновление комментария
     * @param id        - id комментария
     * @param userId    - автор комментария
     * @param content   - содержание
     * @param artId     - id артефакта
     * @return          - результат выполнения
     */
    int updateComment(long id, String userId, String content, long artId);

    /**
     * Запрос артефакта по id
     * @param id - id артефакта
     * @return - артефакт
     */
    Artifact getArtById(long id);

    /**
     * Запрос комментария по id
     * @param id - id комментария
     * @return - комментарий
     */
    Comment getCommentById(long id);

    /**
     * Запрос списка категорий артефактов
     * @return - список категорий в виде списка строк
     */
    List<String> getAllCategories();

    /**
     * Запрос списка авторов артефактов
     * @return - список авторов в виде списка строк
     */
    List<String> getAllUsers();

    /**
     * Запрос количества комментариев к артифакту
     * @param artId - id артифакта
     * @return - количество комментариев
     */
    long getCommentsNumber( long artId );

    /**
     * Запрос списка артефактов - всех
     * @return - список артефактов
     */
    List<Artifact> getAllArtifacs();

    /**
     * Запрос списка артефактов - с фильтром по категории
     * @param cat - строка фильтра по категории
     * @return - список артефактов
     */
    List<Artifact> getArtifacatsFilterByCategory(String cat);

    /**
     * Запрос списка артефактов - с фильтром по автору
     * @param user - строка фильтра по автору
     * @return - список артефактов
     */
    List<Artifact> getArtifacatsFilterByUser(String user);

    /**
     * Запрос списка артефактов - с фильтром по описанию
     * @param desc - строка фильтра по описанию
     * @return - список артефактов
     */
    List<Artifact> getArtifacatsFilterByDescription(String desc);

    /**
     * Запрос списка артефактов - с фильтром по содержаению комментариев
     * @param comment - строка фильтра по содержанию коментариев
     * @return - список артефактов
     */
    List<Artifact> getArtifacatsFilterByCommentContent(String comment);

    /**
     * Запрос списка артефактов - с пердвартельной сортировкой
     * @param sortType      - тип сортировки (см. описние интерфейса)
     * @param sortDirection - направления сортировки (см. описание интерфейса)
     * @return - список артефактов
     */
    List<Artifact> sortAllArtifact(int sortType, boolean sortDirection);

    /**
     * Запрос списка артефактов - с пердвартельной сортировкой и фильтром по категории
     * @param cat - строка фильтра по категории
     * @param sortType      - тип сортировки (см. описние интерфейса)
     * @param sortDirection - направления сортировки (см. описание интерфейса)
     * @return - список артефактов
     */
    List<Artifact> sortArtifactFilteredByCategory(String cat, int sortType, boolean sortDirection);

    /**
     * Запрос списка артефактов - с пердвартельной сортировкой и фильтром по автору
     * @param user - строка фильтра по автору
     * @param sortType      - тип сортировки (см. описние интерфейса)
     * @param sortDirection - направления сортировки (см. описание интерфейса)
     * @return - список артефактов
     */
    List<Artifact> sortArtifactFilteredByUserId(String user, int sortType, boolean sortDirection);

    /**
     * Запрос списка артефактов - с пердвартельной сортировкой и фильтром по описанию
     * @param desc - строка фильтра по описанию
     * @param sortType      - тип сортировки (см. описние интерфейса)
     * @param sortDirection - направления сортировки (см. описание интерфейса)
     * @return - список артефактов
     */
    List<Artifact> sortArtifactFilteredByDescription(String desc, int sortType, boolean sortDirection);

    /**
     * Запрос списка артефактов - с пердвартельной сортировкой и фильтром по содержанию комментариев
     * @param comment - строка фильтра по содержанию комментариев
     * @param sortType      - тип сортировки (см. описние интерфейса)
     * @param sortDirection - направления сортировки (см. описание интерфейса)
     * @return - список артефактов
     */
    List<Artifact> sortArtifactFilteredByComment(String comment, int sortType, boolean sortDirection);

    // Метод возвращвет комментарии к Артефаку (по artifactId)

    /**
     * Запрос комментариев к артефакту (по id артефакта)
     * @param artId - id артефакта
     * @return - список коментариев
     */
    List<Comment> getCommentariesByArtifactId(long artId);







    }
