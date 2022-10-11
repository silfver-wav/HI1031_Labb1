package ui;

import bo.Item;
import bo.User;

import java.util.List;

/**
 * A representation of a shopping cart information
 */
public class ShoppingCartInfo {
    private UserInfo user;
    private List<ItemInfo> items;

    public ShoppingCartInfo(UserInfo user, List<ItemInfo> items) {
        this.user = user;
        this.items = items;
    }

    public UserInfo getUser() {
        return user;
    }

    public void setUser(UserInfo user) {
        this.user = user;
    }

    public List<ItemInfo> getItems() {
        return items;
    }

    public void setItems(List<ItemInfo> items) {
        this.items = items;
    }

    public void addItem(ItemInfo item) {
        this.items.add(item);
    }
}
