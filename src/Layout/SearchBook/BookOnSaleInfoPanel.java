package Layout.SearchBook;

import DataUtils.Book.BookOnSale;

import javax.swing.*;
import java.awt.*;

public class BookOnSaleInfoPanel extends JPanel {
    JCheckBox buyChk;
    BookOnSale bookOnSale;
    public BookOnSaleInfoPanel(BookOnSale book) {
        bookOnSale = book;
        buyChk = new JCheckBox();

        setLayout(new GridLayout(1, 8));

        add(buyChk);
        add(new JLabel(book.getTitle()));
        add(new JLabel(book.getIsbn()));
        add(new JLabel(book.getPublic_year()));
        add(new JLabel(book.getPublisher()));
        add(new JLabel(book.getAuthor()));
        add(new JLabel(book.getPrice()));
        add(new JLabel(book.getCondition().toString()));
        add(new JLabel(book.getOwner().getUsername()));
    }

    public JCheckBox getBuyChk() {
        return buyChk;
    }

    public boolean isChecked() {
        return buyChk.isSelected();
    }

    public BookOnSale getBook() {
        return bookOnSale;
    }
}
