package DataUtils.User.Test;

import DataUtils.User.EndUser;
import DataUtils.User.User;
import DataUtils.User.UserList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserListTest {
    UserList userList;
    User user1;
    User user2;
    int numUsers;
    String fileName;

    @BeforeEach
    void setUp() {
        fileName = "UserTest.txt";
        userList = new UserList(fileName);
        user1 = new EndUser("wonbeomjang", "20182592", "장원범", "jtiger958", "01037937352");
        numUsers = 0;

        userList.addUser(user1);
    }

    @Test
    void addUser() {
        numUsers = userList.getNumUsers();

        user2 = new EndUser("wonbeom", "20182592", "장원범", "jtiger958", "01037937352");
        userList.addUser(user2);

        assertEquals(userList.getNumUsers(),numUsers + 1);
        assertTrue(userList.contain(user2));
    }

    @Test
    void deleteUser() {
        numUsers = userList.getNumUsers();

        userList.deleteUser(user1);
        assertEquals(numUsers - 1, userList.getNumUsers());
        assertFalse(userList.contain(user2));
    }
}