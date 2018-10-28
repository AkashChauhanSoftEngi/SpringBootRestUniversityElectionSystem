# SpringBootRestUniversityElectionSystem

## 1. Requirements
* One Student can choose listed members only or in another words, if they exist in Person table. Other wise Exception must be thrown.
* One person can only choose one post for the Election {it can easily be resolved by making Person.name as primary key}.
* Person should not be able to enter post not existed in post table
* Student can not choose, same member from Person table for mulitple posts. Other wise Exception must be thrown.

## 2. Steps to achieve these requirements
* Make Student.name and Person.name primary key of respective tables. So no two entries can have same names. Other wise throw an Exception.
* Check if Student enters different members for multiple positions before storing into the database. Other wise throw an Exception.
* Before storing any student into Student table, there should be a conditional check if the name selected for posts exist in Person table or not. Other wise throw an Exception.
* Before storing any person into Person table, there should be a conditional check if the chosen post exists in Post table or not. Other wise throw an Exception.
* addPost must be executed before addPerson, and addPerson must be executed before addStudent

## 3. Technologies
* Spring Boot 2.0.3.RELEASE (Latest)
* Rest Architecture
* JPA {ORM}
* H2-Database
* Maven 3.1
* JSTL 1.2

## 4. To Run this project locally
* $ git clone https://github.com/AkashChauhanSoftEngi/SpringBootRestUniversityElectionSystem
* $ tomcat {Embedded}

## 5. Access/End Points
* POST http://localhost:8080/addPost
* POST http://localhost:8080/addPerson
* POST http://localhost:8080/addStudent
* GET http://localhost:8080/findElectedPresident
* GET http://localhost:8080/findElectedVicePresedent
* GET http://localhost:8080/findElectedSecretary

## 6. Overview of thr system {High Level Design, HLD}
```text
* 6 Rest End/Access Points: addPost, addPerson, addStudent, findElectedPresident, findElectedVicePresedent, findElectedSecretary
* POST: {"post":"President"}->addPost->{"post":"President"}
* POST: {"name":"satya", "post":"vice-president"}->addPerson->{"name":"satya", "post":"vice-president"}
* POST: {"name":"Akash", "choiceForPresident":"satya", "choiceForVicePresident":"nitin", "choiceForSecretary":"neeraj"}->addStudent->{"name":"Akash", "choiceForPresident":"satya", "choiceForVicePresident":"nitin", "choiceForSecretary":"neeraj"}
* GET: findElectedPresident->"satya"
* GET: findElectedVicePresedent->"nitin"
* GET: findElectedSecretary->"neeraj"
* addPost API must be executed before addPerson API, and addPerson API must be executed before addStudent API
  - addPost > addPerson > addStudent
  - In addPerson person must enter post already existed in Post table, and in addStudent Student must enter person already existed in Person table
```
  
## 7. Internal Work flow of API or End points {Low Level Design, LLD}
* Example: /addStudnet
```text
                      Student {name, choiceForPresident, choiceForVicePresident, choiceForSecretary}
                                                      ||
                                                      \/
                                       Rest Controller {Post: /addStudent}
                                                      ||
                                                      \/
                             ElectionSystemService {Interface, saveStudent() method}
                                                      ||
                                                      \/
                   ElectionSystemServiceImpl {Implementation, saveStudent() method, Use Dto classes}  
                                                      ||
                                                      \/
                          StudentRepository {save(Student), JpaRepository<Student, String>}             
                                                      ||
                                                      \/
                     DAO {student table, return back after saving the data in the student table}
```

## 8. Database Schema Design
* Related files added above with names: "SchemaDesignPhoto.PNG" and "SchemaDesign.docx" 
