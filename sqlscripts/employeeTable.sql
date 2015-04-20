CREATE TABLE EmployeeNew
(
Id int NOT NULL,
LastName varchar(20) NOT NULL,
FirstName varchar(20),
DOB date,
Address varchar(50),
PhoneNo varchar(20),
Position varchar(20),
hasRank number(1),
Salary number(6),
isHourly number(1),
Username varchar(50),
Password varchar(50),
PRIMARY KEY (Id)
)