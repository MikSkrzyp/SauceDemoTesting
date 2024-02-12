# SauceDemoTesting

These project is about testing website
[saucedemo.com](https://www.saucedemo.com/)

I have written 5 tests which concern functionality aspects of this website

## Tech Stack

*Programming language:* Java

*Build Automation Tool:* Maven

*Frameworks for tests:* Selenium, TestNG

*Framework for reports:* Allure


## To run tests:

with maven command
            
    mvn clean test

with running xml file :

    src/test/resources/test_suites.xml

## Tests
Tests description and steps can be found in a file:

    ListOfTests

Java implementation of these tests can be found in

    src/test/java/tests





## POP

Project uses POP (Page Object Pattern) and these objects can be found in:
           
    src/tests/java/page/objects





## Allure Report

to generate report
````
mvn allure:install
````
````            
mvn allure:report
````

Generated report can be found in your:
````
target/site/index.html
````
![App Screenshot](allure_report.png)