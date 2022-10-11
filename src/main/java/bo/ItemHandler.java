package bo;

import ui.ItemInfo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class ItemHandler {
    public static List<ItemInfo> getItems(String group) {
        Collection c = Item.searchItems(group);
        ArrayList<ItemInfo> items = new ArrayList<>();
        for(Iterator it = c.iterator(); it.hasNext();) {
            Item item = (Item) it.next();
            items.add(new ItemInfo(item.getId(), item.getName(),item.getDesc(),null,item.getQuantity()));
        }
        return items;
    }

    public static ItemInfo getItem(int itemId) {
        Item item = Item.getItem(itemId);
        return new ItemInfo(item.getId(), item.getName(), item.getDesc(),null, item.getQuantity());
    }
}
