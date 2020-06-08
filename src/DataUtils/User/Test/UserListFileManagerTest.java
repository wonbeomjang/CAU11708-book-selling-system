package DataUtils.User.Test;

import DataUtils.User.User;
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
        fileName = "test.txt";
        userListFileManager = new UserListFileManager(fileName);
        BufferedWriter bufferedWriter = null;

        bufferedWriter = new BufferedWriter(new FileWriter(new File(fileName)));
        bufferedWriter.write("asdf:asdf:asdf:sdfa:asdf:Activate\n");
        bufferedWriter.write("asdfs:asdf\n");
        bufferedWriter.close();

    }

    @Test
    void readData() throws IOException {
        ArrayList<User> userList = userListFileManager.readData();
        assertEquals(2, userList.size());
    }

    @Test
    void saveData() throws IOException {
        ArrayList<User> userArrayList;
        UserList userList = new UserList(fileName);
        userList.saveData();
        userArrayList = userListFileManager.readData();
        assertEquals(2, userArrayList.size());
    }
}