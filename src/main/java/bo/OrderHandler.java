package bo;

import ui.OrderInfo;
import java.util.List;

/**
 * A representation of an order handler
 */
public class OrderHandler {
    public static OrderInfo getOrder(String username) {
        Order order = Order.getShoppingCart(username);
        return new OrderInfo(order.getId(), order.getUser(), order.getItems());
    }

    public static boolean insertOrder(String username, List<Integer> items) {
        return Order.addOrder(username, items);
    }
}
