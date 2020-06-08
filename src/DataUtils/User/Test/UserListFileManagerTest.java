package DataUtils.User.Test;

import DataUtils.User.User;
import DataUtils.User.UserList;
import DataUtils.User.UserListFileManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserListFileManagerTest {
    UserListFileManager userListFileManager;
    String fileName;

    @BeforeEach
    void setUp() throws IOException {
        fileName = "UserTest.txt";

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File(fileName)));
        bufferedWriter.write("asdf:asdf:asdf:sdfa:asdf:Activate\n");
        bufferedWriter.write("asddf:asdf:asdf:sdfa:asdf:Deactivate\n");
        bufferedWriter.write("asddf:asdf:asdf:sdfa:asdf:Deleted\n");
        bufferedWriter.write("asdfs:asdf\n");
        bufferedWriter.close();

        userListFileManager = new UserListFileManager(fileName);
    }

    @Test
    void readData() throws IOException {
        ArrayList<User> userList = userListFileManager.readData();
        assertEquals(3, userList.size());
    }

    @Test
    void saveData() throws IOException {
        ArrayList<User> userArrayList;
        UserList userList = UserList.getInstance();
        userList.init(fileName);
        userList.saveData();
        userArrayList = userListFileManager.readData();
        assertEquals(3, userArrayList.size());
    }
}