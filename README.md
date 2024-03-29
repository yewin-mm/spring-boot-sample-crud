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


<h1 align="center">
  Overview
  <img src="https://github.com/yewin-mm/spring-boot-sample-crud/blob/master/github/template/images/overview/spring_boot_simple_crud_overview.png" /><br/>
</h1>

# spring-boot-sample-crud
* This is the sample backend microservice project for Spring Boot + Spring Data JPA + MySQL application.

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
- [Becoming a Sponsor](#becoming-a-sponsor)
- [Contributing](#Contributing)


<a name="about-the-project"></a>
## ⚡️About The Project
This is the sample backend microservice project for CURD (create, update, retrieve, delete) operation with Spring boot with Spring Data JPA.
You can learn how to insert, update, select, delete to MySQL database by using Spring Data JPA.


<a name="built-with"></a>
### 🪓 Built With
This project is built with
* [Java](https://www.oracle.com/java/technologies/javase/javase8-archive-downloads.html)
* [Maven](https://maven.apache.org/download.cgi)
* [MySQL Database](https://dev.mysql.com/downloads/installer/)


<a name="getting-started"></a>
## 🔥 Getting Started
This project is built with java, maven, postgresql and use `Project Lombok` as plugin.
So, please make sure all are installed in your machine.


<a name="before-you-begin"></a>
### 🔔 Before you begin
If you are new in Git, Github and new in Spring Boot configuration structure, <br>
You should see basic detail instructions first in here [Spring Boot Application Instruction](https://github.com/yewin-mm/spring-boot-app-instruction)<br>
Before learn and see this project, <br>
You should already know Java basic features like class, object, methods, condition, etc. And you should already know how to create sample api with Spring boot. 


<a name="clone-project"></a>
### 🥡 Clone Project
* Clone the repo
   ```sh
   git clone https://github.com/yewin-mm/spring-boot-sample-crud.git
  

<a name="prerequisites"></a>
### 🔑 Prerequisites
Prerequisites can be found in here [Spring Boot Application Instruction](https://github.com/yewin-mm/spring-boot-app-instruction).


<a name="instruction"></a>
### 📝 Instruction
* Create database with name as per your `application.properties` config name which follow by db url connection string by typing `create database {name};` by using database GUI tools or inside your database control. 
* Change your database username and password in `application.properties`.
* Run the project in your IDE. Please make sure application was successfully running.
* You can check in your database is that there has 'Student' table was auto created by application or not, under postgres schema by Database GUI tools like DBeaver.
* If you can't find, just click refresh in GUI and see again under postgres schema.
 
* Import `spring-boot-sample-crud-postman-api-request.json` file under project directory (see that file in project directory) into your installed Postman application.
    * Click in your Postman (top left corner) import -> file -> upload files -> {choose that json file} and open/import.
    * After that, you can see the folder which you import from file in your Postman.
* Now, you can 'Test' this project by calling API from Postman.
    * Open your imported folder in postman and inside this folder, you will see total of 7 API requests and you can test it all by clicking `Send` button and see the response. 
    * You can check data in database too (here you can check data in table (Student) by DBeaver tools or you can manually select query in your database console)
    
* After that you can see the code and check the code which you don't know. You can learn it and you can apply in your job or study fields.

***Have Fun and Enjoy in Learning Code***


<a name="contact"></a>
## ✉️ Contact Me
Name - Ye Win <br> LinkedIn profile -  [Ye Win](https://www.linkedin.com/in/ye-win-1a33a292/)  <br> Email Address - <a href="mailto:yewin.mmr@gmail.com?">yewin.mmr@gmail.com</a> <br> WhatsApp - [+959252656065](https://wa.me/959252656065?text=Hi) <br> Website - [My Website](https://yewin.me/)

Project Link: [Spring boot Sample CRUD Application](https://github.com/yewin-mm/spring-boot-sample-crud)


<a name="becoming-a-sponsor"></a>
## 🥰 Becoming a Sponsor
If you like any of my projects or if you want to support my work, please kindly consider becoming a sponsor. <br>
It gives me great motivation and I can relentlessly maintain my projects and contribute to the open-source community.

<a href="https://www.buymeacoffee.com/yewin" target="_blank"><img src="https://cdn.buymeacoffee.com/buttons/v2/default-yellow.png" alt="Buy Me A Coffee" width="150" ></a>


<a name="contributing"></a>
## ⭐ Contributing
Contributions are what make the open source community such an amazing place to be learnt, inspire, and create. Any contributions you make are **greatly appreciated**.
<br>If you want to contribute....
1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/yourname`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeatures'`)
4. Push to the Branch (`git push -u origin feature/yourname`)
5. Open a Pull Request

