package Layout.SearchBook;

import javax.swing.*;
import java.awt.*;

public class BookInfoPanel extends JPanel {
    JCheckBox buyChk;
    public BookInfoPanel(String title, String isbn, String publicYear, String publisher, String author, String price,
                         String bookCondition, String username) {
        buyChk = new JCheckBox();

        setLayout(new GridLayout(1, 8));

        add(buyChk);
        add(new JLabel(title));
        add(new JLabel(isbn));
        add(new JLabel(publicYear));
        add(new JLabel(publisher));
        add(new JLabel(author));
        add(new JLabel(price));
        add(new JLabel(bookCondition));
        add(new JLabel(username));
    }

    public JCheckBox getBuyChk() {
        return buyChk;
    }

    public boolean isChecked() {
        return buyChk.isSelected();
    }
}
