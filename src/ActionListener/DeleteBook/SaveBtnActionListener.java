package ActionListener.DeleteBook;

import DataUtils.Book.BookSaleList;
import DataUtils.User.User;
import Layout.DeleteBook.DeleteBookListPanel;
import Layout.Interface.DeleteBook;
import Layout.SearchBook.BookOnSaleInfoPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observer;

public class SaveBtnActionListener implements ActionListener {
    DeleteBook deleteBook = new DataUtils.Book.DeleteBook(BookSaleList.getInstance());
    DeleteBookListPanel deleteBookListPanel;
    User systemUser;

    public SaveBtnActionListener(DeleteBookListPanel deleteBookListPanel, User systemUser, Observer observer) {
        this.deleteBookListPanel = deleteBookListPanel;
        this.systemUser = systemUser;
        deleteBook.addObserver(observer);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ArrayList<BookOnSaleInfoPanel> bookOnSaleInfoPanels = deleteBookListPanel.getBookOnSaleInfoPanels();

        for (BookOnSaleInfoPanel bookOnSaleInfoPanel: bookOnSaleInfoPanels) {
            if(bookOnSaleInfoPanel.isChecked()) {
                deleteBook.deleteBook(systemUser, bookOnSaleInfoPanel.getBook());
            }
        }
    }
}
