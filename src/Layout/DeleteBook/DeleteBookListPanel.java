package Layout.DeleteBook;

import DataUtils.Book.*;
import DataUtils.User.EndUser;
import DataUtils.User.User;
import Layout.SearchBook.BookOnSaleInfoLabelPanel;
import Layout.SearchBook.BookOnSaleInfoPanel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class DeleteBookListPanel extends JPanel {
    SearchBook searchBook = new SearchBook(BookSaleList.getInstance());
    ArrayList<BookOnSaleInfoPanel> bookOnSaleInfoPanels = new ArrayList<>();
    BookOnSaleInfoPanel bookOnSaleInfoPanel;
    Book[] books;
    public DeleteBookListPanel(User user) {
        if (user instanceof EndUser) {
            books = searchBook.search(user.getUsername(), BookKeyType.Username);
        }
        else {
            books = BookSaleList.getInstance().getBooks();
        }
        setLayout(new GridLayout(books.length + 1, 1));

        add(new BookOnSaleInfoLabelPanel());

        for(Book book: books) {
            if(book instanceof BookOnSale) {
                bookOnSaleInfoPanel = new BookOnSaleInfoPanel((BookOnSale)book);

                bookOnSaleInfoPanels.add(bookOnSaleInfoPanel);
                add(bookOnSaleInfoPanel);
            }
        }
    }

    public ArrayList<BookOnSaleInfoPanel> getBookOnSaleInfoPanels() {
        return bookOnSaleInfoPanels;
    }

    public Book[] getBooks() {
        return books;
    }

    public int getLength() {
        return bookOnSaleInfoPanels.size();
    }
}
