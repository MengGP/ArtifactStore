package com.menggp.artifactstore.restService.services;

import com.menggp.artifactstore.model.Artifact;
import com.menggp.artifactstore.model.Comment;
import com.menggp.artifactstore.model.repo.ArtifactRepository;
import com.menggp.artifactstore.model.repo.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Реализация интерфейса ArtifactCrudHandler
 */
@Service
public class ArtifactCrudHandlerImpl implements ArtifactCrudHandler {

    @Autowired
    ArtifactRepository artifactRepository;

    @Autowired
    CommentRepository commentRepository;

    private List<Artifact> allArtifact;

    @Override
    public Artifact createArtifact(Artifact newArt){
        newArt.setCreated( new Date() );
        return artifactRepository.save( newArt );
    } // end_method

    @Override
    public Artifact updateArtifact(Artifact updatedArt){

        Artifact art = artifactRepository.findById( updatedArt.getId() ).get();
        art.setCreated( updatedArt.getCreated()) ;
        art.setDescription( updatedArt.getDescription() );
        art.setCategory( updatedArt.getCategory() );
        art.setUserId( updatedArt.getUserId() );

        return artifactRepository.save( art );
    } // end_metod

    @Override
    public void deleteArtifact(long id) {

        ArrayList<Comment> commentsList = (ArrayList<Comment>) commentRepository.findByArtifactId( id );
        for (Comment iter : commentsList)
            commentRepository.delete( iter );

        artifactRepository.deleteById( id );
        return;
    } // end_method

    @Override
    public Artifact findArtById( long id ) {
        return artifactRepository.findById( id ).get();
    }

    @Override
    public List<Artifact> readAll() {
        allArtifact = (List<Artifact>) artifactRepository.findAll();
        return allArtifact;
    } // end_method

    @Override
    public  List<Artifact> findByCategory(String category) {
        String clause;
        clause = "%" + category + "%";
        clause = clause.toUpperCase();
        allArtifact = (List<Artifact>) artifactRepository.findByCategoryLikeIgnoreCase(clause);
        return allArtifact;
    } // end_method

    @Override
    public  List<Artifact> findByUser(String user) {
        String clause;
        clause = "%" + user + "%";
        clause = clause.toUpperCase();
        allArtifact = (List<Artifact>) artifactRepository.findByUserIdLikeIgnoreCase(clause);
        return allArtifact;
    } // end_method

    @Override
    public  List<Artifact> findByDescription(String desc) {
        String clause;
        clause = "%" + desc + "%";
        clause = clause.toUpperCase();
        allArtifact = (List<Artifact>) artifactRepository.findByDescriptionLikeIgnoreCase(clause);
        return allArtifact;
    } // end_method

    @Override
    public List<Artifact> findByCommentContent(String comment) {
        String clause;
        clause = "%" + comment + "%";
        clause = clause.toUpperCase();
        allArtifact = (List<Artifact>) artifactRepository.findByCommentContent(clause);
        return allArtifact;
    }

    @Override
    public List<Artifact> sortAllArtifacts(int sortType, boolean sortDirection) {
        switch (sortType) {
            case 1: // сортрировка по категории(category)
                if ( sortDirection ) {
                    Sort.Order order = new Sort.Order(Sort.Direction.ASC, "category").ignoreCase();
                    allArtifact = (List<Artifact>) artifactRepository.findAll( Sort.by(order) );
                }
                else {
                    Sort.Order order = new Sort.Order(Sort.Direction.DESC, "category").ignoreCase();
                    allArtifact = (List<Artifact>) artifactRepository.findAll( Sort.by(order) );
                }
                break;
            case 2: // сортрировка по автору(UserId)
                if ( sortDirection ) {
                    Sort.Order order = new Sort.Order(Sort.Direction.ASC, "userId").ignoreCase();
                    allArtifact = (List<Artifact>) artifactRepository.findAll( Sort.by(order) );
                }
                else {
                    Sort.Order order = new Sort.Order(Sort.Direction.DESC, "userId").ignoreCase();
                    allArtifact = (List<Artifact>) artifactRepository.findAll( Sort.by(order) );
                }
                break;
            case 3: // сортировка по времени создания(created)
                if ( sortDirection ) {
                    Sort.Order order = new Sort.Order(Sort.Direction.ASC, "created").ignoreCase();
                    allArtifact = (List<Artifact>) artifactRepository.findAll( Sort.by(order) );
                }
                else {
                    Sort.Order order = new Sort.Order(Sort.Direction.DESC, "created").ignoreCase();
                    allArtifact = (List<Artifact>) artifactRepository.findAll( Sort.by(order) );
                }
                break;
        }
        return allArtifact;
    } // end_method

    @Override
    public List<Artifact> sortArtFilteredByCategory(String cat, int sortType, boolean sortDirection) {
        String clause;
        clause = "%" + cat + "%";
        clause = clause.toUpperCase();

        switch (sortType) {
            case 1: // сортрировка по категории(category)
                if ( sortDirection ) {
                    Sort.Order order = new Sort.Order(Sort.Direction.ASC, "category").ignoreCase();
                    allArtifact = (List<Artifact>) artifactRepository.findByCategoryLikeIgnoreCase( clause, Sort.by(order) );
                }
                else {
                    Sort.Order order = new Sort.Order(Sort.Direction.DESC, "category").ignoreCase();
                    allArtifact = (List<Artifact>) artifactRepository.findByCategoryLikeIgnoreCase( clause, Sort.by(order) );
                }
                break;
            case 2: // сортрировка по автору(UserId)
                if ( sortDirection ) {
                    Sort.Order order = new Sort.Order(Sort.Direction.ASC, "userId").ignoreCase();
                    allArtifact = (List<Artifact>) artifactRepository.findByCategoryLikeIgnoreCase( clause, Sort.by(order) );
                }
                else {
                    Sort.Order order = new Sort.Order(Sort.Direction.DESC, "userId").ignoreCase();
                    allArtifact = (ArrayList<Artifact>) artifactRepository.findByCategoryLikeIgnoreCase( clause, Sort.by(order) );
                }
                break;
            case 3: // сортировка по времени создания(created)
                if ( sortDirection ) {
                    Sort.Order order = new Sort.Order(Sort.Direction.ASC, "created").ignoreCase();
                    allArtifact = (List<Artifact>) artifactRepository.findByCategoryLikeIgnoreCase( clause, Sort.by(order) );
                }
                else {
                    Sort.Order order = new Sort.Order(Sort.Direction.DESC, "created").ignoreCase();
                    allArtifact = (List<Artifact>) artifactRepository.findByCategoryLikeIgnoreCase( clause, Sort.by(order) );
                }
                break;
        }
        return allArtifact;
    } // end_method

    @Override
    public List<Artifact> sortArtFilteredByUserId(String userId, int sortType, boolean sortDirection) {
        String clause;
        clause = "%" + userId + "%";
        clause = clause.toUpperCase();

        switch (sortType) {
            case 1: // сортрировка по категории(category)
                if ( sortDirection ) {
                    Sort.Order order = new Sort.Order(Sort.Direction.ASC, "category").ignoreCase();
                    allArtifact = (List<Artifact>) artifactRepository.findByUserIdLikeIgnoreCase( clause, Sort.by(order) );
                }
                else {
                    Sort.Order order = new Sort.Order(Sort.Direction.DESC, "category").ignoreCase();
                    allArtifact = (List<Artifact>) artifactRepository.findByUserIdLikeIgnoreCase( clause, Sort.by(order) );
                }
                break;
            case 2: // сортрировка по автору(UserId)
                if ( sortDirection ) {
                    Sort.Order order = new Sort.Order(Sort.Direction.ASC, "userId").ignoreCase();
                    allArtifact = (List<Artifact>) artifactRepository.findByUserIdLikeIgnoreCase( clause, Sort.by(order) );
                }
                else {
                    Sort.Order order = new Sort.Order(Sort.Direction.DESC, "userId").ignoreCase();
                    allArtifact = (List<Artifact>) artifactRepository.findByUserIdLikeIgnoreCase( clause, Sort.by(order) );
                }
                break;
            case 3: // сортировка по времени создания(created)
                if ( sortDirection ) {
                    Sort.Order order = new Sort.Order(Sort.Direction.ASC, "created").ignoreCase();
                    allArtifact = (List<Artifact>) artifactRepository.findByUserIdLikeIgnoreCase( clause, Sort.by(order) );
                }
                else {
                    Sort.Order order = new Sort.Order(Sort.Direction.DESC, "created").ignoreCase();
                    allArtifact = (List<Artifact>) artifactRepository.findByUserIdLikeIgnoreCase( clause, Sort.by(order) );
                }
                break;
        }
        return allArtifact;
    } // end_method

    @Override
    public List<Artifact> sortArtFilteredByDescription(String desc, int sortType, boolean sortDirection) {
        String clause;
        clause = "%" + desc + "%";
        clause = clause.toUpperCase();

        switch (sortType) {
            case 1: // сортрировка по категории(category)
                if ( sortDirection ) {
                    Sort.Order order = new Sort.Order(Sort.Direction.ASC, "category").ignoreCase();
                    allArtifact = (List<Artifact>) artifactRepository.findByDescriptionLikeIgnoreCase( clause, Sort.by(order) );
                }
                else {
                    Sort.Order order = new Sort.Order(Sort.Direction.DESC, "category").ignoreCase();
                    allArtifact = (List<Artifact>) artifactRepository.findByDescriptionLikeIgnoreCase( clause, Sort.by(order) );
                }
                break;
            case 2: // сортрировка по автору(UserId)
                if ( sortDirection ) {
                    Sort.Order order = new Sort.Order(Sort.Direction.ASC, "userId").ignoreCase();
                    allArtifact = (List<Artifact>) artifactRepository.findByDescriptionLikeIgnoreCase( clause, Sort.by(order) );
                }
                else {
                    Sort.Order order = new Sort.Order(Sort.Direction.DESC, "userId").ignoreCase();
                    allArtifact = (List<Artifact>) artifactRepository.findByDescriptionLikeIgnoreCase( clause, Sort.by(order) );
                }
                break;
            case 3: // сортировка по времени создания(created)
                if ( sortDirection ) {
                    Sort.Order order = new Sort.Order(Sort.Direction.ASC, "created").ignoreCase();
                    allArtifact = (List<Artifact>) artifactRepository.findByDescriptionLikeIgnoreCase( clause, Sort.by(order) );
                }
                else {
                    Sort.Order order = new Sort.Order(Sort.Direction.DESC, "created").ignoreCase();
                    allArtifact = (List<Artifact>) artifactRepository.findByDescriptionLikeIgnoreCase( clause, Sort.by(order) );
                }
                break;
        }
        return allArtifact;
    } // end_method

    @Override
    public List<Artifact> sortArtFilteredByCommentContent(String comment, int sortType, boolean sortDirection) {
        String clause;
        clause = "%" + comment + "%";
        clause = clause.toUpperCase();

        switch (sortType) {
            case 1: // сортрировка по категории(category)
                if ( sortDirection ) allArtifact = (List<Artifact>) artifactRepository.findByCommentContentOrderByCategory(clause);
                else allArtifact = (List<Artifact>) artifactRepository.findByCommentContentOrderByCategoryDesc(clause);
                break;
            case 2: // сортрировка по автору(UserId)
                if ( sortDirection ) allArtifact = (List<Artifact>) artifactRepository.findByCommentContentOrderByUserId(clause);
                else allArtifact = (List<Artifact>) artifactRepository.findByCommentContentOrderByUserIdDesc(clause);
                break;
            case 3: // сортировка по времени создания(created)
                if ( sortDirection ) allArtifact = (List<Artifact>) artifactRepository.findByCommentContentOrderByCreated(clause);
                else allArtifact = (List<Artifact>) artifactRepository.findByCommentContentOrderByCreatedDesc(clause);
                break;
        }
        return allArtifact;
    } // end_method

    @Override
    public List<String> readAllCategories() {
        return (List<String>) artifactRepository.findCategory();
    } // end_method

    @Override
    public List<String> readAllUsers() {
        return (List<String>) artifactRepository.findUser();
    } // end_method

    @Override
    public long readCommentsNumberByArtId( long artId ) {
        return artifactRepository.findCommentsNumberByArtifactId( artId );
    } // end_method

}
