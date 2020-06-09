package Layout.DeleteBook;

import DataUtils.Book.*;
import DataUtils.User.EndUser;
import DataUtils.User.User;
import Layout.SearchBook.BookInfoLabelPanel;
import Layout.SearchBook.BookInfoPanel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class DeleteBookListPanel extends JPanel {
    SearchBook searchBook = new SearchBook(BookSaleList.getInstance());
    ArrayList<BookInfoPanel> bookInfoPanels = new ArrayList<>();
    BookInfoPanel bookInfoPanel;
    Book[] books;
    public DeleteBookListPanel(User user) {
        if (user instanceof EndUser) {
            books = searchBook.search(user.getUsername(), BookKeyType.Username);
        }
        else {
            books = BookSaleList.getInstance().getBooks();
        }
        setLayout(new GridLayout(books.length + 1, 1));

        add(new BookInfoLabelPanel());

        for(Book book: books) {
            if(book instanceof BookOnSale) {
                bookInfoPanel = new BookInfoPanel(book.getTitle(), book.getIsbn(), book.getIsbn(), book.getPublisher(),
                        book.getAuthor(), ((BookOnSale)book).getPrice(), ((BookOnSale)book).getCondition().toString(),
                        book.getOwner().getUsername());

                bookInfoPanels.add(bookInfoPanel);
                add(bookInfoPanel);
            }
        }
    }
}
