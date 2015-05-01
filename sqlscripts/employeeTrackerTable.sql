CREATE TABLE EmployeeTracker
(
Id int NOT NULL,
Empl_id int,
ClockIn timestamp,
ClockOut timestamp,
PRIMARY KEY (Id),
FOREIGN KEY (Empl_id) REFERENCES Employee(Id)
)
;