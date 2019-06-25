package users;

import items.Item;

public class User {
    private String name;
    private String surname;
    private String email;
    private String password;
    private UserType userType;
    private Item[] itemsBorrowed = new Item[3];

    public User(String name, String surname, String email, String password, UserType userType) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.userType = userType;
    }

    public boolean borrowItem (Item item) {
        for (int i = 0; i < itemsBorrowed.length; i ++) {
            if (itemsBorrowed[i] == null) {
                itemsBorrowed[i] = item;
                return true;
            }
        }
        return false;
    }

    public Item[] getItemsBorrowed() {
        return itemsBorrowed;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public UserType getUserType() {
        return userType;
    }
}
