SHOW DATABASES;

CREATE DATABASE ASSINGMENT_3;

USE ASSINGMENT_3;

CREATE TABLE EMPLOYEES (EMPLOYEE_ID INT,NAME VARCHAR(50),DEPARTMENT_ID INT,SALARY INT, HIRE_DATE DATE);

INSERT INTO EMPLOYEES(EMPLOYEE_ID,NAME,DEPARTMENT_ID,SALARY,HIRE_DATE)
VALUES(1,"ALICE SMITH",101,70000,"2022-01-15"),
(2,"BOB JHONSON",102,80000,"2021-06-23"),
(3,"CHARLIE BROWN",101,60000,"2020-09-30"),
(4,"DANA WHITE",103,75000,"2022-03-12"),
(5,"EVE DAVIS",102,85000,"2019-12-07"),
(6,"FRANK HARRIS",104,65000,"2021-07-14");

DROP TABLE EMPLOYEES;
SELECT * FROM EMPLOYEES;


CREATE TABLE DEPARTMENTS (DEPARTMENT_ID INT,DEPARTMENT_NAME VARCHAR(50),MANAGER_ID INT);

INSERT INTO DEPARTMENTS(DEPARTMENT_ID,DEPARTMENT_NAME,MANAGER_ID)
VALUES(101,"HR",1),
(102,"IT",2),
(103,"FINANCE",4),
(104,"MARKETING",6);

DROP TABLE DEPARTMENTS;
SELECT * FROM DEPARTMENTS;



CREATE TABLE PROJECTS (PROJECT_ID INT,PROJECT_NAME VARCHAR(50),START_DATE DATE, END_DATE DATE);

INSERT INTO PROJECTS(PROJECT_ID,PROJECT_NAME,START_DATE,END_DATE)
VALUES(201,"PROJECT A","2023-01-01","2023-06-30"),
(202,"PROJECT B","2023-02-15","2023-08-13"),
(203,"PROJECT C","2023-03-01","2023-12-31"),
(204,"PROJECT D","2023-04-20","2023-10-10");

DROP TABLE PROJECTS;
SELECT * FROM PROJECTS;



CREATE TABLE EMPLOYEE_PROJECTS (EMPLOYEE_ID INT,PROJECT_ID INT,HOURS_WORKED INT);

INSERT INTO EMPLOYEE_PROJECTS(EMPLOYEE_ID,PROJECT_ID,HOURS_WORKED)
VALUES(1,201,120),
(1,202,150),
(2,202,80),
(2,203,100),
(3,201,95),
(4,204,110),
(5,203,130),
(6,204,140);

DROP TABLE EMPLOYEE_PROJECTS;
SELECT * FROM EMPLOYEE_PROJECTS;

Q-1. Total Salary of All Employees
SELECT SUM(SALARY) AS "Total Salary" FROM Employees;

Q-2. Average Salary per Department
SELECT d.department_name, AVG(e.salary) AS average_salary
FROM employees e
JOIN departments d ON e.department_id = d.department_id
GROUP BY d.department_name;

Q-3. Maximum and Minimum Salary in the Company
SELECT MAX(Salary) AS MaxSalary, MIN(Salary) AS MinSalary FROM Employees;

Q-4. Number of Employees per Department
SELECT NAME, COUNT(employee_id) AS number_of_employees
FROM employees
GROUP BY NAME;

Q-5. Total Hours Worked per Project
SELECT p.project_name, SUM(ep.hours_worked) AS total_hours
FROM EMPLOYEE_PROJECTS ep
JOIN employees e ON ep.employee_id = e.employee_id
JOIN projects p ON ep.project_id = p.project_id
GROUP BY p.project_name;

Q-6. Total Salary of Employees in Each Department

SELECT department_id, SUM(salary) AS total_salary
FROM employees
GROUP BY department_id;

Q-7. Average Salary of Employees per Department

SELECT d.department_id, AVG(e.salary) AS average_salary
FROM departments d
JOIN employees e ON e.department_id = d.department_id
GROUP BY d.department_id;

Q-8. Maximum Salary in Each Department

SELECT department_id, MAX(salary) AS max_salary
FROM employees
GROUP BY department_id;

Q-9. Minimum Salary in Each Department
SELECT d.department_id, MIN(e.salary) AS min_salary
FROM employees e
JOIN departments d ON e.department_id = d.department_id
GROUP BY d.department_id;

Q-10. Total Hours Worked on Each Project

SELECT p.project_id, SUM(ep.hours_worked) AS total_hours
FROM employee_projects ep
JOIN projects p ON ep.project_id = p.project_id
GROUP BY p.project_id;

Q-11. Average Hours Worked per Project

SELECT p.project_id, AVG(ep.hours_worked) AS average_hours
FROM employee_projects ep
JOIN projects p ON ep.project_id = p.project_id
GROUP BY p.project_id;

Q-12. Employee and Department Details

SELECT e.employee_id, e.NAME, d.department_name
FROM employees e
JOIN departments d ON e.department_id = d.department_id;

Q-13. Total Hours Worked by Employees in Each Project

SELECT ep.project_id, SUM(ep.hours_worked) AS total_hours
FROM employee_projects ep
GROUP BY ep.project_id;

Q-14. Projects and Their Total Hours Worked by Employees

SELECT p.project_name, SUM(ep.hours_worked) AS total_hours
FROM employee_projects ep
JOIN projects p ON ep.project_id = p.project_id
GROUP BY p.project_name;

Q-15. Employees Who Worked on Projects in Each Department

SELECT e.NAME, d.department_name, p.project_name
FROM employees e
JOIN departments d ON e.department_id = d.department_id
JOIN employee_projects ep ON e.employee_id = ep.employee_id
JOIN projects p ON ep.project_id = p.project_id;

Q-16. Departments with Their Managers and Total Employees

SELECT d.department_name, CONCAT(e.NAME) AS manager_name, COUNT(e2.employee_id) AS total_employees
FROM departments d
JOIN employees e ON d.manager_id = e.employee_id
LEFT JOIN employees e2 ON d.department_id = e2.department_id
GROUP BY d.department_name, manager_name;