package mycomp.mobile;

import java.util.ArrayList;
import java.util.List;

public class Menus {
    private List s_menus = null;
    
    public Menus() {
        super();
    }
    
    public Menu[] getMenus() {
        Menu[] menus = null;
        s_menus = new ArrayList();
        s_menus.add(new Menu("Carne Asada", 11.99));
        s_menus.add(new Menu("De Camaron", 11.05));
        s_menus.add(new Menu("Bisteak A La Mexicana", 9.99));
        s_menus.add(new Menu("De Tilapia", 7.99));
        s_menus.add(new Menu("4 Tacos", 5.99));
        menus = (Menu[]) s_menus.toArray(new Menu[s_menus.size()]);
        return menus;
    }
}
