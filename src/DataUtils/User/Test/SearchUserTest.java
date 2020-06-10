package DataUtils.User.Test;

import DataUtils.User.EndUser;
import DataUtils.User.SearchUser;
import DataUtils.User.User;
import DataUtils.User.UserList;
import Utils.SetUp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SearchUserTest {
    UserList userList;
    SearchUser searchUser;
    User user1, user2;
    int wonbeomLen;
    int userLen;

    @BeforeEach
    void setUp() {
        SetUp.setup();
        userList = UserList.getInstance();

        searchUser = new SearchUser();

        wonbeomLen = searchUser.search("wonbeomjang").length;
        userLen = searchUser.search().length;

        user1 = new EndUser("wonbeomjang", "20182592", "장원범", "01037937352", "jtiger958" );
        user2 = new EndUser("wonbeom", "20182592", "장원범", "jtiger958", "01037937352");

        userList.addUser(user1);
        userList.addUser(user2);
    }

    @Test
    void search() {
        assertEquals(wonbeomLen + 1, searchUser.search("wonbeomjang").length);
        assertEquals(userLen + 2, searchUser.search().length);
    }
}