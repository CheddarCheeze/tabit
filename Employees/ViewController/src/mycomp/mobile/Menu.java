package mycomp.mobile;

import oracle.adfmf.java.beans.PropertyChangeListener;
import oracle.adfmf.java.beans.PropertyChangeSupport;

public class Menu {

    private transient PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public Menu() {
        super();
    }
    
    private int id;
    private String name;
    private double price;
    
    public Menu(String tname, double tprice) {
        super();
        this.name = tname;
        this.price = tprice;
    }
    
    public Menu(int tid, String tname, double tprice){
        super();
        this.id = tid;
        this.name = tname;
        this.price = tprice;
    }

    public void setId(int id) {
        int oldId = this.id;
        this.id = id;
        propertyChangeSupport.firePropertyChange("id", oldId, id);
    }

    public void addPropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.addPropertyChangeListener(l);
    }

    public void removePropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.removePropertyChangeListener(l);
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        String oldName = this.name;
        this.name = name;
        propertyChangeSupport.firePropertyChange("name", oldName, name);
    }

    public String getName() {
        return name;
    }

    public void setPrice(double price) {
        double oldPrice = this.price;
        this.price = price;
        propertyChangeSupport.firePropertyChange("price", oldPrice, price);
    }

    public double getPrice() {
        return price;
    }
}
