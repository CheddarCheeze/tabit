CREATE TABLE Schedule
(
ID int NOT NULL,
Name varchar(50) NOT NULL,
Monday varchar(20),
Tuesday varchar(20),
Wednesday varchar(20),
Thursday varchar(20),
Friday varchar(20),
Saturday varchar(20),
Sunday varchar(20),
PRIMARY KEY(id),
FOREIGN KEY(id) REFERENCES Employee(Id)
)