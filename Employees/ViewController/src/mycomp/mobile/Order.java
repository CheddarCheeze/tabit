package mycomp.mobile;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import oracle.adfmf.java.beans.PropertyChangeListener;
import oracle.adfmf.java.beans.PropertyChangeSupport;

public class Order {

    private transient PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public Order() {
        super();
    }
    
    private int empid;
    private String order;
    private String modifier;
    private int tableNumber;
    private double gsales;
    private double discount;
    private double total;
    private Date date;
    private boolean open;
    
    DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        
    public Order(int tempid, String torder, String tmodifier, int ttableNumber, double tgsales, double tdiscount, double ttotal) {
        super();
        empid = tempid;
        order = torder;
        modifier = tmodifier;
        tableNumber = ttableNumber;
        
        gsales = tgsales;
        discount = tdiscount;
        total = ttotal;
        
        date = new Date();
        open = true;
    }
    
    public Order(String torder, int ttableNumber, double ttotal) {
        super();
        
        order = torder;
        tableNumber = ttableNumber;
        total = ttotal;
        
        date = new Date();
        open = true;
    }

    public void setEmpid(int empid) {
        int oldEmpid = this.empid;
        this.empid = empid;
        propertyChangeSupport.firePropertyChange("empid", oldEmpid, empid);
    }

    public void addPropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.addPropertyChangeListener(l);
    }

    public void removePropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.removePropertyChangeListener(l);
    }

    public int getEmpid() {
        return empid;
    }

    public void setOrder(String order) {
        String oldOrder = this.order;
        this.order = order;
        propertyChangeSupport.firePropertyChange("order", oldOrder, order);
    }

    public String getOrder() {
        return order;
    }

    public void setModifier(String modifier) {
        String oldModifier = this.modifier;
        this.modifier = modifier;
        propertyChangeSupport.firePropertyChange("modifier", oldModifier, modifier);
    }

    public String getModifier() {
        return modifier;
    }

    public void setTableNumber(int tableNumber) {
        int oldTableNumber = this.tableNumber;
        this.tableNumber = tableNumber;
        propertyChangeSupport.firePropertyChange("tableNumber", oldTableNumber, tableNumber);
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public void setGsales(double gsales) {
        double oldGsales = this.gsales;
        this.gsales = gsales;
        propertyChangeSupport.firePropertyChange("gsales", oldGsales, gsales);
    }

    public double getGsales() {
        return gsales;
    }

    public void setDiscount(double discount) {
        double oldDiscount = this.discount;
        this.discount = discount;
        propertyChangeSupport.firePropertyChange("discount", oldDiscount, discount);
    }

    public double getDiscount() {
        return discount;
    }

    public void setTotal(double total) {
        double oldTotal = this.total;
        this.total = total;
        propertyChangeSupport.firePropertyChange("total", oldTotal, total);
    }

    public double getTotal() {
        return total;
    }

    public void setDate(Date date) {
        Date oldDate = this.date;
        this.date = date;
        propertyChangeSupport.firePropertyChange("date", oldDate, date);
    }

    public Date getDate() {
        return date;
    }

    public void setOpen(boolean open) {
        boolean oldOpen = this.open;
        this.open = open;
        propertyChangeSupport.firePropertyChange("open", oldOpen, open);
    }

    public boolean isOpen() {
        return open;
    }

    public void setDateFormat(DateFormat dateFormat) {
        DateFormat oldDateFormat = this.dateFormat;
        this.dateFormat = dateFormat;
        propertyChangeSupport.firePropertyChange("dateFormat", oldDateFormat, dateFormat);
    }

    public DateFormat getDateFormat() {
        return dateFormat;
    }
}
