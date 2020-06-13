package UserTest;

import com.wonbeomjang.bookselling.DataUtils.User.*;
import com.wonbeomjang.bookselling.Utils.SetUp;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ManageUserTest {
    static UserList userList;
    static ManageUser manageUser;
    static User user1, user2, user3;
    static UserState userState = UserState.Deactivate;

    @BeforeAll
    static void setUp() {
        SetUp.setup(true);
        userList = UserList.getInstance();

        manageUser = new ManageUser();
        user1 = new User("wonbeomjangs", "201s82592", "장원범", "jtiger958", "01037937352");
        user2 = new User("wonbeom", "20182592", "장원범", "jtiger958", "01037937352");
        user3 = new User("wonbeoms", "20182592", "장원범", "jtiger958", "01037937352", UserRank.Admin);


        userList.addUser(user1);
        userList.addUser(user2);
        userList.addUser(user3);
    }

    @Test
    void change() {
        assertTrue(manageUser.change(user1, userState));
        assertEquals((user1).getUserState(), userState);
        assertFalse(manageUser.change(user3, userState));
    }

    @Test
    void delete() {
        assertTrue(manageUser.delete(user2));
        assertEquals(user2.getUserState(), UserState.Deleted);
        assertFalse(manageUser.delete(user3));
    }

}