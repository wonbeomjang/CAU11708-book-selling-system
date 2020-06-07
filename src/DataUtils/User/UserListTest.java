package DataUtils.User;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserListTest {
    UserList userList;
    User user;

    @BeforeEach
    void setUp() {
        userList = new UserList();
        user = new EndUser("wonbeomjang", "20182592", "장원범", "jtiger958", "01037937352");
        userList.addUser(user);
    }

    @Test
    void addUser() {

    }

    @Test
    void deleteUser() {
    }
}