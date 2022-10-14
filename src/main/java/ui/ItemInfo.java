package ui;

/**
 * A representation of an item information
 */
public class ItemInfo {

    private int id;
    private String name;
    private String description;
    private String category;
    private boolean inStorage;

    public ItemInfo(int id, String name, String description, String category, boolean inStorage) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.category = category;
        this.inStorage = inStorage;
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

    public boolean inStock() {
        return inStorage;
    }
}
