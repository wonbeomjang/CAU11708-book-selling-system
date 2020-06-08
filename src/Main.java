import DataUtils.Book.BookSaleList;
import DataUtils.User.UserList;
import Layout.MainFrame;

public class Main {
    public static void main(String[] args) {
        UserList userList = UserList.getInstance();
        BookSaleList bookSaleList = BookSaleList.getInstance();

        userList.init("UserTest.txt");
        bookSaleList.init("BookTest.txt", userList);

        new MainFrame();

        System.out.println("::::".split(":").length);
    }
}
