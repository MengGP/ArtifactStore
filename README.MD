Тестовое задание Java
==================================================================
исполнитель: Усцов Олег

project-name: ArtifactStore

Сборка и запуск:
--------------------------------------
* Автоматический запуск: запустить файл "StartAppScript.bat: в корне проекта  
* Запуск из IDE: запустить выполение класса "com.menggp.artifactstore.boot.ArtifactStoreApp"
* Ручная сборка и запуск (из каталога проета):
    * gradlew.bat :claen
    * gradlew.bat :build
    * java -jar ./build/libs/ArtifactStore.jar
* В результате запуска проекта запускается сервлет, доступный по адресу:
    * http://localhost:8080/
    * login/pass: user/user

Используемые в проекте средства:
--------------------------------------
* Java SDK 1.8
* IntelleJ IDEA Community Edition 2019.3
* Система сборки и управления  зависимостями: Gradle 5.2.1
* Фреймворк: Spring Boot 2.2.4
* Безопасность: Spring Security 2.2.4, Basic auth в REST-запросах
* Веб-фреймворк: Thymeleaf
* Веб-сервер: Apache Tomcat (средствами Spring Boot Web)
* СУБД, встраиваемая: H2database 1.4.200 (in-memory)
* Миграция БД: Flywaydb 6.2.4
* Работа с БД: Spring Data JPA 2.2.4

База данных:
--------------------------------------
* БД работает в режиме in-memory, создается автоматически при запуске проекта.
* SQL-script базы данных (схема/данные): .\ArtifactStore\src\main\resources\db\migration\V1_1__ArtifactDB.sql