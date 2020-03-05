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

    // Поиск по категории
    List<Artifact> findByCategoryLikeIgnoreCase(String cat);

    // Поиск по категории - с сортировкой по категории ASK
    List<Artifact> findByCategoryLikeIgnoreCaseOrderByCategory(String cat);

    // Поиск по пользователю (автору)
    List<Artifact> findByUserIdLikeIgnoreCase(String user);

    // Поиск по описанию
    List<Artifact> findByDescriptionLikeIgnoreCase(String user);

    @Query(value = "SELECT * FROM artifacts where ID IN " +
            "(" +
            "SELECT artifact_id FROM commentaries where UPPER(content) LIKE ?1" +
            ")", nativeQuery = true)
    List<Artifact> findByCommentContent(String content);

    // Список категорий
    @Query(value = "SELECT category FROM artifacts GROUP BY category", nativeQuery = true)
    List<String> findCategory();

    // Список пользователей
    @Query(value = "SELECT user_id FROM artifacts GROUP BY user_id", nativeQuery = true)
    List<String> findUser();



} // end_interface
