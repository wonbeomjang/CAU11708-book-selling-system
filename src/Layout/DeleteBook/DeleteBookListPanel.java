package Layout.DeleteBook;

import DataUtils.Book.*;
import DataUtils.User.EndUser;
import DataUtils.User.User;
import Layout.BookListUp.BookOnSaleAttribFrtBlkPanel;
import Layout.BookListUp.BookOnSaleLabelPanel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class DeleteBookListPanel extends JPanel {
    SearchBook searchBook = new SearchBook();
    ArrayList<BookOnSaleLabelPanel> bookOnSaleLabelPanels = new ArrayList<>();
    BookOnSaleLabelPanel bookOnSaleLabelPanel;
    Book[] books;
    public DeleteBookListPanel(User user) {
        if (user instanceof EndUser) {
            books = searchBook.search(user.getUsername(), BookKeyType.Username);
        }
        else {
            books = BookSaleList.getInstance().getBooks();
        }
        setLayout(new GridLayout(books.length + 1, 1));

        add(new BookOnSaleAttribFrtBlkPanel());

        for(Book book: books) {
            if(book instanceof BookOnSale) {
                bookOnSaleLabelPanel = new BookOnSaleLabelPanel((BookOnSale)book);

                bookOnSaleLabelPanels.add(bookOnSaleLabelPanel);
                add(bookOnSaleLabelPanel);
            }
        }
    }

    public ArrayList<BookOnSaleLabelPanel> getBookOnSaleLabelPanels() {
        return bookOnSaleLabelPanels;
    }

    public Book[] getBooks() {
        return books;
    }

    public int getLength() {
        return bookOnSaleLabelPanels.size();
    }
}
