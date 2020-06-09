package DataUtils.User.Test;

import DataUtils.User.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SignUpTest {
    UserList userList;
    SignUp signUp;
    SignIn signIn;
    User user;
    int numUsers;

    @BeforeEach
    void setUp() {
        String fileName = "UserTest.txt";
        userList = UserList.getInstance();
        userList.init(fileName);

        user = new EndUser("wonbeomjang", "20182592", "장원범", "jtiger958", "01037937352");
        signUp = new SignUp();
        signIn = new SignIn();

        userList.addUser(user);
        signUp.setUsername("wonbeomjang");
        signUp.setPassword("20182592");
        signUp.setName("장원범");
        signUp.setEmail("jtiger958");
        signUp.setPhoneNumber("01037937352");
    }

    @Test
    void checkUniqueUserName() {
        assertFalse(signUp.checkUniqueUserName("wonbeomjang"));
        assertTrue(signUp.checkUniqueUserName("wonbeom"));
    }

    @Test
    void signUp() {
        numUsers = userList.getNumUsers();
        signUp.signUp("wonbeom", "20182592", "장원범", "jtiger958", "01037937352");
        assertEquals(numUsers + 1, userList.getNumUsers());
        assertNotNull(signIn.signIn("wonbeom", "20182592"));
        assertFalse(signUp.signUp("wonbeomjang", "20182592", "장원범", "jtiger958", "01037937352"));
    }

    @Test
    void update() {

    }
}