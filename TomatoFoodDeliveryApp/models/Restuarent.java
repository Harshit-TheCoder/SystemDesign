package TomatoFoodDeliveryApp.models;

import java.util.*;

public class Restuarent {
    private static int nextRestuarentId = 0;
    private int restuarentId;
    private String name;
    private String location;
    private List<MenuItem> menu = new ArrayList<>();

    public Restuarent(String name, String location){
        this.name = name;
        this.location = location;
        this.restuarentId = ++nextRestuarentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String n) {
        name = n;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String loc) {
        location = loc;
    }

    public void addMenuItem(MenuItem item) {
        menu.add(item);
    }

    public List<MenuItem> getMenu() {
        return menu;
    }
}
