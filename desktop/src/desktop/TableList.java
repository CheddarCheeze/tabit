package desktop;

import javax.swing.JFrame;

/*
 * Purpose is to display all tables in use
 * @author: Brandon Foster
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
import javax.swing.*;
import javax.swing.event.*;

public class TableList extends JFrame {
    public static ArrayList<Table> allTables;
    public static String[] tableNumbers = new String[1000];
    public static JList tableJList;
    private static Table t = null; // used as return for getTableByNumber
    public String args[] = {};
    public static DefaultListModel listModel;
    
    public static void populateList(){
        for(int i = 0; i < allTables.size(); i++){
            String num = valueOf(allTables.get(i).getTableNumber());
            System.out.print(num + "\n");
            tableNumbers[i] = "Table " + num;
            listModel.addElement("Table " + num);
            ManagerProfile.strings = tableNumbers;
        }
    }
    
    public TableList() {
        allTables = new ArrayList<>();
        listModel = new DefaultListModel();
        tableJList = new JList(listModel);
        tableJList.setVisibleRowCount(10);
        tableJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        add(new JScrollPane(tableJList));

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
        
        /*
         * getTableByNumber takes in a table number and returns the table
         * object with the matching number. A null pointer will be returned if 
         * the matching table does not exist
         */
        public static Table getTableByNumber(int tableNumber){
            try {
                Table t = new Table();
                for(int i = 0; i < allTables.size(); i++){
                    t = allTables.get(i);
                    if(t.getTableNumber() == tableNumber){
                        return t; 
                    }
                }

            } catch (SQLException e) {
            }
            return t; // this t is a null pointer
        }
    
    public static void main(String[] args){
        
    }

}
