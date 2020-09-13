package com.menggp.artifactstore.model.repo;

import com.menggp.artifactstore.model.ArtifactHist;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Репозиторий сущности артефакт-исторический
 */
@Repository
public interface ArtifactHistRepository extends CrudRepository<ArtifactHist, Long> {

    /**
     * Поиск "исторических версий артефактов" для артефакта по id
     * @param artifactId - id артефакта
     * @return  - список артафактов-исторических
     */
    List<ArtifactHist> findByArtifactId(long artifactId);

}
