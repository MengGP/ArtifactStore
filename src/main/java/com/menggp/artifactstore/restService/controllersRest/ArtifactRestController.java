package com.menggp.artifactstore.restService.controllersRest;

import com.menggp.artifactstore.model.Artifact;
import com.menggp.artifactstore.model.dto.ArtifactHistList;
import com.menggp.artifactstore.model.dto.ArtifactList;
import com.menggp.artifactstore.model.dto.StringList;
import com.menggp.artifactstore.restService.services.ArtifactCrudHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 *  Класс обрабатывает REST-запросы,
 *          к данными сущности Artifact
 */
@RestController
@RequestMapping("/artifacts")
public class ArtifactRestController {

    private static final Logger Log = LoggerFactory.getLogger(ArtifactRestController.class);

    @Autowired
    ArtifactCrudHandler artifactCrudHandler;

    /**
     * Получение артефакта по ID
     * @param id - id артефакта
     * @return - артефакт
     */
    @GetMapping("/{id}")
    public Artifact getArtifactById(
            @PathVariable("id") Long id
    ) {
        return artifactCrudHandler.findArtById( id );
    }

    /**
     * Получить список артефактов - фильтрация и сортировка, в зависимости от переданных параметров
     * @param cat       - (опционально) строка фильтра по категории
     * @param user      - (опционально) строка фильтра по по автору
     * @param desc      - (опционально) строка фильтра по описанию
     * @param comment   - (опционально) строка фильтра по содержанию комментариев
     * @param sortType  - тип мортировки: int
     *                      1 - Категория(cat)
     *                      2 - Автор(user)
     *                      3 - Время создания(created)
     * @param sortDirection - напраление сортировки: boolean
     *                      ASC по возрастанию = true
     *                      DESK по убыванию = false
     * @return          - список артефактов
     */
    @GetMapping
    public ArtifactList getArtifacts(
            @RequestParam(value = "cat", required = false) String cat,
            @RequestParam(value = "user", required = false) String user,
            @RequestParam(value = "desc", required = false) String desc,
            @RequestParam(value = "comment", required = false) String comment,
            @RequestParam(value = "sortType", required = false) Integer sortType,
            @RequestParam(value = "sortDirection", required = false) Boolean sortDirection
    ) {
        ArtifactList response = new ArtifactList();

        // Возвращаем список артефактов с заданным фильтром - только один фильтр и сортировкаой (если задана)
        // Проверяется - сначала фильтр, потом наличие сортировки
        if ( cat != null )
            if ( sortType != null && sortDirection != null )
                response.setArtifactList( artifactCrudHandler.sortArtFilteredByCategory(cat, sortType, sortDirection));
            else
                response.setArtifactList( artifactCrudHandler.findByCategory(cat) );
        else if ( user != null )
            if ( sortType != null && sortDirection != null )
                response.setArtifactList( artifactCrudHandler.sortArtFilteredByUserId(user, sortType, sortDirection) );
            else
                response.setArtifactList( artifactCrudHandler.findByUser( user ) );
        else if ( desc != null ) {
            if ( sortType != null && sortDirection != null )
                response.setArtifactList( artifactCrudHandler.sortArtFilteredByDescription(desc, sortType, sortDirection) );
            else
                response.setArtifactList( artifactCrudHandler.findByDescription( desc ) );
        }
        else if ( comment != null ) {
            if ( sortType != null && sortDirection != null )
                response.setArtifactList( artifactCrudHandler.sortArtFilteredByCommentContent(comment, sortType, sortDirection) );
            else
                response.setArtifactList( artifactCrudHandler.findByCommentContent( comment ) );
        }
        else
            if ( sortType != null && sortDirection != null )
                response.setArtifactList( artifactCrudHandler.sortAllArtifacts(sortType, sortDirection) );
            else
                response.setArtifactList( artifactCrudHandler.readAll() );

        return response;
    }

    /**
     * Получить список "исторических версий артефакта" по id артефакта
     * @param artId - id артефакта
     * @return - список исторических комментариев
     */
    @GetMapping("/history")
    public ArtifactHistList getArtifactsHistByArtifact(
            @RequestParam(value = "artId") long artId
    ) {
        return new ArtifactHistList( artifactCrudHandler.findArtifactsHistByArtifactId( artId ) );
    }

    /**
     * Получить список категорий артефактов
     * @return - список категорий
     */
    @GetMapping("/categories")
    public StringList getAllCategories() {
        return new StringList( artifactCrudHandler.readAllCategories() );
    }

    /**
     * Получить список авторов артефактов
     * @return - список авторов
     */
    @GetMapping("/users")
    public StringList getAllusers() {
        return new StringList( artifactCrudHandler.readAllUsers() );
    }

    /**
     * Получить количество комментариев у артифакта (по id артефакта)
     * @param id - id артефакта
     * @return   - количество комментариев
     */
    @GetMapping("/comment_num")
    public Long commentsNumByArtifact(
            @RequestParam(value="artId") long id
    ) {
        return artifactCrudHandler.readCommentsNumberByArtId( id );
    }

    /**
     * Создать артифакт
     * @param newArt - новый артефакт
     * @return - созданный артефакт
     */
    @PostMapping
    public Artifact createArtifact(
            @RequestBody Artifact newArt
    ) {
        return artifactCrudHandler.createArtifact(newArt);
    }

    /**
     * Удаление артифакта по id
     * @param id - id артефакта
     */
    @DeleteMapping("/{id}")
    public void delArtifact(
            @PathVariable("id") long id
    ) {
        artifactCrudHandler.deleteArtifact(id);
    }

    /**
     * Обновление артефакта
     * @param updatedArt - ортефакт с новыми параметрами
     * @return - обновленный артефакт
     */
    @PutMapping
    public Artifact updateArtifact(
            @RequestBody Artifact updatedArt
    ) {
        return artifactCrudHandler.updateArtifact(updatedArt);
    }


}
