package mycomp.mobile;

import java.util.ArrayList; 
import java.util.Calendar; 
import java.util.Date; 
import java.util.List;

public class Items {
    private List s_items = null;
    
    public Items() {
        super();
    }
    
    public Item[] getItems() { 
          //This Method gets a list of the employees and their emails 
          Item[] items = null; 
          s_items = new ArrayList();
          
          s_items.add(new Item("Taco", 1, 1, 1.25));
          s_items.add(new Item("Burrito", 2, 1, 4.65));
          s_items.add(new Item("Gordita", 3, 1, 3.95));
          s_items.add(new Item("Quesadila", 4, 1, 4.25));
          s_items.add(new Item("Tamale", 5, 1, 3.55));
          
          
          items = (Item[]) s_items.toArray(new Item[s_items.size()]); 
          return items; 
        } 

        private Date getADate(int y,int m, int d,int h, int mi) { 
          Calendar c1 = Calendar.getInstance(); 
          c1.set(y, m, d, h, mi); 
          Date retDate = c1.getTime(); 
          return retDate; 
        } 
}
