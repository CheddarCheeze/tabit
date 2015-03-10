package desktop;
import java.sql.Connection;
import java.sql.SQLException;
import oracle.jdbc.pool.OracleDataSource;

public class DataHandler {
    //String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:ORACLE";
    String jdbcUrl = null;
    //String userid = "nanunezr";
    String userid = null;
    //String password = "tabit0427";
    String password = null; 
    Connection conn;
    
    public DataHandler() {
    }
    public void getDBConnection() throws SQLException{
        OracleDataSource ds;
        ds = new OracleDataSource();
        ds.setURL(jdbcUrl);
        conn = ds.getConnection(userid, password);
    }
}
