import items.Item;
import users.User;

import java.util.ArrayList;
import java.util.List;

public class AlexandriaLibrary {
    private List<User> userList = new ArrayList<>();
    private List<Item> itemList = new ArrayList<>();

    public void addUser (User userToAdd) {
        userList.add(userToAdd);
    }

    public void addItem (Item itemToAdd){
        itemList.add(itemToAdd);
    }

    public List<User> getUserList() {
        return userList;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public List<Item> searchByTitle (String content) { //napisać test
        List<Item> itemsFound = new ArrayList<>();
        for (Item existingItem : itemList) {
            if (existingItem.titleContains(content)) {
                itemsFound.add(existingItem);
            }
        }
        return itemsFound;
    }

    public void clearItemList() {
        itemList.removeAll(itemList);
    }

    public void clearUserList() {
        userList.removeAll(userList);
    }
}
