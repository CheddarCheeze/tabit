CREATE TABLE Finance
(
Id int NOT NULL,
ProductName varchar(30) NOT NULL,
DateSale date,
Sale_Total decimal(6,2),
Empl_Id int,
PRIMARY KEY (Id),
FOREIGN KEY (Empl_Id) REFERENCES Employee(Id)
)