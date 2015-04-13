package desktop;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import oracle.jdbc.pool.OracleDataSource;

/**
 *
 * @author  Nicolas Nunez
 * Some notes: in order to add date this is the format 'dd/mmm/yyyy'
 * where mmm is MAR for example
 */

public class DataHandler {
    //Some variables to be used with statements and whatnot...
    String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:tabit";
    String userid = "nanunezr";
    String password = "tabit0427";
    Connection conn;
    Statement stmt;
    ResultSet rset;
    String query;
    String sqlString;
    
    public DataHandler() throws SQLException {
        getDBConnection();
    }
    
    public void getDBConnection() throws SQLException{
        OracleDataSource ds;
        ds = new OracleDataSource();
        ds.setURL(jdbcUrl);
        conn = ds.getConnection(userid, password);
    }
    
    public void addNewEmployee(int id, String lastname, String firstname, String dob,String position, 
                               int salary, String phoneno) throws SQLException {
        Statement stmt = conn.createStatement();
        query = "INSERT INTO Employee VALUES("+id+", '"+lastname+"', '"+firstname+"', '"+dob+"', '"+position+"', "+salary+", '"+phoneno+"')";
        System.out.println("\nExecuting query: " + query);
        stmt.execute(query);
    }
    
    public void addSchedule(int id,String name, String mond, String tues, String wed, String thurs, String fri, String sat, String sun) throws SQLException {
        Statement stmt = conn.createStatement();
        System.out.println(name + " " + mond + " " + tues + " " + wed + " " + thurs + " " + fri + " " + sat + " " + sun);
        query = "INSERT INTO Schedule VALUES("+ id + ",'" +name+"', '"+mond+"', '"+tues+"', '"+wed+"', '"+thurs+"', '"+fri+"', '"+sat+"', '"+sun+"')";
        System.out.println("\nExecuting query: " + query);
        stmt.execute(query);
    }
    
    public void addInventory(int id ,String ProdName, int Quant, String DateIn,float CostUnit, float TotalCost,float SalePrice,  int EmplID,String Vendor,int VendorNo ) throws SQLException {
        Statement stmt = conn.createStatement();
        
        query = "INSERT INTO Inventory VALUES(" + id + ", '"+ ProdName +"', "+Quant+", '"+DateIn+"', "+CostUnit+", "+ TotalCost +", "+ SalePrice +", "+ EmplID+",'" + Vendor + "', "+ VendorNo +" )";
        System.out.println("\nExecuting query: " + query);
        stmt.execute(query);
    }
    
    
    public void updateInventory(int id ,String ProdName, int Quant, String DateIn,float CostUnit, float TotalCost,float SalePrice,  int EmplID,String Vendor,int VendorNo ) throws SQLException {
        Statement stmt = conn.createStatement();
        query = "UPDATE Inventory SET productname='" + ProdName + "', quantity='"+Quant+"', date_in='"+DateIn+"', cost_unit='"+CostUnit+"', total_cost='"+ TotalCost +"', sale_price='"+ SalePrice +"', empl_id='"+ EmplID+"',vendor='" + Vendor + "vendorno=', "+ VendorNo +"'where id = " + id;
        System.out.println("\nExecuting query: " + query);
        stmt.execute(query);
    }
    
    public void updateSchedule(int id ,String Name, String mon, String tues, String wed, String thur, String frid, String sat, String sun) throws SQLException {
        Statement stmt = conn.createStatement();
        System.out.println("GOTHERRE");
        query = "UPDATE Schedule SET name='" + Name + "', monday='"+mon+"', tuesday='"+tues+"', wednesday='"+wed+"', thursday='"+ thur +"', friday='"+ frid +"', saturday='"+ sat +"',sunday='" + sun + "' where id = " + id;
        System.out.println("\nExecuting query: " + query);
        stmt.execute(query);
    }
    
    public boolean findKey(String table, int id) throws SQLException {
        Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
               ResultSet.CONCUR_READ_ONLY);
        query = "SELECT count(1) from " + table + " where id = "+ id;
      // query = "SELECT Firstname, Lastname FROM Employee where id = "+ id;
        System.out.println("\nExecuting query: " + query);
        
         rset = stmt.executeQuery(query);
        int found =-1;
        while(rset.next()){
        found = rset.getInt(1);
        }
        System.out.println(found);
        if (found == 1)
            return true;
        else
            return false;
    }
    
    
    public String getEmployeeName(int id) throws SQLException{
        stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
               ResultSet.CONCUR_READ_ONLY);
        query = "SELECT Firstname, Lastname FROM Employee where id = "+ id;
        System.out.println("\nExecuting query:  " + query);
        rset = stmt.executeQuery(query); 
        String Name = "";
        while(rset.next()){
        Name = rset.getString(1) + " " + rset.getString(2);
        }
        return Name;
    }
    
    public ResultSet getAllEmployees() throws SQLException{
        stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
               ResultSet.CONCUR_READ_ONLY);
        query = "SELECT * FROM Employee ORDER BY id";
        System.out.println("\nExecuting query: " + query);
        rset = stmt.executeQuery(query);
        return rset;
    }
    
    public ResultSet getAllProducts() throws SQLException{
        stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
               ResultSet.CONCUR_READ_ONLY);
        query = "SELECT * FROM Inventory ORDER BY id";
        System.out.println("\nExecuting query: " + query);
        rset = stmt.executeQuery(query);        
        return rset;
    }
    
    public ResultSet getSchedule() throws SQLException{
        stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
               ResultSet.CONCUR_READ_ONLY);
        query = "SELECT * FROM Schedule ORDER BY ID";
        System.out.println("\nExecuting query: " + query);
        rset = stmt.executeQuery(query);        
        return rset;
    }
    
    public ResultSet getInventory() throws SQLException{
        stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
               ResultSet.CONCUR_READ_ONLY);
        query = "SELECT * FROM Inventory ORDER BY ID";
        System.out.println("\nExecuting query: " + query);
        rset = stmt.executeQuery(query);        
        return rset;
    }
    public void printEmployees() throws SQLException {
        ResultSet temp = getAllEmployees();
        while(temp.next()){
            System.out.println(temp.getInt(1)+ " " + temp.getString(2) + " " +
                temp.getString(3) + " " + temp.getString(4) + " " + temp.getString(5) + " " + 
                temp.getInt(6) + " " + temp.getString(7));
        }
    }
    public void printInventory() throws SQLException{
        ResultSet temp = getAllProducts();
        while(temp.next()){
            System.out.println(temp.getInt(1)+ " " + temp.getString(2) + " " +
                temp.getInt(3) + " " + temp.getString(4).substring(0, 9)+ " " + temp.getFloat(5) + " " + 
                temp.getFloat(6) + " " + temp.getFloat(7) + " " + temp.getInt(8) + " " + 
                temp.getString(9) + " " + temp.getString(10));
        }
    }

    public int getRows(String tablename) throws SQLException{
        int rows = 0;
        stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
               ResultSet.CONCUR_READ_ONLY);
        query = "SELECT COUNT(*) FROM "+tablename+"";
        System.out.println("\nExecuting query: " + query);
        rset = stmt.executeQuery(query);
        while(rset.next()){
            rows = rset.getInt(1);
        }
        System.out.println(rows);
        return rows;
    }
    
    public void deleteInfoDatabase(String tablename) throws SQLException{
        stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
               ResultSet.CONCUR_READ_ONLY);
        query = "DELETE FROM "+ tablename +"";
        System.out.println("\nExecuting query: " + query);
        stmt.execute(query);
    }
/*
 * Main method is for testing purposes only
 */
    public static void main(String[] args) throws SQLException {
        DataHandler datahandler = new DataHandler();
        datahandler.printEmployees();
//        datahandler.addSchedule("Niggolah", "asfdasfd", "asdfasfsad", "asdfsafsdaf", "asdfasfsad", "asdfsadf", "asdfsafsda", "asdfsdafsd");
      //  datahandler.addNewEmployee(7, "McAlly", "James", "05/MAR/1991","Cashier", 
        //                       30000, "479-990-7869");
        datahandler.printEmployees();
        System.out.println(datahandler.getRows("Employee"));
        System.out.println(datahandler.getRows("Inventory"));
        
        //datahandler.printInventory();
        //datahandler.addInventory(11, "Plastic Cups", 3 ,"10-MAR-15", 4, 5, 10, 1, "WALMART", 1);
        System.out.println(datahandler.getEmployeeName(1));
    }

    void deleteSchedule(int i) throws SQLException{
        stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
               ResultSet.CONCUR_READ_ONLY);
        query = "DELETE FROM SCHEDULE WHERE id="+ i;
        System.out.println("\nExecuting query: " + query);
        stmt.execute(query);
    }
}
