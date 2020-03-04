package com.menggp.artifactstore.boot;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

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
        "com.menggp.artifactstore.services"
} )
// @PropertySource("classpath:/application.properties")
public class ArtifactStoreApp {

    // Запуск Spring Boot Application
    public static void main(String[] args){
        // SpringApplication.run(ArtifactStoreApp.class, args);

        HashMap<String,Object> props = new HashMap<>();
        props.put("server.port",8077);

        new SpringApplicationBuilder(ArtifactStoreApp.class)
                .properties(props)
                .run(args);
    } // end_main

} // end_class


