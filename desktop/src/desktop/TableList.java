package desktop;

/*
 * Purpose is to display all tables in use
 * with a boolean value see if a table is in use or not
*/
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Arrays;


public class TableList {
    public static final int tableCount = 10;
    private static ArrayList<Table> allTables;
    static boolean[] InUse = new boolean[tableCount];
    
    TableList(){
        this(null);
    }
    public TableList(Table table) {
        allTables = new ArrayList<>();
        addTable(table);
        for (int i = 0; i<tableCount; i++){
            InUse[i] = false;
        }
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
    public static void main(String[] args) throws SQLException {
        TableList tabs = new TableList();
        Table table1 = new Table(1, 1);
        table1.addItem(new Item("Taco", 1, 3, 1.35));
        table1.addItem(new Item("Quesadilla", 2, 3, 4.35));
        table1.addItem(new Item("Torta", 3, 3, 5.35));
        table1.addItem(new Item("Gordita", 4, 3, 2.35));
        
        Table table2 = new Table(2, 2);
        table2.addItem(new Item("Mole", 4, 1, 1.99));
        table2.addItem(new Item("Nachos con queso", 6, 1, 3.50));
        table2.addItem(new Item("Razorback Burro", 7, 1, 5.35));
        table2.addItem(new Item("Soda de Naranja", 8, 1, 2.00));
        
        Table table3 = new Table(1, 1);
        table3.addItem(new Item("Taco", 1, 3, 1.35));
        table3.addItem(new Item("Quesadilla", 2, 3, 4.35));
        table3.addItem(new Item("Torta", 3, 3, 5.35));
        table3.addItem(new Item("Gordita", 4, 3, 2.35));
        
        Table table4 = new Table(2, 2);
        table4.addItem(new Item("Mole", 4, 1, 1.99));
        table4.addItem(new Item("Nachos con queso", 6, 1, 3.50));
        table4.addItem(new Item("Razorback Burro", 7, 1, 5.35));
        table4.addItem(new Item("Soda de Naranja", 8, 1, 2.00));
        
        Table table5 = new Table(1, 1);
        table5.addItem(new Item("Taco", 1, 3, 1.35));
        table5.addItem(new Item("Quesadilla", 2, 3, 4.35));
        table5.addItem(new Item("Torta", 3, 3, 5.35));
        table5.addItem(new Item("Gordita", 4, 3, 2.35));
        
        Table table6 = new Table(2, 2);
        table6.addItem(new Item("Mole", 4, 1, 1.99));
        table6.addItem(new Item("Nachos con queso", 6, 1, 3.50));
        table6.addItem(new Item("Razorback Burro", 7, 1, 5.35));
        table6.addItem(new Item("Soda de Naranja", 8, 1, 2.00));
        
        Table table7 = new Table(1, 1);
        table7.addItem(new Item("Taco", 1, 3, 1.35));
        table7.addItem(new Item("Quesadilla", 2, 3, 4.35));
        table7.addItem(new Item("Torta", 3, 3, 5.35));
        table7.addItem(new Item("Gordita", 4, 3, 2.35));
        
        Table table8 = new Table(2, 2);
        table8.addItem(new Item("Mole", 4, 1, 1.99));
        table8.addItem(new Item("Nachos con queso", 6, 1, 3.50));
        table8.addItem(new Item("Razorback Burro", 7, 1, 5.35));
        table8.addItem(new Item("Soda de Naranja", 8, 1, 2.00));
        
        Table table9 = new Table(1, 1);
        table9.addItem(new Item("Taco", 1, 3, 1.35));
        table9.addItem(new Item("Quesadilla", 2, 3, 4.35));
        table9.addItem(new Item("Torta", 3, 3, 5.35));
        table9.addItem(new Item("Gordita", 4, 3, 2.35));
        
        Table table10 = new Table(2, 2);
        table10.addItem(new Item("Mole", 4, 1, 1.99));
        table10.addItem(new Item("Nachos con queso", 6, 1, 3.50));
        table10.addItem(new Item("Razorback Burro", 7, 1, 5.35));
        table10.addItem(new Item("Soda de Naranja", 8, 1, 2.00));
        
        tabs.addTable(table1);
        tabs.addTable(table2);
        tabs.addTable(table3);
        tabs.addTable(table4);
        tabs.addTable(table5);
        tabs.addTable(table6);
        tabs.addTable(table7);
        tabs.addTable(table8);
        tabs.addTable(table9);
        tabs.addTable(table10);
        
                
    }
}
