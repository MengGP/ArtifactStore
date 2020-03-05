package com.menggp.artifactstore.dao.repo;

import com.menggp.artifactstore.dao.Artifact;
import com.menggp.artifactstore.dao.Comment;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepository extends CrudRepository<Comment, Integer> {
} // end_interface
