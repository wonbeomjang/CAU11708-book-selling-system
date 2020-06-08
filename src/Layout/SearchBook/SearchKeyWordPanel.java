package Layout.SearchBook;

import javax.swing.*;
import java.awt.*;

public class SearchKeyWordPanel extends JPanel {
    JTextField keyText;
    JButton searchBtn;
    JComboBox<String> searchKeyType;
    String[] searchKeyTypeStr = {"Title", "ISBN", "Author", "Username"};
    public SearchKeyWordPanel() {
        keyText = new JTextField();
        searchKeyType = new JComboBox<>(searchKeyTypeStr);
        searchBtn = new JButton("검색");

        setLayout(new BorderLayout());

        add(searchKeyType, BorderLayout.WEST);
        add(keyText, BorderLayout.CENTER);
        add(searchBtn, BorderLayout.EAST);

    }
}
