package mycomp.mobile;

import java.util.ArrayList; 
import java.util.Calendar; 
import java.util.Date; 
import java.util.List;

public class Orders {
    private List s_orders = null;
    
    public Orders() {
        super();
    }
    
    public Order[] getOrders() { 
          //This Method gets a list of the employees and their emails 
          Order[] orders = null; 
          s_orders = new ArrayList();
          
          s_orders.add(new Order(2, "1, 3, 5", "", 1, 12.13, 0, 12.13));          
          s_orders.add(new Order(2, "1, 2, 5", "", 2, 13.13, 0, 13.13));          
          s_orders.add(new Order(2, "2, 4, 5", "", 3, 9.50, 0.50, 9.00));
          
          
          orders = (Order[]) s_orders.toArray(new Order[s_orders.size()]); 
          return orders; 
        } 

        private Date getADate(int y,int m, int d,int h, int mi) { 
          Calendar c1 = Calendar.getInstance(); 
          c1.set(y, m, d, h, mi); 
          Date retDate = c1.getTime(); 
          return retDate; 
        } 
}
