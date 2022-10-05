package bo;

import db.ItemDB;

import java.util.Collection;

public class Item {
    private String name;
    private String desc;
    private int id;

    static public Collection searchItems(String group) {
        return ItemDB.searchItem(group);
    }

    protected Item(int id, String name, String desc) {
        this.id = id;
        this.name = name;
        this.desc = desc;
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
}
