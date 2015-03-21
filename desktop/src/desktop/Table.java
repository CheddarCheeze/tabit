package desktop;

import java.util.ArrayList;

public class Table {
    private int tableNumber;
    private int tableEmployee;
    private ArrayList<Integer> tableItemsOrdered = new ArrayList();
    
    public Table() {
        super();
        tableNumber = -1;
        tableEmployee = -1;
    }
    
    public Table(int tNum, int tEmp){
        tableNumber = tNum;
        tableEmployee = tEmp;
    }
    
    public void setTableNumber(int n){
        this.tableNumber = n;
    }
    
    public void setTableEmployee(int e){
        this.tableEmployee = e;
    }
    
    public void addTableItem(int item){
        tableItemsOrdered.add(item);
    }
    
    public void removeTableItem(int item){
        tableItemsOrdered.remove(item);
    }

}
