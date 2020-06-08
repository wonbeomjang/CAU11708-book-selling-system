package DataUtils.User.Test;

import DataUtils.User.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SignInTest {
    SignIn signIn;
    UserList userList;
    User user1, user2;

    @BeforeEach
    void setUp() {
        String fileName = "UserTest.txt";
        userList = UserList.getInstance();
        userList.init(fileName);

        user1 = new EndUser("wonbeomjang", "20182592", "장원범", "jtiger958", "01037937352");
        user2 = new EndUser("wonbeom", "20182592", "장원범", "jtiger958", "01037937352");
        signIn = new SignIn(userList);

        userList.addUser(user1);
        userList.addUser(user2);
    }

    @Test
    void signIn() {
        assertEquals(user1, signIn.signIn("wonbeomjang", "20182592"));
        assertEquals(user2, signIn.signIn("wonbeom", "20182592"));
        assertNull(signIn.signIn("wonbesom", "20182592"));
        assertNull(signIn.signIn("wonbeom", "201821592"));
        ((EndUser)user2).setUserState(UserState.Deactivate);
        assertNull(signIn.signIn("wonbeom", "20182592"));
        ((EndUser)user2).setUserState(UserState.Deleted);
        assertNull(signIn.signIn("wonbeom", "20182592"));
    }
}