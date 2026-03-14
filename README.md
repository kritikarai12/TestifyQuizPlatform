# TestifyQuizPlatform

TestifyQuizPlatform is a Java Web Project developed using Servlets, JSP/HTML, MySQL, and Apache Tomcat.
This project allows students to register, login, take quiz, and view scores, while admin can add questions and view results.

## Features

* Student Registration & Login
* Admin Login
* Admin can add quiz questions
* Quiz with multiple choice questions
* Automatic score calculation
* Result stored in MySQL database
* View all results page
* JDBC MySQL connection
* Servlet based backend

## Technologies Used

* Java (Servlet)
* HTML / CSS
* MySQL
* JDBC
* Apache Tomcat 9
* Eclipse IDE

## Project Structure

src/main/java → Servlets & DB Connection
src/main/webapp → HTML pages
WEB-INF/lib → MySQL Connector
Database → testify_quiz

## How to Run

1. Import project in Eclipse
2. Add MySQL connector jar in WEB-INF/lib
3. Create database `testify_quiz`
4. Update DB password in DBConnection.java
5. Run on Tomcat Server
6. Open in browser:

http://localhost:8080/TestifyQuizPlatform/

## Author

Kritika Rai
B.Tech CSE (Data Science)
