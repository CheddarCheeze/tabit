package mycomp.mobile;

import oracle.adfmf.java.beans.PropertyChangeListener;
import oracle.adfmf.java.beans.PropertyChangeSupport;
import java.util.Date;

public class Emp {
    private transient PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public Emp() {
        super();
    }
    
    private String name;
    private String email;
    private int salary;
    private Date hireDate;
    
    public Emp(String name, String email) {
         super();
         this.name = name;
         this.email = email; 
    } 

    public Emp(String name, String email, int salary, Date hireDate) {
        super();
        this.name = name;
        this.email = email;
        this.salary = salary;
        this.hireDate = hireDate;
    }

    public void setName(String name) {
        String oldName = this.name;
        this.name = name;
        propertyChangeSupport.firePropertyChange("name", oldName, name);
    }

    public void addPropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.addPropertyChangeListener(l);
    }

    public void removePropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.removePropertyChangeListener(l);
    }

    public String getName() {
        return name;
    }

    public void setEmail(String email) {
        String oldEmail = this.email;
        this.email = email;
        propertyChangeSupport.firePropertyChange("email", oldEmail, email);
    }

    public String getEmail() {
        return email;
    }

    public void setSalary(int salary) {
        int oldSalary = this.salary;
        this.salary = salary;
        propertyChangeSupport.firePropertyChange("salary", oldSalary, salary);
    }

    public int getSalary() {
        return salary;
    }

    public void setHireDate(Date hireDate) {
        Date oldHireDate = this.hireDate;
        this.hireDate = hireDate;
        propertyChangeSupport.firePropertyChange("hireDate", oldHireDate, hireDate);
    }

    public Date getHireDate() {
        return hireDate;
    }
}
