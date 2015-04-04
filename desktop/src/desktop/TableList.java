package desktop;

/*
 * Purpose is to display all tables in use
 * with a boolean value see if a table is in use or not
*/
import java.util.ArrayList;

public class TableList {
    public static final int tableCount = 10;
    private static ArrayList<Table> allTables;
    boolean[] isInUse = new boolean[tableCount];
    public TableList() {
        allTables = new ArrayList<>();
    }
    
    public static void addTable(Table t){
        allTables.add(t);
    }
    
    public void removeTable(Table t){
        allTables.remove(t);
    }
    
    public static void clearTables(){
        allTables.clear();
    }
    
    public int getNumTables(){
        return allTables.size();
    }
    public static void main(String[] args){
        TableList tabs = new TableList();
        
        
    }
}
