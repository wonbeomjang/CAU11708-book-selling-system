package Layout;

import DataUtils.User.SearchUser;
import Layout.DeleteBook.DeleteBookListPanel;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class ExampleFrame extends JFrame implements Observer {
    public ExampleFrame() {
        SearchUser searchUser = new SearchUser();
        setLayout(new BorderLayout());
        add(new DeleteBookListPanel(searchUser.search("asdfs")[0]));

        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void update(Observable o, Object arg) {
    }
}
