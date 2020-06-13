package UserTest;

import com.wonbeomjang.bookselling.DataUtils.User.*;
import com.wonbeomjang.bookselling.Utils.SHA256;
import com.wonbeomjang.bookselling.Utils.SetUp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SignInTest {
    SignIn signIn;
    SignUp signUp;
    UserList userList;
    User user1, user2;

    @BeforeEach
    void setUp() {
        SetUp.setup(true);
        userList = UserList.getInstance();

        user1 = new User("wonbeomjang", SHA256.encryption("20182592"), "장원범", "01037937352", "jtiger958" );
        user2 = new User("wonbeom", SHA256.encryption("20182592"), "장원범", "jtiger958", "01037937352");

        userList.addUser(user1);
        userList.addUser(user2);

        userList.saveData();

        signIn = new SignIn();

    }

    @Test
    void signIn() {
        assertEquals(user1.getUsername(), signIn.signIn("wonbeomjang", "20182592").getUsername());
        assertEquals(user2.getUsername(), signIn.signIn("wonbeom", "20182592").getUsername());
        assertNull(signIn.signIn("wonbesom", "20182592"));
        assertNull(signIn.signIn("wonbeom", "201821592"));
        ((User)user2).setUserState(UserState.Deactivate);
        assertNull(signIn.signIn("wonbeom", "201825912"));
        ((User)user2).setUserState(UserState.Deleted);
        assertNull(signIn.signIn("wonbeom", "201812592"));
    }
}