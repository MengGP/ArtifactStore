# Тестовое задание Java: Artifact store

Общие сведения:
-----------------
    Тестовое задание Java: Artifact store
    Автор: Oleg Ustsov
    Дата выполнения: 2020-03-07
    
Задание:
--------------------------------------
    Разработать REST-сервис для хранения артефактов.
    Модель данных представлена двумя типами: Артефакт и Комментарий.
    Артефакт имеет следующие поля:
    • ID: UUID - primary key
    • Created: DateTime - время создания
    • UserID: String - ID пользователя
    • Category: String - категория
    • Description: String - описание
    Комментарий имеет следующие поля:
    • ID: UUID - primary key
    • ArtefactID: UUID - foreign key to artefact
    • UserID: String - ID пользователя
    • Content: String - комментарий
    
    Требования к REST сервису:
    1. сервис предоставляет полный доступ (CRUD) к типам Артефакт и Комментарий
    2. сервис предоставляет поиск артефактов по полям:
        * категория
        * описание
        * содержимое комментариев
    3. сортировка найденных артефактов по полям:
        * время создания
        * категория
        * пользователь
    4. Сервис защищен basic auth    
    
    Требования к разработке
    1. Фреймворк: Spring Boot + JPA + REST
    2. Проект создаётся и хранится в git (github, gitlab, etc)

Сборка и запуск:
--------------------------------------
* Автоматический запуск: запустить файл "StartAppScript.bat" в корне проекта  
* Запуск из IDE: запустить на выполнение класс "com.menggp.artifactstore.boot.ArtifactStoreApp"
* Ручная сборка и запуск (из каталога проекта):
    * gradlew.bat :clean
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