package bo;

import db.OrderDB;

import java.util.List;

/**
 * A representation of an order
 */
public class Order {
    private int id;
    private String username;
    private List<Integer> items;

    static public Order getOrder(String username) { return OrderDB.getOrderByUsername(username); }
    static public boolean addOrder(String username, List<Integer> items) {return OrderDB.addOrderToDatabase(username, items); }

    protected Order(int id, String username, List<Integer> items) {
        this.id = id;
        this.username = username;
        this.items = items;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return username;
    }

    public void setUser(String user) {
        this.username = user;
    }

    public List<Integer> getItems() {
        return items;
    }

    public void setItems(List<Integer> items) {
        this.items = items;
    }
}
