package DataUtils.User.Test;

import DataUtils.User.EndUser;
import DataUtils.User.SearchUser;
import DataUtils.User.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SearchUserTest {
    UserList userList;
    SearchUser searchUser;
    User user1, user2;

    @BeforeEach
    void setUp() {
        userList = new UserList("test.txt");
        searchUser = new SearchUser(userList);
        user1 = new EndUser("wonbeomjang", "20182592", "장원범", "jtiger958", "01037937352");
        user2 = new EndUser("wonbeom", "20182592", "장원범", "jtiger958", "01037937352");

        userList.addUser(user1);
        userList.addUser(user2);
    }

    @Test
    void search() {
        assertEquals(1, searchUser.search("wonbeomjang").length);
        assertEquals(2, searchUser.search().length);
    }

    @Test
    void getInfo() {
        assertEquals(2, searchUser.search().length);
        String[] strings = searchUser.getInfo();
        assertEquals(2, strings.length);
    }
}