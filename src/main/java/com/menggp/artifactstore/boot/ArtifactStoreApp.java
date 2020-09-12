package com.menggp.artifactstore.boot;

import com.menggp.artifactstore.model.Artifact;
import com.menggp.artifactstore.model.Comment;
import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;

/**
 *   Гланый класс проекта
 *       - настройка и запуск Spring Boot сервлета
 *       - создание первоначальное наполнение БД средствами Flyway
 */
@SpringBootApplication
@ComponentScan( "com.menggp.artifactstore.*" )
@EnableJpaRepositories("com.menggp.artifactstore.model")
@EntityScan(basePackageClasses = {Artifact.class, Comment.class})
@PropertySource("classpath:/application.properties")
public class ArtifactStoreApp implements CommandLineRunner {

    public static final String APP_URL = "http://localhost:8080";
    // public static final String APP_URL = "http://localhost:8077";

    // получем строку подключения к БД из файла properties для Flyway
    @Value("${spring.datasource.url}")
    String dbUrl;

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    // Запуск Spring Boot Application
    public static void main(String[] args){
        SpringApplication.run(ArtifactStoreApp.class, args);

        /* Запуск с нестандартным портом - 8077
        HashMap<String,Object> props = new HashMap<>();
        props.put("server.port",8077);

        new SpringApplicationBuilder(ArtifactStoreApp.class)
                .properties(props)
                .run(args);
         */
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


