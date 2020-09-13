package com.menggp.artifactstore.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Сущность - комментарий
 */
@Entity
@Table(name = "commentaries")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @NotNull
    long id;

    @Column(name = "artifact_id")
    @NotNull
    long artifactId;

    @Column(name = "user_id")
    @NotNull
    String userId;

    @Column(name = "content")
    @NotNull
    String content;

    public Comment() {
    }

    public Comment(@NotNull String userId, @NotNull String content, @NotNull long artifactId) {
        this.userId = userId;
        this.content = content;
        this.artifactId = artifactId;
    }

    public Comment(@NotNull long id, @NotNull String userId, @NotNull String content, @NotNull long artifactId) {
        this.id = id;

        this.userId = userId;
        this.content = content;
        this.artifactId = artifactId;
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
