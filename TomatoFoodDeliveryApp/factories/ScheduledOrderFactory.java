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


public class ScheduledOrderFactory implements OrderFactory {
    private String scheduleTime;

    public ScheduledOrderFactory(String scheduleTime) {
        this.scheduleTime = scheduleTime;
    }

    @Override
    public Order createOrder(User user, Cart cart, Restuarent restaurant, List<MenuItem> menuItems,
                             PaymentStrategy paymentStrategy, double totalCost, String orderType) {
        Order order = null;

        if (orderType.equals("Delivery")) {
            DeliveryOrder deliveryOrder = new DeliveryOrder();
            deliveryOrder.setUserAddress(user.getAddress());
            order = deliveryOrder;
        } else {
            PickupOrder pickupOrder = new PickupOrder();
            pickupOrder.setRestaurantAddress(restaurant.getLocation());
            order = pickupOrder;
        }

        order.setUser(user);
        order.setRestuarent(restaurant);
        order.setItems(menuItems);
        order.setPaymentStrategy(paymentStrategy);
        order.setScheduled(scheduleTime);
        order.setTotal(totalCost);
        return order;
    }

}
