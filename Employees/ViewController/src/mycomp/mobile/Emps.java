package mycomp.mobile;

import java.util.ArrayList; 
import java.util.Calendar; 
import java.util.Date; 
import java.util.List;

public class Emps {
    private List s_emps = null;

    public Emps() {
      super();
    }

    public Emp[] getEmps() { 
      //This Method gets a list of the employees and their emails 
      Emp[] emps = null; 
      s_emps = new ArrayList(); 
      s_emps.add(new Emp("Table 1", "bill@oracle.com",40, getADate(2011,3,24,9,0) )) ; 
      s_emps.add(new Emp("Table 2", "gary@oracle.com", 50, getADate(2007,2,24,9,0) )) ; 
      s_emps.add(new Emp("Table 3", "jeff@oracle.com", 55, getADate(2003,2,19,9,0) )) ; 
      s_emps.add(new Emp("Table 4", "joe@oracle.com", 40, getADate(2012,2,13,9,0) )) ; 
      s_emps.add(new Emp("Table 5", "shay@oracle.com",60, getADate(2002,2,21,9,0) )) ; 
      emps = (Emp[]) s_emps.toArray(new Emp[s_emps.size()]); 
      return emps; 
    } 

    private Date getADate(int y,int m, int d,int h, int mi) { 
      Calendar c1 = Calendar.getInstance(); 
      c1.set(y, m, d, h, mi); 
      Date retDate = c1.getTime(); 
      return retDate; 
    } 

}