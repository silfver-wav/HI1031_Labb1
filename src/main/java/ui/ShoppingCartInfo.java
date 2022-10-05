package ui;

import bo.Item;
import bo.User;

import java.util.List;

public class ShoppingCartInfo {
    private User user;
    private List<Item> items;

    public ShoppingCartInfo(User user, List<Item> items) {
        this.user = user;
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
