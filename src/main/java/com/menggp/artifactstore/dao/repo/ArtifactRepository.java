package com.menggp.artifactstore.dao.repo;

import com.menggp.artifactstore.dao.Artifact;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArtifactRepository extends CrudRepository<Artifact, Long> {

    // Поиск по категории
    // List<Artifact> findByCategory(String category);
    // @Query("FROM artifacts WHERE category = ?cat")
    List<Artifact> findByCategoryLike(String cat);




} // end_interface
