CREATE TABLE EmployeeTracker
(
Id int NOT NULL,
ClockIn timestamp,
ClockOut timestamp,
PRIMARY KEY (Id),
FOREIGN KEY (Id) REFERENCES Employee(Id)
)

CREATE TABLE Orders
(
Id int NOT NULL,
ProductName varchar(50) NOT NULL,
OrderDate datetime NOT NULL DEFAULT CURDATE(),
PRIMARY KEY (Id),
FOREIGN KEY (Id) REFERENCES Employee(Id)
)