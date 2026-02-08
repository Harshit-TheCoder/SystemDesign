package TomatoFoodDeliveryApp.managers;


import java.util.*;
import TomatoFoodDeliveryApp.models.Restuarent;

public class RestuarentManager {
    private List<Restuarent> restuarents = new ArrayList<>();
    private static RestuarentManager instance = null;

    private RestuarentManager(){

    }

    public static RestuarentManager getInstance(){
        if(instance == null){
            instance = new RestuarentManager();
        }
        return instance;
    }

    public void addRestuarent(Restuarent r){
        restuarents.add(r);
    }

    public List<Restuarent> searchByLocation(String location){
        List<Restuarent> result = new ArrayList<>();
        location = location.toLowerCase();
        for(Restuarent r: restuarents){
            String rl = r.getLocation().toLowerCase();
            if(rl.equals(location)){
                result.add(r);
            }
        }

        return result;
    }
}
