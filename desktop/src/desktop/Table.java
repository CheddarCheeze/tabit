package desktop;

/* READ
 * Changes by: Nicolas Nunez
 * changed some variable names and made the ArrayList of orders to contain items
 * instead of Integers we still have to figure out a way to approach to this issue
 *
*/

import java.awt.ItemSelectable;

import java.util.ArrayList;

public class Table {
    private int tableNumber;
    private int EmployeeNum;
    private ArrayList<Item> ItemsOrdered;
    
    public Table() {
        this(-1, -1);
    }
    
    public Table(int tNum, int eNum){
        tableNumber = tNum;
        EmployeeNum = eNum;
        ItemsOrdered = new ArrayList<>();
    }
    
    public void setTableNumber(int n){
        tableNumber = n;
    }
    
    public void setTableEmployee(int e){
        EmployeeNum = e;
    }
    
    public int getTableNumber(){
        return tableNumber;
    }
    
    public int getEmployeeNumber(){
        return EmployeeNum;
    }
    
    public void addItem(Item item){
        ItemsOrdered.add(item);
    }
    
    public void removeItem(Item item){
        ItemsOrdered.remove(item);
    }
    
    public int getNumItems(){
        return ItemsOrdered.size();
    }
    
    public void printOrderTable(){
        for (int i=0; i<ItemsOrdered.size(); i++){
            System.out.print(ItemsOrdered.get(i).toString());
        }
    }
    
//Main method for testing purposes only

    public static void main(String[] args){
        Table table1 = new Table(1, 1);
        table1.addItem(new Item("Taco", 1, 3, 1.35));
        table1.addItem(new Item("Quesadilla", 2, 3, 4.35));
        table1.addItem(new Item("Torta", 3, 3, 5.35));
        table1.addItem(new Item("Gordita", 4, 3, 2.35));
        System.out.println(table1.getEmployeeNumber() + " " + table1.getTableNumber());
        table1.printOrderTable();
    
    }
}
