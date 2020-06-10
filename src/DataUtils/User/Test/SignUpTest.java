package DataUtils.User.Test;

import DataUtils.User.*;
import Utils.SetUp;
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
        SetUp.setup();

        userList = UserList.getInstance();

        user = new EndUser("wonbeomjang", "20182592", "장원범", "01037937352", "jtiger958" );
        signUp = new SignUp();
        signIn = new SignIn();

        userList.addUser(user);
    }

    @Test
    void checkUniqueUserName() {
        assertFalse(signUp.checkUniqueUserName("wonbeomjang"));
        assertTrue(signUp.checkUniqueUserName("###########"));
    }

    @Test
    void signUp() {
        numUsers = userList.getNumUsers();
        signUp.signUp("wonbeom", "20182592", "장원범", "jtiger958", "01037937352");
        if(signUp.checkUniqueUserName("wonbeom"))
            assertEquals(numUsers + 1, userList.getNumUsers());
        else
            assertNotEquals(numUsers + 1, userList.getNumUsers());
        assertNotNull(signIn.signIn("wonbeom", "20182592"));
        assertFalse(signUp.signUp("wonbeomjang", "20182592", "장원범", "jtiger958", "01037937352"));
    }

    @Test
    void update() {

    }
}