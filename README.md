# CaseStudy
Citrix GoToWebinar application

Read Me file for Citirix - GoToWebinar application test automation case study
------------------------------------------------------------------------------

Design Information:
------------------
1) Used TestNG framework
2) Used Maven for all jars, plug-ins and repository dependencies(POM.xml)
3) testng.xml is driving the scripts
4) created a bat file with maven commands to kick off the scripts
5) Browser used: chrome

Included:
--------
1) All the source code files
2) pom.xml
3) testng.xml
4) ChromeDriver.exe
5) Data.xls (test data info - FYI. password is not encryted, please let me know if this is needed)
6) run.bat

Script Execution Steps:
-----
Double click on \\run.bat file (when mvn compiles the code, it downloads all the dependencies to \\.m2\repository)
OR perform the below steps:
1) Navigate to the project location in the cmd prompt. Ex: C:\\***\***\webinar
2) Type mvn clean enter, hit enter(make sure the build is sucessful)
3) Type mvn compile, hit enter  (make sure the build is sucessful)
4) Type mvn test, hit enter (Script execution starts at this point
