package TomatoFoodDeliveryApp.factories;

import java.util.*;

import TomatoFoodDeliveryApp.models.Cart;
import TomatoFoodDeliveryApp.models.MenuItem;
import TomatoFoodDeliveryApp.models.Order;
import TomatoFoodDeliveryApp.models.Restuarent;
import TomatoFoodDeliveryApp.models.User;
import TomatoFoodDeliveryApp.strategies.PaymentStrategy;


public interface OrderFactory {
    Order createOrder(
        User user, 
        Cart cart, 
        Restuarent restuarent, 
        List<MenuItem> menuItems, 
        PaymentStrategy paymentStrategy,
        double totalCost,
        String orderType
        );
}
