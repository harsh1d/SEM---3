CREATE DATABASE P2;
USE P1;
CREATE TABLE BORROW(LOANNO VARCHAR(20),CNAME VARCHAR(20),BNAME VARCHAR(20),AMOUNT VARCHAR(20) );
INSERT BORROW VALUES ("311","SUNIL","DHARAMPREET","3000.00");
SELECT * FROM DEPOSIT;

Q-1
DESCRIBE BRANCH;
DESCRIBE BORROW;
DESCRIBE CUSTOMERS;

Q-2
DESCRIBE DEPOSIT;

Q-3
SELECT * FROM DEPOSIT;

Q-4
SELECT * FROM BORROW;

Q-5
SELECT * FROM CUSTOMERS;

Q-6
SELECT * FROM BRANCH;

Q-7
SELECT ACTNO, AMOUNT FROM DEPOSIT;

Q-8
SELECT CNAME FROM DEPOSIT WHERE AMOUNT > "4000";

Q-9 
SELECT CNAME, BNAME FROM DEPOSIT WHERE ADATE > "1995-12-01";