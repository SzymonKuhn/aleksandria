import users.User;

import java.util.ArrayList;
import java.util.List;

public class UserManager {
    private List<User> userList = new ArrayList<>();

    public boolean addUser (User userToAdd) {
        if (getUserByEmail(userToAdd.getEmail()) != null) return false;
        userList.add(userToAdd);
        return true;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void clearUserList() {
        userList.removeAll(userList);
    }

    public boolean deleteUserByEmail (String email) {
        if (userList.isEmpty()) return false;
        User userToDelete = getUserByEmail(email);
        if (userToDelete == null) return false;
        return userList.remove(userToDelete);
    }

    public User getUserByEmail (String email) {
        if (userList.isEmpty()) return null;
        for (User user : userList) {
            if (user.getEmail().equals(email)) return user;
        }
        return null;
    }
}
