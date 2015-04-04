package desktop;

/* READ
 * Changes by: Nicolas Nunez
 * changed some variable names and made the ArrayList of orders to contain items
 * instead of Integers we still have to figure out a way to approach to this issue
 *
*/

import java.awt.ItemSelectable;

import java.sql.SQLException;

import java.util.ArrayList;

public class Table {
    private int tableNumber;
    private int EmployeeNum;
    private ArrayList<Item> ItemsOrdered;
    DataHandler databit;
    
    public Table() throws SQLException {
        this(-1, -1);
    }
    
    public Table(int tNum, int eNum) throws SQLException {
        databit = new DataHandler();
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
    
    public double totalCostOrder(){
        double temp = 0;
        return temp;
    }
    
    public void printOrderTable() throws SQLException {
        String temp = databit.getEmployeeName(this.EmployeeNum);
        System.out.println("Table number: " + this.tableNumber + " " + "Hosted by: " + temp);
        for (int i=0; i<ItemsOrdered.size(); i++){
            System.out.print(ItemsOrdered.get(i).toString());
        }
        System.out.println();
    }
    
//Main method for testing purposes only
// In constructor tablenumber goes first

    public static void main(String[] args) throws SQLException {
        
        Table table1 = new Table(1, 1);
        table1.addItem(new Item("Taco", 1, 3, 1.35));
        table1.addItem(new Item("Quesadilla", 2, 3, 4.35));
        table1.addItem(new Item("Torta", 3, 3, 5.35));
        table1.addItem(new Item("Gordita", 4, 3, 2.35));
        table1.printOrderTable();
        
        Table table2 = new Table(1, 2);
        table2.addItem(new Item("Mole", 4, 3, 1.99));
        table2.addItem(new Item("Nachos con queso", 6, 3, 3.50));
        table2.addItem(new Item("Razorback Burro", 7, 3, 5.35));
        table2.addItem(new Item("Soda de Naranja", 8, 3, 2.00));
        table2.printOrderTable();
        
        
    
    }
}
