package com.menggp.artifactstore.restService.services;

import com.menggp.artifactstore.model.Artifact;

import java.util.ArrayList;
import java.util.List;

/**
 * Интерфес описывающий CRUD операции с сущьностью Artifact
 *      - поле сортривки: int sortType
 *         1 - Категория(cat)
 *         2 - Автор(user)
 *         3 - Время создания(created)
 *      - направлениe: boolean sortDirection
 *             ASC по возрастанию = true
 *             DESK по убыванию = false
 */
public interface ArtifactCrudHandler {

    /**
     * Создание нового артифакта
     * @param newArt - новый артифакт
     * @return - возвращает новый артифакт
     */
    Artifact createArtifact(Artifact newArt);

    /**
     * Обновление данные артифакта
     * @param updatedArt - обновляемый артифакт
     * @return - возвращает обнолвенный артифакт
     */
    Artifact updateArtifact(Artifact updatedArt);

    // Метод удаляет артифакт

    /**
     * Удаление артефакта
     *      - связанные с артефактом комментарии, также удаляются
     * @param id - id удаляемого артефакта
     */
    void deleteArtifact(long id);

    /**
     * Получение артефакта по id
     * @param id - id артефакта
     * @return - возвращает запрошенный артификт
     */
    Artifact findArtById( long id );

    // Все записи из таблицы ARTIFACTES

    /**
     * Получение всех артифактов
     * @return - возвращает все артефакты в виде списка
     */
    List<Artifact> readAll();

    // ARTIFACTES - фильтр по категрии

    /**
     * Получение артифактов с фильтром по категории
     * @param category - строка фильтра по категории
     * @return - артефакты в виде списка
     */
    List<Artifact> findByCategory(String category);

    // ARTIFACTES - фильтр по пользователю

    /**
     * Получение артефактов с фильтром по автору
     * @param user - строка фильтрации по автору
     * @return - артефакты в виде списка
     */
    List<Artifact> findByUser(String user);

    // ARTIFACTES - фильтр по пользователю

    /**
     * Получение артефактов с фильтром по описанию
     * @param desc - строка фильтра по описанию
     * @return - артефакты в виде списка
     */
    List<Artifact> findByDescription(String desc);

    // ARTIFACTES - Фильтр по содержанию комментариев

    /**
     * Полчение артефактов с фильтром по содержнию комментариев
     * @param comment - строка фильтра по содержнию комментариев
     * @return - артефакты в виде списка
     */
    List<Artifact> findByCommentContent(String comment);

    // Сортировка аритифактов без фильтров

    /**
     * Получение артифактов с cортировкой без фильтров
     * @param sortType      - тип сортровки (см. описание класса)
     * @param sortDirection - направление сортировки (см. описание класса)
     * @return              - отсортированный список артефактов
     */
    List<Artifact> sortAllArtifacts(int sortType, boolean sortDirection);

    // Сортировка аритифактов отфильтрованных по категории(category)

    /**
     * Получение артефактов с сортировкой и фильтром по категории
     * @param cat           - строка фильтрации по категории
     * @param sortType      - тип сортировки (см. описание класса)
     * @param sortDirection - направление сортировки (см. описание класса)
     * @return              - отсортрованный списко артефактов с фильтромпо категории
     */
    List<Artifact> sortArtFilteredByCategory(String cat, int sortType, boolean sortDirection);

    // Сортировка аритифактов отфильтрованных по автору(user_id)

    /**
     * Получение артефактов с сортировкой и фильтром по автору
     * @param userId        - строка фильтра по автору
     * @param sortType      - тип сортировки (см. описание класса)
     * @param sortDirection - направление сортировки (см. описание класса)
     * @return              - отсортрованный списко артефактов с фильтромпо категории
     */
    List<Artifact> sortArtFilteredByUserId(String userId, int sortType, boolean sortDirection);

    // Сортировка аритифактов отфильтрованных по описанию(description)

    /**
     * Получение артефактов с сортировкой и фильтром по описанию
     * @param desc          - строка фильтра по описанию
     * @param sortType      - тип сортировки (см. описание класса)
     * @param sortDirection - направление сортировки (см. описание класса)
     * @return              - отсортрованный списко артефактов с фильтромпо категории
     */
    List<Artifact> sortArtFilteredByDescription(String desc, int sortType, boolean sortDirection);

    // Сортировка аритифактов отфильтрованных по соджержанию комментариев (comment - content)

    /**
     * Получение артефактов с сортировкой и фильтром по содержанию комментариев
     * @param comment       - строка фильтра по содержанию комментариев
     * @param sortType      - тип сортировки (см. описание класса)
     * @param sortDirection - направление сортировки (см. описание класса)
     * @return              - отсортрованный списко артефактов с фильтромпо категории
     */
    List<Artifact> sortArtFilteredByCommentContent(String comment, int sortType, boolean sortDirection);

    /**
     * Получение списка катгорий артефектов
     * @return - категории в виде списка
     */
    List<String> readAllCategories();

    // Список пользователей - ARTIFACT

    /**
     * Получение списка авторов артефактов
     * @return - список авторов
     */
    List<String> readAllUsers();

    // Количество комментариев к артифакту

    /**
     * Полчение количества комментариев к артефакту (по id артефакта)
     * @param artId - id артефакта
     * @return - количество комментариев
     */
    long readCommentsNumberByArtId( long artId );

}
