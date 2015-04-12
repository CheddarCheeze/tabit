package desktop;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.DriverManager;

import java.text.SimpleDateFormat;

import oracle.jdbc.pool.OracleDataSource;

/**
 *
 * @author  Nicolas Nunez
 * Some notes: in order to add date this is the format 'MON/DD/YYYY'
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
    SimpleDateFormat fmt = new SimpleDateFormat("MMM/dd/yyyy");
    
    public DataHandler() throws SQLException {
        getDBConnection();
        alterDateFormat("MON/DD/YYYY");
        printDateFormat();
    }
    
    public void getDBConnection() throws SQLException{
        OracleDataSource ds;
        ds = new OracleDataSource();
        ds.setURL(jdbcUrl);
        conn = ds.getConnection(userid, password);
    }
    
//==============================================================
// Name: alterDateFormat
// Purpose: to set the date of the database being used in a 
//          desired format
// Parameters: String dateformat "MMM/DD/YYYY"
//==============================================================
        public void alterDateFormat(String df) throws SQLException{
        stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
               ResultSet.CONCUR_READ_ONLY);
        query = "ALTER SESSION SET NLS_DATE_FORMAT='" + df + "'";
//        System.out.println("\nExecuting query: " + query);
        stmt.execute(query);
        }
        
// ===================================================================
// Method: printDateFormat
// Purpose: print the nls_date_format of the database being used
// Paramaters: none
// ===================================================================
        public void printDateFormat() throws SQLException{
            String temp = "";
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                   ResultSet.CONCUR_READ_ONLY);
            query = "SELECT SYSDATE FROM DUAL";
  //          System.out.println("\nExecuting query: " + query);
            rset = stmt.executeQuery(query);
            while(rset.next()){
                 temp = rset.getString(1);
            }
            System.out.println(temp);
        }
    
//==================================================================================================
// Name: addNewEmployee
// Purpose: to add a new employee to the database
// Paramaters: all the necessary information
//             id, last name, first name, date of brith, position, salary, phone no
// returns nothing
//==================================================================================================

    public void addNewEmployee(int id, String lastname, String firstname, String dob,String position, 
                               int salary, String phoneno) throws SQLException {
        Statement stmt = conn.createStatement();
        query = "INSERT INTO Employee VALUES("+id+", '"+lastname+"', '"+firstname+"', '"+dob+"', '"+position+"', "+salary+", '"+phoneno+"')";
        System.out.println("\nExecuting query: " + query);
        stmt.execute(query);
    }

//==================================================================================================
// Name: addSchedule
// Purpose: to schedule a worker.
// Paramaters: all the necessary information
//             id, last name, first name, date of brith, position, salary, phone no
// returns nothing
//==================================================================================================    
    public void addSchedule(String name, String mond, String tues, String wed, String thurs, String fri, String sat, String sun) throws SQLException {
        Statement stmt = conn.createStatement();
        System.out.println(name + " " + mond + " " + tues + " " + wed + " " + thurs + " " + fri + " " + sat + " " + sun);
        query = "INSERT INTO Schedule VALUES('"+name+"', '"+mond+"', '"+tues+"', '"+wed+"', '"+thurs+"', '"+fri+"', '"+sat+"', '"+sun+"')";
        System.out.println("\nExecuting query: " + query);
        stmt.execute(query);
    }
    
    public void addInventory(int id ,String ProdName, int Quant, String DateIn,float CostUnit, float TotalCost,float SalePrice,  int EmplID,String Vendor,int VendorNo ) throws SQLException {
        Statement stmt = conn.createStatement();
        query = "INSERT INTO Inventory VALUES(" + id + ", '"+ ProdName +"', "+Quant+", '"+DateIn+"', "+CostUnit+", "+ TotalCost +", "+ SalePrice +", "+ EmplID+",'" + Vendor + "', "+ VendorNo +" )";
        System.out.println("\nExecuting query: " + query);
        stmt.execute(query);
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
//=========================================================================
// Name: getVendorInfo
// Purpose: get a string with the information of the vendor
//          to be displayed in the jPanel.
// Parameters: the respective id of the vendor whose information is wanted
// Returns: A string concatenated with all the information of the vendor.
//=========================================================================
    public String getVendorInfo(int id) throws SQLException {
        stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
               ResultSet.CONCUR_READ_ONLY);
        query = "SELECT * FROM  Vendor where id=" + id;
        System.out.println("\nExecuting query: " + query);
        rset = stmt.executeQuery(query);        
        String allInfo="";
        while(rset.next()){
            allInfo = "Id: " + rset.getInt(1) + 
                      "\nVendor: " + rset.getString(2) + 
                      "\nPhone Number: " + rset.getString(3) + 
                      "\nAddress: " + rset.getString(4) +
                      "\nAdditional Information:\n" + rset.getString(5)+ "\n";
        }
        return allInfo;
    }
//======================================================================
// Name: deleteByID
// Purpose: to delete information from a given table by the unique id
// Parameters: String name of table, int id
// Returns: nothing
//======================================================================
    public void deleteById(String tableName, int id) throws SQLException{
        Statement stmt = conn.createStatement();
        query = "DELETE FROM " + tableName + " WHERE ID = " +id;
        System.out.println("\nExecuting query: " + query);
        stmt.execute(query);
    }

    public ResultSet getSchedule() throws SQLException{
        stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
               ResultSet.CONCUR_READ_ONLY);
        query = "SELECT * FROM Schedule ORDER BY Name";
        System.out.println("\nExecuting query: " + query);
        rset = stmt.executeQuery(query);        
        return rset;
    }

//=================================================================================
// Name: getInventory
// Purpose: to get all items in the inventory
// Parameters: none
// Returns: ResultSet
//=================================================================================    
    public ResultSet getInventory() throws SQLException{
        stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
               ResultSet.CONCUR_READ_ONLY);
        query = "SELECT * FROM Inventory ORDER BY ID";
        System.out.println("\nExecuting query: " + query);
        rset = stmt.executeQuery(query);        
        return rset;
    }
    
//=================================================================================
// Name: printEmployees
// Purpose: to print all the information of all employess
// Parameters: none
//=================================================================================
    
    public void printEmployees() throws SQLException {
        ResultSet temp = getAllEmployees();
        while(temp.next()){
            System.out.println(temp.getInt(1)+ " " + temp.getString(2) + " " +
                temp.getString(3) + " " + fmt.format(temp.getDate(4)) + " " + temp.getString(5) + " " + 
                temp.getInt(6) + " " + temp.getString(7));
        }
    }

//=================================================================================
// Name: printInventory
// Purpose: to print all items in the inventory table
// Parameters: none
//=================================================================================
    public void printInventory() throws SQLException{
        ResultSet temp = getAllProducts();
        while(temp.next()){
            System.out.println(temp.getInt(1)+ " " + temp.getString(2) + " " +
                temp.getInt(3) + " " + fmt.format(temp.getDate(4))+ " " + temp.getFloat(5) + " " + 
                temp.getFloat(6) + " " + temp.getFloat(7) + " " + temp.getInt(8) + " " + 
                temp.getString(9) + " " + temp.getString(10));
        }
    }

//=================================================================================
// Name: getRows
// Purpose: get the number of rows in a specific table of the database
// Parameters: String tableName
//=================================================================================
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
    
// ===================================================================
// Method: deleteInfoTable
// Purpose: To delete all content in a specific table
// Paramaters: String tablename
// ===================================================================
    public void deleteInfoTable(String tablename) throws SQLException{
        stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
               ResultSet.CONCUR_READ_ONLY);
        query = "DELETE FROM "+ tablename +"";
        System.out.println("\nExecuting query: " + query);
        stmt.execute(query);
    }
// ============================================================================
// Name: main 
// Purpose: method is for testing class purposes only
// Paramaters: String[] args
// ============================================================================
    public static void main(String[] args) throws SQLException {
        DataHandler datahandler = new DataHandler();
        datahandler.printEmployees();
//        datahandler.addSchedule("Niggolah", "asfdasfd", "asdfasfsad", "asdfsafsdaf", "asdfasfsad", "asdfsadf", "asdfsafsda", "asdfsdafsd");
        //datahandler.addNewEmployee(6, "McAlleyOop", "James", "APR/05/1991","Cashier", 30000, "479-990-7869");
        //datahandler.addNewEmployee(7, "Chumacero", "Chumita", "MAY/07/1994","Cashier", 20000, "479-990-7753");
//        datahandler.printEmployees();
//        System.out.println(datahandler.getRows("Employee"));
//        System.out.println(datahandler.getRows("Inventory"));
        
        //datahandler.printInventory();
        //datahandler.addInventory(11, "Plastic Cups", 3 ,"10-MAR-15", 4, 5, 10, 1, "WALMART", 1);
        datahandler.printEmployees();
        System.out.println(datahandler.getEmployeeName(1));
        System.out.println(datahandler.getVendorInfo(1));
        //datahandler.deleteById("inventory", 7);
    }
}
