package com.menggp.artifactstore.boot;

import com.menggp.artifactstore.dao.Artifact;
import com.menggp.artifactstore.dao.repo.ArtifactRepository;
import com.menggp.artifactstore.services.ArtifactCrudSearchHandler;
import com.menggp.artifactstore.dao.Comment;
import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

/*
    Гланый класс проекта
        - настройка и запуск Spring Boot сервлета
        - создание первоначальное наполнение БД средствами Flyway
 */
@SpringBootApplication
@ComponentScan( {
        "com.menggp.artifactstore.boot",
        "com.menggp.artifactstore.config",
        "com.menggp.artifactstore.controllers",
        "com.menggp.artifactstore.controllersREST",
        "com.menggp.artifactstore.services",
        "com.menggp.artifactstore.dao"
} )
@EnableJpaRepositories("com.menggp.artifactstore.dao")
@EntityScan(basePackageClasses = {Artifact.class, Comment.class})
@PropertySource("classpath:/application.properties")
public class ArtifactStoreApp implements CommandLineRunner {

    // получем строку подключения к БД из файла properties для Flyway
    @Value("${spring.datasource.url}")
    String dbUrl;

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

//    @Bean
//    public ArtifactCrudSearchHandler artifactCrudHandler() {
//        return  new ArtifactCrudSearchHandler();
//    }

//    @Bean
//    public RestFindRequestHandler restRequestHandler() {
//        return new RestFindRequestHandler();
//    }

    // Запуск Spring Boot Application
    public static void main(String[] args){
        // SpringApplication.run(ArtifactStoreApp.class, args);

        HashMap<String,Object> props = new HashMap<>();
        props.put("server.port",8077);

        new SpringApplicationBuilder(ArtifactStoreApp.class)
                .properties(props)
                .run(args);
    } // end_main

    // Задачи при старте
    @Override
    public void run(String... args) throws Exception {
        migrateDB();
    } // end_run

    // запуск миграции БД из sql-скрипта средсвами Flyway
    private void migrateDB() {
        Flyway flyway = Flyway.configure().dataSource(
                dbUrl,
                "sa",
                "")
                .load();
        flyway.migrate();
    } // end_method

} // end_class


