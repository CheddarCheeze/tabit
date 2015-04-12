package desktop;

/*
 * Purpose is to display all tables in use
 * with a boolean value see if a table is in use or not
*/
<<<<<<< HEAD
import static java.lang.String.valueOf;

=======
>>>>>>> fd97fe2f23e33a258df86645a06b3a377195a562
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Arrays;


<<<<<<< HEAD
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class TableList extends JFrame {
    public static ArrayList<Table> allTables;
    public static String[] tableNumbers = new String[1000];
    private final JList tableJList;
    public String args[] = {};
    
    public TableList() {
        allTables = new ArrayList<>();

        tableJList = new JList(tableNumbers);
        tableJList.setVisibleRowCount(10);
        tableJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        add(new JScrollPane(tableJList));
        tableJList.addListSelectionListener(
           new ListSelectionListener(){
               
               public void valueChanged(ListSelectionEvent event){
                   System.out.print("Value Changed\n");
                   
               }
           }
        );
=======
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
>>>>>>> fd97fe2f23e33a258df86645a06b3a377195a562
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
<<<<<<< HEAD
    
    public ArrayList<Table> returnTables(){
        return allTables;
    }
    
    public static boolean tableFree (int tableNum){
        for (int i = 0; i < allTables.size(); i++){
            Table t1 = allTables.get(i);
            if(t1.getTableNumber() == tableNum){
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args){
        //Make some Tables
        try {
            Table t1 = new Table(1, 1);
            Table t2 = new Table(2,2);
            Table t3 = new Table(3,3);
            Table t4 = new Table(4,3);
            allTables.add(t1);
            allTables.add(t2);
            allTables.add(t3);
            allTables.add(t4);
        } catch (SQLException e) {
        }
        
        for(int i = 0; i < allTables.size(); i++){
            Table t = allTables.get(i);
            String num = valueOf(t.getTableNumber());
            System.out.print(num + "\n");
            tableNumbers[i] = "Table " + num;
        }
=======
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
        
                
>>>>>>> fd97fe2f23e33a258df86645a06b3a377195a562
    }
}
