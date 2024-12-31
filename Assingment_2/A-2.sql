SHOW DATABASES;

CREATE DATABASE ASSINGMENT_2;

USE ASSINGMENT_2;

CREATE TABLE SALESMAN(SALESMAN_ID INT, NAME VARCHAR(20), CITY VARCHAR(20), COMMISSION DECIMAL(4,2));
INSERT INTO SALESMAN VALUES(5001,"JAMES HOOG","NEW YORK",0.15),
(5002,"NALI KNITE","PARIS",0.13),
(5005,"PIT ALEX","LONDON",0.11),
(5006,"MC LYON","PARIS",0.14),
(5003,"JAMES HOOG",NULL,0.12),
(5007,"JAMES HOOG","ROME",0.13);
SELECT * FROM SALESMAN;
DROP TABLE ORDERS;


CREATE TABLE CUSTOMER(CUSTOMER_ID INT, CUST_NAME VARCHAR(20), CITY VARCHAR(20), GRADE INT, SALESMAN_ID INT);
INSERT INTO CUSTOMER VALUES(3002,"NICK RIMANDO","NEW YORK",100,5001),
(3005,"GRAHAM ZUSI","CALIFORNAI",200,5002),
(3004,"FABIAN JOHNSON","PARIS",300,5006),
(3007,"BRAD DAVIS","NEW YORK",200,5001),
(3009,"GEOFF CAMERON","BERLIN",100,5003),
(3008,"JULIAN GREEN","LONDON",300,5002),
(3001,"BRAD GUZAN","LONDON",NULL,5005),
(3003,"JOZY ALTIDORE","MOSCOW",200,5007);
SELECT * FROM CUSTOMER;



CREATE TABLE ORDERS(ORD_NO INT, PURCH_AMT DECIMAL(6,2),ORD_DATE DATE, CUSTOMER_ID INT, SALESMAN_ID INT);
INSERT INTO ORDERS VALUES(70001,150.50,"2012-10-05",3005,5002),
(70009,270.65,"2012-09-10",3001,5005),
(70002,65.26,"2012-10-05",3002,5001),
(70004,110.50,"2012-08-17",3009,5003),
(70007,948.50,"2012-09-10",3005,5002),
(70005,2400.60,"2012-07-27",3007,5001),
(70008,5760.00,"2012-09-10",3002,5001),
(70010,1983.43,"2012-10-10",3004,5006),
(70003,2480.40,"2012-10-10",3009,5003),
(70012,250.45,"2012-06-27",3008,5002),
(70011,75.29,"2012-08-17",3003,5007),
(70013,3045.60,"2012-04-25",3002,5001);
SELECT * FROM ORDERS;

Q-1 From the above tables write a SQL query to find the salesperson and customer who reside in the same city. Return Salesman, cust_name and city.
SELECT S.NAME AS SALESMAN, C.cust_name AS CUSTOMER, S.city AS City FROM SALESMAN S INNER JOIN Customer C ON S.city = C.city;

Q-2 write a SQL query to find those orders where the order amount exists between 500 and 2000. Return ord_no, purch_amt, cust_name, city.
SELECT 
    O.ORD_NO, 
    O.PURCH_AMT, 
    C.CUST_NAME, 
    C.CITY FROM ORDERS O INNER JOIN CUSTOMER C ON O.CUSTOMER_ID = C.CUSTOMER_ID WHERE O.PURCH_AMT BETWEEN 500 AND 2000;

Q-3 write a SQL query to find the salesperson(s) and the customer(s) he represents. Return Customer Name, city, Salesman, commission.
SELECT 
    C.CUST_NAME AS "Customer Name", 
    C.CITY AS "City", 
    S.NAME AS "Salesman", 
    S.COMMISSION AS "Commission"
FROM CUSTOMER C INNER JOIN SALESMAN S ON C.SALESMAN_ID = S.SALESMAN_ID;

Q-4 write a SQL query to find salespeople who received more than 12 percent commissions from the company. Return Customer Name, customer city, Salesman, commission.
SELECT 
    C.CUST_NAME AS "Customer Name", 
    C.CITY AS "Customer City", 
    S.NAME AS "Salesman", 
    S.COMMISSION AS "Commission"
FROM CUSTOMER C
INNER JOIN SALESMAN S 
ON C.salesman_id = S.salesman_id
WHERE S.commission > 0.12;

Q-5 write a SQL query to locate those salespeople who do not live in the same city where their customers live and have received a commission of more than 12% from the company. Return Customer Name, customer city, Salesman, salesman city, commission. 
SELECT 
    C.CUST_NAME AS "Customer Name", 
    C.CITY AS "Customer City", 
    S.NAME AS "Salesman", 
    S.CITY AS "Salesman City", 
    S.COMMISSION AS "Commission"
FROM CUSTOMER C
INNER JOIN SALESMAN S 
ON C.salesman_id = S.salesman_id
WHERE S.commission > 0.12 
AND C.city <> S.city;


Q-6 write a SQL query to find the details of an order. Return ord_no, ord_date, purch_amt, Customer Name, grade, Salesman, commission. 

SELECT 
    O.ORD_NO AS "Order Number", 
    O.ORD_DATE AS "Order Date", 
    O.PURCH_AMT AS "Purchase Amount", 
    C.CUST_NAME AS "Customer Name", 
    C.GRADE AS "Grade", 
    S.NAME AS "Salesman", 
    S.COMMISSION AS "Commission"
FROM ORDERS O
INNER JOIN CUSTOMER C 
ON O.CUSTOMER_ID = C.CUSTOMER_ID
INNER JOIN SALESMAN S 
ON C.SALESMAN_ID = S.SALESMAN_ID;

Q-7 Write a SQL statement to join the tables salesman, customer and orders so that the same column of each table appears once and only the relational rows are returned.

	SELECT 
		S.SALESMAN_ID, 
		S.NAME, 
		S.CITY AS "Salesman City", 
		S.COMMISSION, 
		C.CUSTOMER_ID, 
		C.CUST_NAME, 
		C.CITY AS "Customer City", 
		C.GRADE, 
		O.ORD_NO, 
		O.ORD_DATE, 
		O.PURCH_AMT
	FROM ORDERS O
	INNER JOIN CUSTOMER C 
	ON O.CUSTOMER_ID = C.CUSTOMER_ID
	INNER JOIN SALESMAN S 
	ON C.SALESMAN_ID = S.SALESMAN_ID;


Q-8 write a SQL query to display the customer name, customer city, grade, salesman, salesman city. The results should be sorted by ascending customer_id. 

SELECT 
    C.CUST_NAME AS "Customer Name", 
    C.CITY AS "Customer City", 
    C.GRADE AS "Grade", 
    S.NAME AS "Salesman", 
    S.CITY AS "Salesman City"
FROM CUSTOMER C
INNER JOIN SALESMAN S 
ON C.SALESMAN_ID = S.SALESMAN_ID
ORDER BY C.CUSTOMER_ID ASC;

Q-9 write a SQL query to find those customers with a grade less than 300. Return cust_name, customer city, grade, Salesman, salesmancity. The result should be ordered by ascending customer_id. 

SELECT 
    C.CUST_NAME AS "Customer Name", 
    C.CITY AS "Customer City", 
    C.GRADE AS "Grade", 
    S.NAME AS "Salesman", 
    S.CITY AS "Salesman City"
FROM CUSTOMER C
INNER JOIN SALESMAN S 
ON C.SALESMAN_ID = S.SALESMAN_ID
WHERE C.GRADE < 300
ORDER BY C.CUSTOMER_ID ASC;

Q-10 Write a SQL statement to make a report with customer name, city, order number, order date, and order amount in ascending order according to the order date to determine whether any existing customers have placed an order.

SELECT 
    C.CUST_NAME AS "Customer Name", 
    C.CITY AS "Customer City", 
    O.ORD_NO AS "Order Number", 
    O.ORD_DATE AS "Order Date", 
    O.PURCH_AMT AS "Order Amount"
FROM CUSTOMER C
INNER JOIN ORDERS O 
ON C.CUSTOMER_ID = O.CUSTOMER_ID
ORDER BY O.ORD_DATE ASC;
