package com.menggp.artifactstore.dao.repo;

import com.menggp.artifactstore.dao.Artifact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArtifactRepository extends CrudRepository<Artifact, Long> {

    // --- --- --- Фильтр: нет

    // Без фильтра - сортировка по категории ASC
    List<Artifact> findAllByOrderByCategoryAsc();

    // Без фильтра - сортировка по категории DESC
    List<Artifact> findAllByOrderByCategoryDesc();

    // Без фильтра - сортировка по автору(user_id) ASC
    List<Artifact> findAllByOrderByUserIdAsc();

    // Без фильтра - сортировка по автору(user_id) DESC
    List<Artifact> findAllByOrderByUserIdDesc();

    // Без фильтра - сортировка по времени создания(cerated) ASC
    List<Artifact> findAllByOrderByCreatedAsc();

    // Без фильтра - сортировка по времени создания(cerated) ASC
    List<Artifact> findAllByOrderByCreatedDesc();

    // --- --- --- Фильтр: Category

    // Поиск по категории
    List<Artifact> findByCategoryLikeIgnoreCase(String cat);

    // Поиск по категории - с сортировкой по категории ASC
    List<Artifact> findByCategoryLikeIgnoreCaseOrderByCategory(String cat);

    // Поиск по категории - с сортировкой по категории DESC
    List<Artifact> findByCategoryLikeIgnoreCaseOrderByCategoryDesc(String cat);

    // Поиск по категории - с сортировкой по автору(user_id) ASC
    List<Artifact> findByCategoryLikeIgnoreCaseOrderByUserId(String cat);

    // Поиск по категории - с сортировкой по автору(user_id) DESC
    List<Artifact> findByCategoryLikeIgnoreCaseOrderByUserIdDesc(String cat);

    // Поиск по категории - с сортировкой по времени создания(created) ASC
    List<Artifact> findByCategoryLikeIgnoreCaseOrderByCreated(String cat);

    // Поиск по категории - с сортировкой по времени создания(created) DESC
    List<Artifact> findByCategoryLikeIgnoreCaseOrderByCreatedDesc(String cat);

    // --- --- --- Фильтр: UserId

    // Поиск по пользователю (автору)
    List<Artifact> findByUserIdLikeIgnoreCase(String user);

    // Поиск по пользователю (автору) - с сортировкой по категории ASC
    List<Artifact> findByUserIdLikeIgnoreCaseOrderByCategory(String user);

    // Поиск по пользователю (автору) - с сортировкой по категории DESC
    List<Artifact> findByUserIdLikeIgnoreCaseOrderByCategoryDesc(String user);

    // Поиск по пользователю (автору) - с сортировкой по автору(user_id) ASC
    List<Artifact> findByUserIdLikeIgnoreCaseOrderByUserId(String user);

    // Поиск по пользователю (автору) - с сортировкой по автору(user_id) DESC
    List<Artifact> findByUserIdLikeIgnoreCaseOrderByUserIdDesc(String user);

    // Поиск по пользователю (автору) - с сортировкой по времени создания(created) ASC
    List<Artifact> findByUserIdLikeIgnoreCaseOrderByCreated(String user);

    // Поиск по пользователю (автору) - с сортировкой по времени создания(created) DESC
    List<Artifact> findByUserIdLikeIgnoreCaseOrderByCreatedDesc(String user);

    // --- --- --- Фильтр: Description

    // Поиск по описанию
    List<Artifact> findByDescriptionLikeIgnoreCase(String user);

    // Поиск по описанию - с сортировкой по категории ASC
    List<Artifact> findByDescriptionLikeIgnoreCaseOrderByCategory(String user);

    // Поиск по описанию - с сортировкой по категории DESC
    List<Artifact> findByDescriptionLikeIgnoreCaseOrderByCategoryDesc(String user);

    // Поиск по описанию - с сортировкой по автору(user_id) ASC
    List<Artifact> findByDescriptionLikeIgnoreCaseOrderByUserId(String user);

    // Поиск по описанию - с сортировкой по автору(user_id) DESC
    List<Artifact> findByDescriptionLikeIgnoreCaseOrderByUserIdDesc(String user);

    // Поиск по описанию - с сортировкой по времени создания(created) ASC
    List<Artifact> findByDescriptionLikeIgnoreCaseOrderByCreated(String user);

    // Поиск по описанию - с сортировкой по времени создания(created) DESC
    List<Artifact> findByDescriptionLikeIgnoreCaseOrderByCreatedDesc(String user);

    // --- --- --- Фильтр: Comment Content > вложенный запрос

    // Поиск по содержанию комментариев
    @Query(value = "SELECT * FROM artifacts where ID IN " +
            "( SELECT artifact_id FROM commentaries where UPPER(content) LIKE ?1 )", nativeQuery = true)
    List<Artifact> findByCommentContent(String content);

    // Поиск по содержанию комментариев - с сортировкой по категории ASC
    @Query(value = "SELECT * FROM artifacts where ID IN " +
            "( SELECT artifact_id FROM commentaries where UPPER(content) LIKE ?1 )" +
            "ORDER BY category", nativeQuery = true)
    List<Artifact> findByCommentContentOrderByCategory(String content);

    // Поиск по содержанию комментариев - с сортировкой по категории DESC
    @Query(value = "SELECT * FROM artifacts where ID IN " +
            "( SELECT artifact_id FROM commentaries where UPPER(content) LIKE ?1 )" +
            "ORDER BY category DESC", nativeQuery = true)
    List<Artifact> findByCommentContentOrderByCategoryDesc(String content);

    // Поиск по содержанию комментариев - с сортировкой по автору(user_id) ASC
    @Query(value = "SELECT * FROM artifacts where ID IN " +
            "( SELECT artifact_id FROM commentaries where UPPER(content) LIKE ?1 )" +
            "ORDER BY user_id", nativeQuery = true)
    List<Artifact> findByCommentContentOrderByUserId(String content);

    // Поиск по содержанию комментариев - с сортировкой по автору(user_id) DESC
    @Query(value = "SELECT * FROM artifacts where ID IN " +
            "( SELECT artifact_id FROM commentaries where UPPER(content) LIKE ?1 )" +
            "ORDER BY user_id DESC", nativeQuery = true)
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
