package bo;

import ui.ItemInfo;
import ui.OrderInfo;
import ui.ShoppingCartInfo;
import ui.UserInfo;

import java.util.ArrayList;
import java.util.List;

public class OrderHandler {
    public static OrderInfo getOrder(String username) {
        Order order = Order.getShoppingCart(username);
        return new OrderInfo(order.getId(), order.getUser(), order.getItems());
    }

    public static boolean insertOrder(String username, List<Integer> items) {
        return Order.addOrder(username, items);
    }
}
