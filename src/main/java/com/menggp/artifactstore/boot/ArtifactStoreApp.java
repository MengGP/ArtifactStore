package com.menggp.artifactstore.boot;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
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
 @PropertySource("classpath:/application.properties")
public class ArtifactStoreApp implements CommandLineRunner {

    // получем строку подключения к БД из файла properties для Flyway
    @Value("${spring.datasource.url}")
    String dbUrl;

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


