package DataUtils.User.Test;

import DataUtils.User.*;
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
        String fileName = "UserTest.txt";
        userList = UserList.getInstance();
        userList.init(fileName);

        manageUser = new ManageUser();
        user1 = new EndUser("wonbeomjang", "20182592", "장원범", "jtiger958", "01037937352");
        user2 = new EndUser("wonbeom", "20182592", "장원범", "jtiger958", "01037937352");
        user3 = new Admin("asdf", "Aasdf");

        userList.addUser(user1);
        userList.addUser(user2);
        userList.addUser(user3);
    }

    @Test
    void change() {
        assertTrue(manageUser.change(user1, userState));
        assertEquals(((EndUser)user1).getUserState(), userState);
        assertFalse(manageUser.change(user3, userState));
    }

    @Test
    void delete() {
        assertTrue(manageUser.delete(user2));
        assertEquals(((EndUser)user2).getUserState(), UserState.Deleted);
        assertFalse(manageUser.delete(user3));
    }

}