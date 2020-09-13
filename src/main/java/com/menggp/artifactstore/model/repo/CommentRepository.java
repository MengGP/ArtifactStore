package com.menggp.artifactstore.model.repo;

import com.menggp.artifactstore.model.Comment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Репозиторий сущности - комментарий
 */
@Repository
public interface CommentRepository extends CrudRepository<Comment, Long> {

    /**
     * Поиск комментариев к артефакту - по id артефакта
     * @param artifactId - id артефакта
     * @return - список комментариев
     */
    List<Comment> findByArtifactId(long artifactId);

} // end_interface
