CREATE TABLE Employee
(
Id int NOT NULL,
LastName varchar(20) NOT NULL,
FirstName varchar(20),
DOB date,
Position varchar(20),
Salary number(6),
PhoneNo varchar(20),
PictureFile varchar(30),
Address varchar(70),
HasRank number(1), 
IsHourly number(1),
UserName varchar(20),
PassWord varchar(20),
PRIMARY KEY (Id)
)