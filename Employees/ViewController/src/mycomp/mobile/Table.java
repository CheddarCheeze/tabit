package mycomp.mobile;

import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Table {
    DecimalFormat df = new DecimalFormat("#.00"); 
    private int tableNumber;
    private int EmployeeNum;
    private ArrayList ItemsOrdered;
    private String notes;
    //DataHandler databit;
    
    public static class TotalPair{
        public double notaxincluded = 0;
        public double tot = 0;
        public double tax = 0.09;
        
        //@Override
        public String toString(){
            return "Items Cost: " + notaxincluded + " |Tax: " + tax + " |TOTAL: " + tot;                
        }
    }
    
    public Table() throws SQLException {
        this(-1, -1, "");
    }
    
    public Table(int tNum, int eNum, String note) throws SQLException {
        //databit = new DataHandler();
        tableNumber = tNum;
        EmployeeNum = eNum;
        notes = note;
        ItemsOrdered = new ArrayList();
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
    
    public ArrayList getItemsOrdered(){
        return ItemsOrdered;
    }
    
    public void clearTable(){
        ItemsOrdered.clear();
    }
    
    public TotalPair totalCostOrder(){
        TotalPair total = new TotalPair();
        String temp;
        /*
        for (int i = 0; i < ItemsOrdered.size(); i++){
            total.notaxincluded = total.notaxincluded + (ItemsOrdered.get(i).getQuantity() * ItemsOrdered.get(i).getPrice());
        }
        */
        temp = df.format(total.notaxincluded);
        total.notaxincluded = Double.parseDouble(temp);
        total.tax = total.notaxincluded * total.tax;
        temp = df.format(total.tax);
        total.tax = Double.parseDouble(temp);
        total.tot = total.notaxincluded + total.tax;
        temp = df.format(total.tot);
        total.tot = Double.parseDouble(temp);
        return total;
    }
    
    public void printOrderTable() throws SQLException {
        //String temp = databit.getEmployeeName(this.EmployeeNum);
        System.out.println("Table number: " + this.tableNumber + " " + "Hosted by: " ); //+ temp);
        for (int i = 0; i < ItemsOrdered.size(); i++){
            System.out.print(ItemsOrdered.get(i).toString());
        }
        System.out.println();
    }
    
//Main method for testing purposes only
// In constructor the tablenumber goes first
    /*
    public static void main(String[] args) throws SQLException {
        
        Table table1 = new Table(1, 1);
        table1.addItem(new Item("Taco", 1, 3, 1.35));
        table1.addItem(new Item("Quesadilla", 2, 3, 4.35));
        table1.addItem(new Item("Torta", 3, 3, 5.35));
        table1.addItem(new Item("Gordita", 4, 3, 2.35));
        table1.printOrderTable();
        System.out.println(table1.totalCostOrder());
        
        Table table2 = new Table(2, 2);
        table2.addItem(new Item("Mole", 4, 1, 1.99));
        table2.addItem(new Item("Nachos con queso", 6, 1, 3.50));
        table2.addItem(new Item("Razorback Burro", 7, 1, 5.35));
        table2.addItem(new Item("Soda de Naranja", 8, 1, 2.00));
        table2.printOrderTable();
        System.out.println(table2.totalCostOrder());    
        
    }*/
}
