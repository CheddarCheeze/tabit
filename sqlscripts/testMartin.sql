CREATE TABLE EmployeeTracker
(
Id int NOT NULL,
ClockIn time,
ClockOut time,
Hours 
PRIMARY KEY (Id),
FOREIGN KEY (Id) REFERENCES Employee(Id)
)