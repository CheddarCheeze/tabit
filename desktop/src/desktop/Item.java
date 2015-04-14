package desktop;

import java.util.ArrayList;
/**
 *
 * @author Nicolas Nunez
 */

public class Item {
    private String name;
    private int num;
    private int quantity;
    private double price;
    private String modifier;
    Item(){
        this("", -1, -1, 0);
    }
    Item(String name, int num, int quantity, double price){
        this.name = name;
        this.num = num;
        this.quantity = quantity;
        this.price = price;
        this.modifier = null;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public void setNumber(int num){
        this.num = num;
    }
    
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }
    
    public void setPrice(double price){
        this.price = price;
    }
    
    public void setModifier(String mod){
        this.modifier = mod;
    }
    
    public String getName(){
        return name;
    }
    
    public int getNumber(){
        return num;
    }
    
    public int getQuantity(){
        return quantity;
    }
    
    public double getPrice(){
        return price;
    }
    
    public String getModifier(){
        return modifier;
    }
    

    @Override
    public String toString(){
        if(modifier != null){
            return "|Item: " + name + " |ItemNum: " + num + " |Quantity: " + quantity + " |PriceItem: " + price + "\n Modifier: " + modifier + "\n";
        }else{
            return "|Item: " + name + " |ItemNum: " + num + " |Quantity: " + quantity + " |PriceItem: " + price + "\n";
        }
    }
    
 /*
  * Main method is for testing purposes only
  */
    public static void main(String[] args){
        ArrayList<Item> order = new ArrayList<>();
        Item item = new Item("Taco", 1, 3, 1.35);
        item.modifier = "No Cheese";
        order.add(item);
        order.add(new Item("Taco", 1, 3, 1.35));
        order.add(new Item("Quesadilla", 2, 3, 4.35));
        order.add(new Item("Torta", 3, 3, 5.35));
        order.add(new Item("Gordita", 4, 3, 2.35));
//            System.out.println(order.toString());
            System.out.println(order.get(0).toString());
            String temp = order.get(1).name;
            System.out.println(temp);
    }
}
