import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import users.User;
import users.UserType;

import static org.junit.jupiter.api.Assertions.*;

class AleksandriaAppTest {
    AleksandriaApp aleksandriaApp;

    @BeforeEach
    public void setUp() {
        aleksandriaApp = new AleksandriaApp();
    }

    @Test
    void loginShouldLogin() {
        //given
        User user = new User ("name", "surname", "email@email.com", "pass", UserType.CLIENT);
        aleksandriaApp.addUser(user);

        //when
        boolean result = aleksandriaApp.login("email@email.com", "pass");

        //then
        assertTrue(result);
        assertEquals(user, aleksandriaApp.getUser());
    }

    @Test
    void loginShouldNotLoginWithWrongEmail() {
        //given
        User user = new User ("name", "surname", "email@email.com", "pass", UserType.CLIENT);
        aleksandriaApp.addUser(user);

        //when
        boolean result = aleksandriaApp.login("email@email", "pass");

        //then
        assertFalse(result);
        assertEquals(null, aleksandriaApp.getUser());
    }

    @Test
    void loginShouldNotLoginWithWrongPassword() {
        //given
        User user = new User ("name", "surname", "email@email.com", "pass", UserType.CLIENT);
        aleksandriaApp.addUser(user);

        //when
        boolean result = aleksandriaApp.login("email@email.com", "wrongpassword");

        //then
        assertFalse(result);
        assertEquals(null, aleksandriaApp.getUser());
    }

    @Test
    void loginShouldNotLoginWhenUserIsLoggedIn() {
        //given
        User user = new User ("name", "surname", "email@email.com", "pass", UserType.CLIENT);
        User user2 = new User ("name", "surname", "second@email.com", "secondpass", UserType.CLIENT);
        aleksandriaApp.addUser(user);
        aleksandriaApp.addUser(user2);

        //when
        boolean result1 = aleksandriaApp.login("email@email.com", "pass");
        boolean result2 = aleksandriaApp.login("second@email.com", "secondpass");

        //then
        assertTrue(result1);
        assertFalse(result2);
        assertEquals(user, aleksandriaApp.getUser());
    }

}