package TomatoFoodDeliveryApp.models;
import java.util.*;

public class Cart {
    private Restuarent restuarent;
    private List<MenuItem> items = new ArrayList<>();

    public Cart(){
        restuarent = null;
    }

    public void addItem(MenuItem item){
        if(restuarent == null){
            System.err.println("Cart: Set a restuarent before adding items");
            return;
        }
        items.add(item);
    }

    public double getTotalCost(){
        double sum = 0;
        for(MenuItem it: items){
            sum += it.getPrice();
        }
        return sum;
    }

    public boolean isEmpty(){
        return restuarent == null || items.isEmpty();
    }

    public void clear(){
        items.clear();
        restuarent = null;
    }

    public void setRestuarent(Restuarent r){
        restuarent = r;
    }

    public Restuarent getRestuarent(){
        return restuarent;
    }

    public List<MenuItem> getItems(){
        return items;
    }
}
