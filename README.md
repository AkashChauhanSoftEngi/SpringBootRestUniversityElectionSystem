# SpringBootRestUniversityElectionSystem

### Requirements
  - One Student can choose listed members only or in another words, if they exist in Person table. Other wise Exception must be thrown.
  - One person can choose one post for the Election, Other wise Exception must be thrown.
  - Student can not choose, same member from Person table for mulitple posts

### Logics/steps to achieve these requirements
  - Make Student.name and Person.name primary key of respective tables. So no two entries can have same names.
  - Check if Student enters duifferent members for multiple positions before storing into the database.
  - Before storing any student into Student table, there should be a conditional check if the name selected for posts exist in Person table   or not.
