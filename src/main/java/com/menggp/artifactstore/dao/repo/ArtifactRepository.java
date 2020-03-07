package com.menggp.artifactstore.dao.repo;

import com.menggp.artifactstore.dao.Artifact;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArtifactRepository extends CrudRepository<Artifact, Long> {

    // --- --- --- Фильтр: нет

    List<Artifact> findAll(Sort sort);

    // --- --- --- Фильтр: Category

    // Поиск по категории
    List<Artifact> findByCategoryLikeIgnoreCase(String cat);

    // Поиск по категории - c сортировкой
    List<Artifact> findByCategoryLikeIgnoreCase(String cat, Sort sort);

    // --- --- --- Фильтр: UserId

    // Поиск по пользователю (автору)
    List<Artifact> findByUserIdLikeIgnoreCase(String user);

    // Поимск по категории - с сортировкий
    List<Artifact> findByUserIdLikeIgnoreCase(String user, Sort sort);

    // --- --- --- Фильтр: Description

    // Поиск по описанию
    List<Artifact> findByDescriptionLikeIgnoreCase(String user);

    // Поиск по описанию - с сортировкой
    List<Artifact> findByDescriptionLikeIgnoreCase(String user, Sort sort);

    // --- --- --- Фильтр: Comment Content > вложенный запрос

    // Поиск по содержанию комментариев
    @Query(value = "SELECT * FROM artifacts where ID IN " +
            "( SELECT artifact_id FROM commentaries where UPPER(content) LIKE ?1 )", nativeQuery = true)
    List<Artifact> findByCommentContent(String content);

    // Поиск по содержанию комментариев - с сортировкой по категории ASC
    @Query(value = "SELECT * FROM artifacts where ID IN " +
            "( SELECT artifact_id FROM commentaries where UPPER(content) LIKE ?1 )" +
            "ORDER BY UPPER(category)", nativeQuery = true)
    List<Artifact> findByCommentContentOrderByCategory(String content);

    // Поиск по содержанию комментариев - с сортировкой по категории DESC
    @Query(value = "SELECT * FROM artifacts where ID IN " +
            "( SELECT artifact_id FROM commentaries where UPPER(content) LIKE ?1 )" +
            "ORDER BY UPPER(category) DESC", nativeQuery = true)
    List<Artifact> findByCommentContentOrderByCategoryDesc(String content);

    // Поиск по содержанию комментариев - с сортировкой по автору(user_id) ASC
    @Query(value = "SELECT * FROM artifacts where ID IN " +
            "( SELECT artifact_id FROM commentaries where UPPER(content) LIKE ?1 )" +
            "ORDER BY UPPER(user_id)", nativeQuery = true)
    List<Artifact> findByCommentContentOrderByUserId(String content);

    // Поиск по содержанию комментариев - с сортировкой по автору(user_id) DESC
    @Query(value = "SELECT * FROM artifacts where ID IN " +
            "( SELECT artifact_id FROM commentaries where UPPER(content) LIKE ?1 )" +
            "ORDER BY UPPER(user_id) DESC", nativeQuery = true)
    List<Artifact> findByCommentContentOrderByUserIdDesc(String content);

    // Поиск по содержанию комментариев - с сортировкой по времени создания(created) ASC
    @Query(value = "SELECT * FROM artifacts where ID IN " +
            "( SELECT artifact_id FROM commentaries where UPPER(content) LIKE ?1 )" +
            "ORDER BY created", nativeQuery = true)
    List<Artifact> findByCommentContentOrderByCreated(String content);

    // Поиск по содержанию комментариев - с сортировкой по времени создания(created) DESC
    @Query(value = "SELECT * FROM artifacts where ID IN " +
            "( SELECT artifact_id FROM commentaries where UPPER(content) LIKE ?1 )" +
            "ORDER BY created DESC", nativeQuery = true)
    List<Artifact> findByCommentContentOrderByCreatedDesc(String content);

    // --- --- CREATE

    // --- --- Прочие

    // Список категорий
    @Query(value = "SELECT category FROM artifacts GROUP BY category", nativeQuery = true)
    List<String> findCategory();

    // Список пользователей
    @Query(value = "SELECT user_id FROM artifacts GROUP BY user_id", nativeQuery = true)
    List<String> findUser();



} // end_interface
