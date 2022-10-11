package ui;

import java.util.List;

public class OrderInfo {

    private int id;
    private String username;
    private List<Integer> itemIds;

    public OrderInfo(int id, String username, List<Integer> itemIds) {
        this.id = id;
        this.username = username;
        this.itemIds = itemIds;
    }

    public int getId() {
        return id;
    }

    public String getUser() {
        return username;
    }

    public void setUser(String user) {
        this.username = user;
    }

    public List<Integer> getItemIds() {
        return itemIds;
    }

    public void setItemIds(List<Integer> itemIds) {
        this.itemIds = itemIds;
    }
}
