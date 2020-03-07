package com.menggp.artifactstore.dao.repo;

import com.menggp.artifactstore.dao.Artifact;
import com.menggp.artifactstore.dao.Comment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Long> {

    // Поиск комментариев по артефакту (artefactId)
    List<Comment> findByArtifactId(long artifactId);

} // end_interface
