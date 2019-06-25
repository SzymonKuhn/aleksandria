import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import users.User;
import users.UserType;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class UserManagerTest {

    private UserManager userManager;

    @BeforeEach
    void setUp() {
        userManager = new UserManager();
    }

    @Test
    void addUser_should_add_users() {
        //Given
        User user = new User("username", "usersurname", "email@email.com", "pass", UserType.CLIENT);
        User user2 = new User("username", "usersurname", "second@email.com", "pass", UserType.CLIENT);

        //When
        userManager.addUser(user);
        userManager.addUser(user2);

        //Then
        assertEquals(2, userManager.getUserList().size());
        assertEquals(Arrays.asList(user, user2), userManager.getUserList());
    }

    @Test
    void addUser_should_not_add_users_with_same_emails() {
        //Given
        userManager.addUser(new User("username", "usersurname", "email@email.com", "pass", UserType.CLIENT));

        //When
        boolean result = userManager.addUser(new User("username", "usersurname", "email@email.com", "pass", UserType.CLIENT));

        //Then
        assertEquals(1, userManager.getUserList().size());
        assertFalse(result);
    }

    @Test
    void clearShouldClearUserListWhenUserListIsNotEmpty() {
        //Given
        userManager.addUser(new User("username", "usersurname", "email@email.com", "pass", UserType.CLIENT));
        userManager.addUser(new User("username", "usersurname", "email@email.com", "pass", UserType.CLIENT));

        //When
        userManager.clearUserList();

        //Then
        assertEquals(0, userManager.getUserList().size());
    }

    @Test
    void clearShouldClearUserListWhenUserListIsEmpty() {
        //Given

        //When
        userManager.clearUserList();

        //Then
        assertEquals(0, userManager.getUserList().size());
    }

    @Test
    void deleteUserByEmailShouldNotDeleteWhenUserListIsEmpty() {
        //Given

        //When
        boolean result = userManager.deleteUserByEmail("email@email.com");

        //Then
        assertEquals(0, userManager.getUserList().size());
        assertFalse(result);
    }

    @Test
    void deleteUserByEmailShouldDeleteUser() {
        //Given
        userManager.addUser(new User("name", "surname", "jj@em.com", "pass", UserType.CLIENT));
        userManager.addUser(new User("name", "surname", "email@email.com", "pass", UserType.CLIENT));

        //When
        boolean result = userManager.deleteUserByEmail("email@email.com");

        //Then
        assertEquals(1, userManager.getUserList().size());
        assertTrue(result);
    }

    @Test
    void getUserByEmail() {
        //Given
        userManager.addUser(new User("name", "surname", "jj@em.com", "pass", UserType.CLIENT));
        User user = new User("name", "surname", "email@email.com", "pass", UserType.CLIENT);
        userManager.addUser(user);

        //When
        User result = userManager.getUserByEmail("email@email.com");

        //Then
        assertEquals(user, result);
    }
}