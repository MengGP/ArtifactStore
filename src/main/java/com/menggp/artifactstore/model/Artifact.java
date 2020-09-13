package com.menggp.artifactstore.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.util.Date;

/**
 *  Сущность - артефакт
 */
@Entity
@Table(name="artifacts")
public class Artifact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @NotNull
    long id;

    @Column(name = "created")
    @Temporal(TemporalType.TIMESTAMP)
    @NotNull
    Date created;

    @Column(name = "user_id")
    @NotNull
    String userId;

    @Column(name = "category")
    String category;

    @Column(name = "description")
    @NotNull
    String description;

    public Artifact() {
    }

    public Artifact(@NotNull String userId, String category, @NotNull String description) {
        this.userId = userId;
        this.category = category;
        this.description = description;
    }

    public Artifact(@NotNull long id, @NotNull String userId, String category, @NotNull String description, @NotNull Date created) {
        this.id = id;
        this.userId = userId;
        this.category = category;
        this.description = description;
        this.created = created;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
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
