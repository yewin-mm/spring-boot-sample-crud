<!-- PROJECT SHIELDS -->
<!--
*** I'm using markdown "reference style" links for readability.
*** Reference links are enclosed in brackets [ ] instead of parentheses ( ).
*** See the bottom of this document for the declaration of the reference variables
*** for contributors-url, forks-url, etc. This is an optional, concise syntax you may use.
*** https://www.markdownguide.org/basic-syntax/#reference-style-links
-->
[![Contributors][contributors-shield]][contributors-url]
[![Forks][forks-shield]][forks-url]
[![Stargazers][stars-shield]][stars-url]
[![Issues][issues-shield]][issues-url]
[![LinkedIn][linkedin-shield]][linkedin-url]

<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
[contributors-shield]: https://img.shields.io/github/contributors/yewin-mm/spring-boot-sample-crud.svg?style=for-the-badge
[contributors-url]: https://github.com/yewin-mm/spring-boot-sample-crud/graphs/contributors
[forks-shield]: https://img.shields.io/github/forks/yewin-mm/spring-boot-sample-crud.svg?style=for-the-badge
[forks-url]: https://github.com/yewin-mm/spring-boot-sample-crud/network/members
[stars-shield]: https://img.shields.io/github/stars/yewin-mm/spring-boot-sample-crud.svg?style=for-the-badge
[stars-url]: https://github.com/yewin-mm/spring-boot-sample-crud/stargazers
[issues-shield]: https://img.shields.io/github/issues/yewin-mm/spring-boot-sample-crud.svg?style=for-the-badge
[issues-url]: https://github.com/yewin-mm/spring-boot-sample-crud/issues
[linkedin-shield]: https://img.shields.io/badge/-LinkedIn-black.svg?style=for-the-badge&logo=linkedin&colorB=555
[linkedin-url]: https://www.linkedin.com/in/ye-win-1a33a292/
[product-screenshot]: images/screenshot.png

# # spring-boot-sample-crud
* This is the sample backend microservice project for join table by using spring data jpa.

<!-- TABLE OF CONTENTS -->
## Table of Contents
- [About The Project](#about-the-project)
    - [Built With](#built-with)
- [Getting Started](#getting-started)
    - [Before you begin](#before-you-begin)
    - [Clone Project](#clone-project)
    - [Prerequisites](#prerequisites)
    - [Instruction](#instruction)
- [Contact Me](#contact)
- [Contributing](#Contributing)


## About The Project
This is the sample backend microservice project for CURD (create, update, retrieve, delete) operation with Spring boot table by using spring data jpa.
You can learn how to insert, update, select, delete to database by using spring data jpa.


### Built With
This project is built with
* [Java](https://www.oracle.com/au/java/technologies/javase/javase-jdk8-downloads.html)
* [Maven](https://maven.apache.org/download.cgi)
* [Postgresql Database](https://www.postgresql.org/download/)


## Getting Started
This project is built with java, maven, postgresql and use project lombok as plugin.
So, please make sure all are installed in you machine.

### Before you begin
Before learn and see this project. <br>
You should already know Java basic features like class, object, methods, condition, etc. And you should already know how to create sample api with Spring boot. 


### Clone Project
* Clone the repo
   ```sh
   git clone https://github.com/yewin-mm/spring-boot-sample-crud.git
  
### Prerequisites
* Install Git in you machine. [Get Git](https://git-scm.com/downloads)
* Install Java and Maven in your machine. [Get Java](https://www.oracle.com/au/java/technologies/javase/javase-jdk8-downloads.html) | [Get Maven](https://maven.apache.org/download.cgi)
* Install your favourite java IDE in your machine eg. IntelliJ or Eclipse.
* Install Postgresql database in your machine [Get Postgresql](https://www.postgresql.org/download/)
* Install project lombok in your IDE. (if you don't know how to install lombok in your IDE, please reference in google)
* Install Postman for testing api. [Get Postman](https://www.postman.com/)


### Instruction
* Go to your folder which you want to clone this project and type below clone command in your command prompt (window) or in your terminal (MacOs and Linux).
    ```sh
   git clone https://github.com/yewin-mm/spring-boot-sample-crud.git
* If you don't want to clone this project, you can download as zip file by clicking above (top right corner) `Code` button of this repository and choose `Download Zip` and unzip in your machine. 
* Open (IntelliJ) / Import as Maven Project (Eclipse) to this cloned or downloaded project in you IDE.
* Change your Postgresql username and password in spring datasource username and password fields in `application.properties` file. 
    * Postgresql default username is postgres and default password is no set. 
    * So, if you don't do any updating password in your database, you can set just blank in password field.
    * If you got error with database when you run the application, please see in google as reference. 
    * Because sometime, you might got no privilege or permission denied error in Postgresql. If so, you need to create new user or new database with name 'postgres' and grant access on that. (please see in google as reference for that)
* If you don't use Postgresql database, please change your database driver in `pom.xml` file and change your database url, username, password and dialect in `application.properties` file. 
    * If you don't know your database driver, url and dialect, please reference in google. <br> eg. Your installed database is Mysql, 
        * for driver which to add in `pom.xml`, please search in google like "Maven dependency for mysql database" or "Spring JPA Mysql example" 
        * for url and dialect which to add in `application.properties` file, please search in google like "Spring jpa url and dialect properties sample for mysql driver"
* Run the project in your IDE.
    * Click run button on IDE or Run by right click on `SpringBootSampleCrudApplication` class which has main method and choose run or run as java application.
    * See the console log and find below text log in your IDE.
        * eg. Started SpringBootSampleCrudApplication log (it's mean application is successfully run) 
        * eg. APPLICATION FAILED TO START log. (it's mean application cannot run and got error). For that case, please find the root error and reference to google for that error. If some error like port is already use, you need to change the port in `application.properties` file or stop (terminate) other process or application which is using the same port (8080). 

* You can check in your database for there has 'Student' table will auto created or not.
    * Here you can use database gui tools like [Dbeaver](https://dbeaver.io/).
    * If so, firstly, you need to connect to your database with DBeaver. (if you don't know, see how to connect database with Dbeaver in google)
    * After that find 'Student' table under postgres schema which will auto create by running application. If you can't find, just click refresh and see again under postgres schema.
 
* Import `spring-boot-sample-crud-postman-api-request.json` file under project directory (see that file in project directory) into your installed Postman application.
    * Click in your Postman (top left corner) import -> file -> upload files -> {choose that json file} and open/import.
    * After that, you can see the folder which you import from file in your Postman.
* Now, you can 'Test' this project by calling API from Postman.
    * Click 'Send' button for each API request (open the folder which you already imported from above step and there you can see 7 api request) in your Postman and see the response. 
    * You can check data in database too (here you can check data in table (Student) by DBeaver tools or you can manually select query in your database console)


## Contact
Name - Ye Win <br> LinkedIn profile -  [Ye Win's LinkedIn](https://www.linkedin.com/in/ye-win-1a33a292/)  <br> Email Address - yewin.mmr@gmail.com

Project Link: [Spring boot Sample CRUD Application](https://github.com/yewin-mm/spring-boot-sample-crud)


## Contributing
Contributions are what make the open source community such an amazing place to be learn, inspire, and create. Any contributions you make are **greatly appreciated**.
<br>If you want to contribute....
1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/yourname`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push -u origin feature/yourname`)
5. Open a Pull Request

