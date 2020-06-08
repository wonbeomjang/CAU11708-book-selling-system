import DataUtils.Book.BookSaleList;
import DataUtils.User.UserList;
import Layout.ExampleFrame;

public class Main {
    public static void main(String[] args) {
        UserList userList = UserList.getInstance();
        BookSaleList bookSaleList = BookSaleList.getInstance();

        userList.init("UserTest.txt");
        bookSaleList.init("BookTest.txt", userList);

        new ExampleFrame();
    }
}
