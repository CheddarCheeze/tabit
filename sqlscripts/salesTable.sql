CREATE TABLE Sales
(
Id int NOT NULL,
Sale_Date date,
SaleDescprition varchar(500),
Sale_Price decimal(5,2),
Empl_Id int,
PRIMARY KEY (Id),
FOREIGN KEY (Empl_Id) REFERENCES Employee(Id)
)