package bo;

import ui.ItemInfo;
import ui.ShoppingCartInfo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class ShoppingCartHandler {
    public static ShoppingCartInfo getShoppingCart(int id) {
        ShoppingCart cart = ShoppingCart.getShoppingCart(id);
        ShoppingCartInfo cartInfo = new ShoppingCartInfo(cart.getUser(), cart.getItems());

        return cartInfo;
    }
}
