package desktop;

import javax.swing.JFrame;

/*
 * Purpose is to display all tables in use
 * with a boolean value see if a table is in use or not
*/

import static java.lang.String.valueOf;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Arrays;

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
    }
    
        public void addTable(Table t){
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
    }
}
