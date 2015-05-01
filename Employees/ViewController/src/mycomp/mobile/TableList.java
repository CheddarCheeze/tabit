package mycomp.mobile;

/*
 * Purpose is to contain information about the Table Objects
 * @author: Brandon Foster
*/

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TableList {
    private List s_tables = null;

    public TableList() {
        super();
    }
    
    public Table[] getTables() throws SQLException {
        // This method gets the list of tables
        Table[] tables = null;
        s_tables = new ArrayList();
        s_tables.add(new Table(1, 2, ""));
        s_tables.add(new Table(2, 2, ""));
        s_tables.add(new Table(3, 2, ""));
        s_tables.add(new Table(4, 2, ""));
        s_tables.add(new Table(5, 2, ""));
        tables = (Table[]) s_tables.toArray(new Table[s_tables.size()]);
        return tables;
    }
}
