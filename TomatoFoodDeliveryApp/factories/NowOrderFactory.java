package TomatoFoodDeliveryApp.factories;

import java.util.*;

import TomatoFoodDeliveryApp.models.Cart;
import TomatoFoodDeliveryApp.models.DeliveryOrder;
import TomatoFoodDeliveryApp.models.MenuItem;
import TomatoFoodDeliveryApp.models.Order;
import TomatoFoodDeliveryApp.models.PickupOrder;
import TomatoFoodDeliveryApp.models.Restuarent;
import TomatoFoodDeliveryApp.models.User;
import TomatoFoodDeliveryApp.strategies.PaymentStrategy;
import TomatoFoodDeliveryApp.utils.TimeUtils;


public class NowOrderFactory implements OrderFactory{
    @Override
    public Order createOrder(User user, Cart cart, Restuarent restuarent, List<MenuItem> menuItems, 
        PaymentStrategy paymentStrategy, double totalCost, String orderType){

            Order order = null;

            if(orderType.equals("Delivery")){
                DeliveryOrder deliveryOrder = new DeliveryOrder();
                deliveryOrder.setUserAddress(user.getAddress());
                order = deliveryOrder;
            }
            else{
                PickupOrder pickupOrder = new PickupOrder();
                pickupOrder.setRestaurantAddress(restuarent.getLocation());
                order = pickupOrder;
            }

            order.setUser(user);
            order.setRestuarent(restuarent);
            order.setItems(menuItems);
            order.setPaymentStrategy(paymentStrategy);
            order.setScheduled(TimeUtils.getCurrentTime());
            order.setTotal(totalCost);
            return order;
    }
}
