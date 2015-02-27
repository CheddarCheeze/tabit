CREATE TABLE Inventory
(
Id int NOT NULL,
ProductName varchar(30) NOT NULL,
Quantity int,
Date_In date,
Cost_Unit decimal(5,2),
Total_Cost decimal(6,2),
Sale_Price decimal(5,2),
Empl_Id int,
Vendor varchar(30),
VendorNo varchar(20),
PRIMARY KEY (Id),
FOREIGN KEY (Empl_Id) REFERENCES Employee(Id)
)