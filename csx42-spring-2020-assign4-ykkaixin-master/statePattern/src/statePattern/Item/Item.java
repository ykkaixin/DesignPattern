package statePattern.Item;

import java.util.HashMap;

public class Item {
    HashMap<String, String> itemMap;

    public Item() {
        this.itemMap = new HashMap<>();
    }

    public void addItem(String name, String type) {
        this.itemMap.put(name, type);
    }

    public String getTheType(String name) {
        if(!itemMap.containsKey(name)) return "do not have this item";
        return itemMap.get(name);
    }
}