package bo;

import db.ShoppingCartDB;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private int id;
    private User user;
    private List<Item> items;

    static public ShoppingCart getShoppingCart(int id) { return ShoppingCartDB.getShoppingCart(id); }

    protected ShoppingCart(int id, String username, List<Item> items) {
        this.id = id;
        this.user = new User(username);
        this.items = items;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
