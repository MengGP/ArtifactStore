package com.menggp.artifactstore.dao;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.util.Date;

/*
    Сущность Артефакт
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

    // -- Getters and Setters
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
    // end_getters_and_setters

} // end_class
