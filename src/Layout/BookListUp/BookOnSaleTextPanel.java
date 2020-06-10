package Layout.BookListUp;

import DataUtils.Book.Book;
import DataUtils.Book.BookCondition;
import DataUtils.Book.BookOnSale;

import javax.swing.*;
import java.awt.*;

public class BookOnSaleTextPanel extends JPanel {
    BookOnSale bookOnSale;
    JTextField title;
    JLabel isbn;
    JTextField publicYear;
    JTextField publisher;
    JTextField author;
    JTextField price;
    JComboBox<BookCondition> condition;

    public BookOnSaleTextPanel(BookOnSale book) {
        bookOnSale = book;

        setLayout(new GridLayout(1, 7));

        title = new JTextField(book.getTitle());
        isbn = new JLabel(book.getIsbn());
        publicYear = new JTextField(book.getPublic_year());
        publisher = new JTextField(book.getPublisher());
        author = new JTextField(book.getAuthor());
        price = new JTextField(book.getPrice());
        condition = new JComboBox<>(BookCondition.values());
        condition.setSelectedItem(book.getCondition());

        add(title);
        add(isbn);
        add(publicYear);
        add(publisher);
        add(author);
        add(price);
        add(condition);
        add(new JLabel(book.getOwner()));
    }

    public BookOnSale getBook() {
        return bookOnSale;
    }

    public Book getBookOnSale() {
        return bookOnSale;
    }

    public String getTitle() {
        return title.getText();
    }

    public String getIsbn() {
        return isbn.getText();
    }

    public String getPublicYear() {
        return publicYear.getText();
    }

    public String getPublisher() {
        return publisher.getText();
    }

    public String getAuthor() {
        return author.getText();
    }

    public String getPrice() {
        return price.getText();
    }

    public String getCondition() {
        return condition.getSelectedItem().toString();
    }

    public Book getNewBook() {
        return new BookOnSale(getTitle(), getIsbn(), getPublicYear(), getPublisher(), getAuthor(),
                getPrice(), BookCondition.valueOf(getCondition()), "");
    }
}
