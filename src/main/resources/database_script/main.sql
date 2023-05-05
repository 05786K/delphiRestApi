CREATE DATABASE dummyDb; 


Use dummyDb; 


CREATE table users(
	uniqueID VARCHAR(50) NOT NULL,  
	fullName VARCHAR(100) NOT NULL,  
	phone INT NOT NULL,
	password VARCHAR(100) NOT NULL,  
	beef INT NOT NULL,  
	chicken INT NOT NULL,  
	spicy INT NOT NULL,  
	Primary Key (uniqueID), 

);
