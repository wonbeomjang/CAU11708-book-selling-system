package UserTest;

import com.wonbeomjang.bookselling.DataUtils.User.User;
import com.wonbeomjang.bookselling.DataUtils.User.UserList;
import com.wonbeomjang.bookselling.Utils.SetUp;
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
        SetUp.setup(true);

        fileName = SetUp.userDataFile;
        userList = UserList.getInstance();

        user1 = new User("wonbeom", "3d4574a464a47ff83f69028d2354771ad371bde7c8a83675feb070f5cbd01a66", "장원범", "01037937352", "jtiger958" );
        numUsers = 0;

        userList.addUser(user1);
    }

    @Test
    void addUser() {
        numUsers = userList.getNumUsers();

        user2 = new User("wonbeom", "3d4574a464a47ff83f69028d2354771ad371bde7c8a83675feb070f5cbd01a66", "장원범", "jtiger958", "01037937352");
        userList.addUser(user2);

        assertEquals(userList.getNumUsers(),numUsers + 1);
        assertTrue(userList.contain(user2));
    }

    @Test
    void deleteUser() {
        numUsers = userList.getNumUsers();

        userList.deleteUser(user1);
        assertEquals(numUsers - 1, userList.getNumUsers());
        assertFalse(userList.contain(user1));
    }
}