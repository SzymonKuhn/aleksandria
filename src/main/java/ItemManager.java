import items.Item;
import users.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ItemManager {
    private List<Item> itemList = new ArrayList<>();

    public boolean addItem (Item itemToAdd){
        itemList.add(itemToAdd);
        return true;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public List<Item> searchItemByTitle(String content) {
//        if (content.equals("")) return Collections.emptyList();
        if (itemList.isEmpty()) return Collections.emptyList();
        return itemList.stream()
                .filter(i -> i.titleContains(content))
                .collect(Collectors.toList());
    }

    public void clearItemList() {
        itemList.removeAll(itemList);
    }

}
