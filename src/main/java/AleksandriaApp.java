import items.Item;
import users.User;

public class AleksandriaApp {
    private UserManager userManager = new UserManager();
    private ItemManager itemManager = new ItemManager();
    private User user = null;

    public boolean login (String email, String password){
        if (getUser() != null) return false;

        User user = userManager.getUserByEmail(email);
        if (user != null) {
            if (user.getPassword().equals(password)) {
                this.user = user;
                return true;
            }
        }
        return false;
    }

    public boolean addUser(User user) {
        return userManager.addUser(user);
    }

    public boolean addItem (Item item) {
        return itemManager.addItem(item);
    }


    public UserManager getUserManager() {
        return userManager;
    }

    public ItemManager getItemManager() {
        return itemManager;
    }

    public User getUser() {
        return user;
    }
}
