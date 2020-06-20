package UserTest;

import com.wonbeomjang.bookselling.DataUtils.User.*;
import com.wonbeomjang.bookselling.Utils.SetUp;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ManageUserTest {
    UserList userList;
    ManageUser manageUser;
    User user1, user2, user3;
    UserState userState = UserState.Deactivate;

    @BeforeEach
    void setUp() {
        SetUp.setup(true);
        userList = UserList.getInstance();

        manageUser = new ManageUser();
        user1 = new User("wonbeomjangs", "201s82592", "장원범", "jtiger958", "01037937352");
        user2 = new User("wonbeom", "3d4574a464a47ff83f69028d2354771ad371bde7c8a83675feb070f5cbd01a66", "장원범", "jtiger958", "01037937352");
        user3 = new User("wonbeoms", "3d4574a464a47ff83f69028d2354771ad371bde7c8a83675feb070f5cbd01a66", "장원범", "jtiger958", "01037937352", UserRank.Admin);


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
        assertFalse(userList.contain(user2));
        assertFalse(manageUser.delete(user3));
    }

}