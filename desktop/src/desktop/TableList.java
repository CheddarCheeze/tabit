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
import javax.swing.*;
import javax.swing.event.*;

public class TableList extends JFrame implements ListSelectionListener {
    public static ArrayList<Table> allTables;
    public static String[] tableNumbers = new String[1000];
    public static JList tableJList;
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
//        tableJList.addListSelectionListener(
//           new ListSelectionListener(){
//               
//               public void valueChanged(ListSelectionEvent event){
//                   int i = tableJList.getSelectedIndex();
//                   System.out.print("Value Changed: " + i + "\n");
//               }
//           }
//        );
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
        
    }

    @Override
    public void valueChanged(ListSelectionEvent listSelectionEvent) {
        int i = tableJList.getSelectedIndex();
        System.out.print("Value Changed: " + i + "\n");
    }
}
