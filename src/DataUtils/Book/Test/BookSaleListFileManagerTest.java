package DataUtils.Book.Test;

import DataUtils.Book.Book;
import DataUtils.Book.BookSaleList;
import DataUtils.Book.BookSaleListFileManager;
import DataUtils.User.UserList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BookSaleListFileManagerTest {
    BookSaleListFileManager bookSaleListFileManager;
    UserList userList;
    String userFileName, bookFileName;

    @BeforeEach
    void setUp() throws IOException {
        userFileName = "UserTest.txt";
        bookFileName = "BookTest.txt";

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File(userFileName)));
        bufferedWriter.write("asdf:asdf:asdf:sdfa:asdf:Activate\n");
        bufferedWriter.write("asddf:asdf:asdf:sdfa:asdf:Deactivate\n");
        bufferedWriter.write("asddf:asdf:asdf:sdfa:asdf:Deleted\n");
        bufferedWriter.write("asdfs:asdf\n");
        bufferedWriter.close();

        bufferedWriter = new BufferedWriter(new FileWriter(new File(bookFileName)));
        bufferedWriter.write("asdf:123:18:asdf:sdfa:12:Good:asdfs\n");
        bufferedWriter.write("asdf:123:18:asdf:sdfa:12:Fair:asdfs\n");
        bufferedWriter.write("asdf:123:18:asdf:sdfa:12:Excellent:asdfs\n");
        bufferedWriter.close();

        userList = UserList.getInstance();
        userList.init(userFileName);
        bookSaleListFileManager = new BookSaleListFileManager(bookFileName, userList);


    }

    @Test
    void readData() throws IOException {
        ArrayList<Book> userList = bookSaleListFileManager.readData();
        assertEquals(3, userList.size());
    }

    @Test
    void saveData() throws IOException {
        ArrayList<Book> bookOnSaleArrayList;
        BookSaleList bookSaleList = BookSaleList.getInstance();
        bookSaleList.init(bookFileName, userList);
        bookSaleList.saveData();
        bookOnSaleArrayList = bookSaleListFileManager.readData();
        assertEquals(3, bookOnSaleArrayList.size());
    }
}