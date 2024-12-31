show databases;

USE ASSINGMENT_1;

CREATE TABLE EMPLOYEE(EMP_ID INT,EMP_NAME VARCHAR(50),DEPARTMENT VARCHAR(50),CONTACT_NO INT,EMAIL_ID VARCHAR(30),EMPHEAD_ID INT );
INSERT INTO EMPLOYEE(EMP_ID,EMP_NAME,DEPARTMENT,CONTACT_NO,EMAIL_ID,EMPHEAD_ID)
VALUES(101,"Isha","E-101",1234567890,"isha@gmail.com",105),
(102,"Priya","E-104",1234567890,"priya@yahoo.com",103),
(103,"Neha","E-101",1234567890,"neha@gmail.com",101),
(104,"Rahul","E-102",1234567890,"rahul@yahoo.com",105),
(105,"Abhishek","E-101",1234567890,"abhishrk@gmail.com",102);
SELECT * FROM EMPLOYEE;


CREATE TABLE EMPDEPT(DEPT_ID varchar(50),DEPT_NAME varchar(100), DEPT_OFF varchar(100), DEPT_HEAD INT);
INSERT INTO EMPDEPT(DEPT_ID,DEPT_NAME,DEPT_OFF,DEPT_HEAD)
VALUES("E-101","HR","Monday",105),
("E-102","Development","Tuesday",101),
("E-103","House Keeping","Saturday",103),
("E-104","Sales","Sunday",104),
("E-105","Purchase","Tuesday",104);

SELECT * FROM EMPDEPT;


CREATE TABLE EMPSALARY(EMP_ID VARCHAR(20), SALARY INT, IS_PERMANENT varchar(3));
INSERT INTO EMPSALARY(EMP_ID,SALARY,IS_PERMANENT)
VALUES("E-101",2000,"Yes"),
("E-102",10000,"Yes"),
("E-103",5000,"No"),
("E-104",1900,"Yes"),
("E-105",2300,"Yes");
SELECT * FROM EMPSALARY;

DROP TABLE EMPSALARY;


CREATE TABLE Project(PROJECT_ID VARCHAR(20), DURATION INT);
INSERT INTO Project(PROJECT_ID,DURATION)
VALUES("P-1",23),
("P-2",15),
("P-3",35),
("P-4",2),
("P-5",30);
SELECT * FROM Project;


CREATE TABLE Country(C_ID VARCHAR(20), C_NAME VARCHAR(20));
INSERT INTO Country(C_ID,C_NAME)
VALUES("C-1","INDIA"),
("C-2","USA"),
("C-3","CHINA"),
("C-4","PAKISTAN"),
("C-5","RUSSIA");
SELECT * FROM Country;

DROP TABLE Country;


CREATE TABLE Client_Table(CLIENT_ID VARCHAR(20), CLIENT_NAME VARCHAR(20),C_ID VARCHAR(20));
INSERT INTO Client_Table(CLIENT_ID,CLIENT_NAME,C_ID)
VALUES("CL-1","ABC Group","C-1"),
("CL-2","PQR","C-1"),
("CL-3","XYZ","C-2"),
("CL-4","TECH ALTUM","C-3"),
("CL-5","MNP","C-5");
SELECT * FROM Client_Table;



CREATE TABLE Emp_Project(EMP_ID VARCHAR(50),PROJECT_ID VARCHAR(50),CLIENT_ID VARCHAR(50),START_YEAR INT,END_YEAR INT );
INSERT INTO Emp_Project(EMP_ID,PROJECT_ID,CLIENT_ID,START_YEAR,END_YEAR)
VALUES(101,"P-1","CL-1",2010,2010),
(102,"P-2","CL-2",2010,2012),
(103,"P-1","CL-3",2013,NULL),
(104,"P-4","CL-4",2014,2015),
(105,"P-4","CL-5",2015,NULL);
SELECT * FROM Emp_Project;

DROP TABLE Emp_Project;


Q-1.Select the detail of the employee whose name start with P.
SELECT * FROM employee WHERE EMP_NAME LIKE 'P%';

Q-2 How many permanent candidate take salary more than 5000.
SELECT COUNT(*) FROM EMPSALARY WHERE IS_PERMANENT = 'Yes' AND salary > 5000;

Q-3Select the detail of employee whose emailId is in gmail.
SELECT * FROM EMPLOYEE WHERE EMAIL_ID LIKE '%@gmail.com';

Q-4Select the details of the employee who work either for department E-104 or E-102.
SELECT * FROM EMPLOYEE WHERE DEPARTMENT IN ('E-104', 'E-102');

Q-5What is the department name for DeptID E-102?
SELECT EMP_NAME FROM EMPLOYEE WHERE DEPARTMENT = 'E-102';

Q-6.What is total salarythat is paid to permanent employees?
SELECT SUM(SALARY) FROM EMPSALARY WHERE IS_PERMANENT = 'Yes';


Q-7 List name of all employees whose name ends with a.
SELECT EMP_NAME FROM EMPLOYEE WHERE EMP_NAME LIKE '%a';


Q-8 List the number of department of employees in each project.
SELECT P.PROJECT_ID, COUNT(DISTINCT D.DEPARTMENT) AS number_of_departments FROM PROJECT p
INNER JOIN EMPLOYEE ON P.DEPARTMENT = e.DEPARTMENT
GROUP BY p.PROJECT_ID;
select * from employee;
select * from PROJECT;


SELECT p.project_id, COUNT(DISTINCT d.DEPARTMENT) AS number_of_departments
FROM PROJECT p
JOIN Employee e ON p.project_id = e.project_id
JOIN PROJECT d ON e.DEPARTMENT = d.DEPARTMENT
GROUP BY p.project_id;

Q-9.How many project started in year 2010.
SELECT COUNT(*) FROM Emp_Project WHERE START_YEAR= 2010;
SELECT * FROM Emp_Project;


Q-10.	How many project started and finished in the same year.
SELECT COUNT(*) FROM EMP_PROJECT WHERE START_YEAR = END_YEAR;


Q-11.select the name of the employee whose name's 3rd charactor is 'h'.
SELECT EMP_NAME FROM EMPLOYEE WHERE SUBSTRING(EMP_NAME, 3, 1) = 'h';
