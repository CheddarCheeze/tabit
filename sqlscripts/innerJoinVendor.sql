select Vendor.Vendor, Vendor.PhoneNo, Vendor.AdditInfo 
FROM Vendor 
INNER JOIN Inventory
ON Vendor.id=Inventory.VendorNo;