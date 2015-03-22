package desktop;

import java.util.ArrayList;

public class TableList {
    private static ArrayList<Table> allTables = new ArrayList<>();
    
    public TableList() {
        super();
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
}
