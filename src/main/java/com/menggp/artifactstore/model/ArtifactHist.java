package com.menggp.artifactstore.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Сущность артефакт-исторический
 */
@Entity
@Table(name="artifacts_hist")
public class ArtifactHist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @NotNull
    long id;

    @Column(name = "artifact_id")
    @NotNull
    long artifactId;

    @Column(name = "modified")
    @Temporal(TemporalType.TIMESTAMP)
    @NotNull
    Date modified;

    @Column(name = "user_id")
    @NotNull
    String userId;

    @Column(name = "category")
    String category;

    @Column(name = "description")
    @NotNull
    String description;

    public ArtifactHist() {
    }

    public ArtifactHist(@NotNull long artifactId, @NotNull Date modified, @NotNull String userId, String category, @NotNull String description) {
        this.artifactId = artifactId;
        this.modified = modified;
        this.userId = userId;
        this.category = category;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getArtifactId() {
        return artifactId;
    }

    public void setArtifactId(long artifactId) {
        this.artifactId = artifactId;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
