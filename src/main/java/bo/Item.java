package bo;

import db.ItemDB;

import java.util.Collection;

/**
 * A representation of an item
 */
public class Item {
    private String name;
    private String desc;
    private int id;
    private String category;

    private int quantity;


    static public Collection searchItems(String group) {
        return ItemDB.searchItem(group);
    }

    static public Item getItem(int id) { return ItemDB.getItem(id);}


    protected Item(int id, String name, String desc, String category, int quantity) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.category = category;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
