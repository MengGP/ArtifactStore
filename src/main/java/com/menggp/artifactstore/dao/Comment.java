package com.menggp.artifactstore.dao;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

import static javax.persistence.GenerationType.AUTO;

@Entity
@Table(name = "commentaries")
public class Comment {

    @Id
    @GeneratedValue(strategy = AUTO)
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

    // -- Getters and setters
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
    // end_getters_end_setters

} // end_class
