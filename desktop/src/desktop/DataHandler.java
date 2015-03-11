package desktop;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import oracle.jdbc.pool.OracleDataSource;

/**
 *
 * @author  Nicolas Nunez
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
        query = "INSERT INTO Employee VALUES("+id+", "+lastname+", "+firstname+", "+dob+", "+position+", "+salary+", "+phoneno+")";
        System.out.println("\nExecuting query: " + query);
        stmt.execute(query);
    }
    
    //public void addNewProduct()
    
    public ResultSet getAllEmployees() throws SQLException{
        stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
               ResultSet.CONCUR_READ_ONLY);
        query = "SELECT * FROM Employees ORDER BY id";
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
}
