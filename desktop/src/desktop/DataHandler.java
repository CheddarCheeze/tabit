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
    
    //public void addNewProduct()
    
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
    
    public void printEmployees() throws SQLException {
        ResultSet temp = getAllEmployees();
        while(temp.next()){
            System.out.println(temp.getInt(1)+ " " + temp.getString(2) + " " +
                temp.getString(3) + " " + temp.getString(4).substring(0, 9)+ " " + temp.getString(5) + " " + 
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

    
    public static void main(String[] args) throws SQLException {
        DataHandler datahandler = new DataHandler();
        datahandler.printEmployees();
        datahandler.addNewEmployee(6, "McAlly", "James", "05/MAR/1991","Cashier", 
                               30000, "479-990-7869");
        datahandler.printEmployees();
        //datahandler.printInventory();
    }
}
