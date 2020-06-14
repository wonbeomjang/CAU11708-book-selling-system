package UserTest;

import com.wonbeomjang.bookselling.DataUtils.User.SearchUser;
import com.wonbeomjang.bookselling.DataUtils.User.User;
import com.wonbeomjang.bookselling.DataUtils.User.UserList;
import com.wonbeomjang.bookselling.Utils.SetUp;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SearchUserTest {
    static UserList userList;
    static SearchUser searchUser;
    static User user1, user2;
    static int wonbeomLen;
    static int userLen;

    @BeforeAll
    static void setUp() {
        SetUp.setup(true);
        userList = UserList.getInstance();

        searchUser = new SearchUser();

        wonbeomLen = searchUser.search("wonbeomjang").length;
        userLen = searchUser.search().length;

        user1 = new User("wonbeomjang", "3d4574a464a47ff83f69028d2354771ad371bde7c8a83675feb070f5cbd01a66", "장원범", "01037937352", "jtiger958" );
        user2 = new User("wonbeom", "3d4574a464a47ff83f69028d2354771ad371bde7c8a83675feb070f5cbd01a66", "장원범", "jtiger958", "01037937352");

        userList.addUser(user1);
        userList.addUser(user2);
    }

    @Test
    void search() {
        assertEquals(wonbeomLen + 1, searchUser.search("wonbeomjang").length);
        assertEquals(userLen + 2, searchUser.search().length);
    }
}