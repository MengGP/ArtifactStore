# Тестовое задание Java: Artifact store

Общие сведения:
-----------------
    Тестовое задание Java: Artifact store
    Автор: Oleg Ustsov
    Дата выполнения: 2020-09-13
        
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
    5. расширенное задание: для операций UPDATE хранить предыдущие версии объектов    
    
    Требования к разработке
    1. Фреймворк: Spring Boot + JPA + REST
    2. Проект создаётся и хранится в git (github, gitlab, etc)

Описание реализации:
--------------------------------------
Проект можно разделить на две части: <br>
    - RESTful сервис хранения и доступа к данным. <br>
    - Интерфейс (web) реализованный в виде MVC, взаимодействие с REST-сервисом в помощью Spring RestTemplate.

API REST-сервиса: <br>
root: localhost:8080

<table>
    <tr>
        <td><b>GET</b></td>    
    </tr>
    <tr>   
        <td>/artifact
            <br> @RequestParam(value = "cat", required = false) String					
            <br> @RequestParam(value = "user", required = false) String				
        	<br> @RequestParam(value = "desc", required = false) String				
        	<br> @RequestParam(value = "comment", required = false) String			
        	<br> @RequestParam(value = "sortType", required = false) Integer			
        	<br> @RequestParam(value = "sortDirection", required = false) Boolean
        </td>
        <td>получение списка артефактов, согласно переданным параметрам</td>
    </tr>
    <tr>
        <td>/artifact/{id}
            <br>@PathVariable("id") long</td>
        <td>получение одного артефакта по id</td>
    </tr>
    <tr>
        <td>/artifact/history
            <br>@RequestParam(value = "artId") long</td>
        <td>получение истории изменения артефакта</td>
    </tr>
    <tr>
        <td>/artifact/categories</td>
        <td>получение списка категорий</td>
    </tr>
    <tr>
        <td>/artifact/users</td>
        <td>получение списка авторов артефактов</td>
    </tr>
    <tr>
        <td>/artifact/comment_num
            	<br>@RequestParam(value="artId") long</td>
        <td>получение количества комментариев к артефакту</td>
    </tr>
    <tr>
        <td>/comments
            	<br>@RequestParam(value = "artId") long</td>
        <td>получение списка комментариев к артефакту</td>
    </tr>
    <tr>
        <td>/comments/{id}
            	<br>@PathVariable("id") long</td>
        <td>получние одного артефакта по id</td>
    </tr>
    <tr>
        <td><b>POST</b></td>
    </tr>
    <tr>
        <td>/artifact 
            	<br>@RequestBody Artifact</td>
        <td>создание артефакта</td>
    </tr>
    <tr>
        <td>/comments 
            	<br>@RequestBody Comment</td>
        <td>создание комментария</td>
    </tr>
    <tr>
        <td><b>DELETE</b></td>
    </tr>
    <tr>
        <td>/artifact/{id}
            	<br>@PathVariable("id") long</td>
        <td>удаление артефакта</td>
    </tr>
    <tr>
        <td>/comments/{id}
            	<br>@PathVariable("id") long</td>
        <td>удаление комментария</td>
    </tr>
    <tr>
        <td><b>PUT</b></td>
    </tr>
    <tr>
        <td>/artifact
            	<br>@RequestBody Artifact</td>
        <td>изменение артефакта</td>
    </tr>
    <tr>
        <td>/comments
            	<br>@RequestBody Comment</td>
        <td>изменение комментария</td>
    </tr>
</table>


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