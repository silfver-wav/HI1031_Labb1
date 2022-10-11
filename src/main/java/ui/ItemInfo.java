package ui;

/**
 * A representation of an item information
 */
public class ItemInfo {

    private int id;
    private String name;
    private String description;
    private String category;
    private int quantity;

    public ItemInfo(int id, String name, String description, String category, int quantity) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.category = category;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
    public boolean inStock() {
        return quantity > 0;
    }
}
