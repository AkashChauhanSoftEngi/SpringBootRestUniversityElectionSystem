# SpringBootRestUniversityElectionSystem

> **###1. Requirements**
* One Student can choose listed members only or in another words, if they exist in Person table. Other wise Exception must be thrown.
* One person can only choose one post for the Election {it can easily be resolved by making Person.name as primary key}.
* Student can not choose, same member from Person table for mulitple posts. Other wise Exception must be thrown.

> **###2. Steps to achieve these requirements**
* Make Student.name and Person.name primary key of respective tables. So no two entries can have same names. Other wise throw an Exception.
* Check if Student enters different members for multiple positions before storing into the database. Other wise throw an Exception.
* Before storing any student into Student table, there should be a conditional check if the name selected for posts exist in Person table   or not. Other wise throw an Exception.

> **###3. Technologies**
* Spring Boot 2.0.3.RELEASE (Latest)
* Rest Architecture
* JPA {ORM}
* H2-Database
* Maven 3.1
* JSTL 1.2

> **###4. To Run this project locally**
* $ git clone https://github.com/AkashChauhanSoftEngi/SpringBootRestUniversityElectionSystem
* $ tomcat {Embedded}

> **###5.  Access** 
* http://localhost:8080/student with POST
* http://localhost:8080/person with POST
* http://localhost:8080/findElectedPresident with GET
* http://localhost:8080/findElectedVicePresedent with GET
* http://localhost:8080/findElectedSecretary with GET
