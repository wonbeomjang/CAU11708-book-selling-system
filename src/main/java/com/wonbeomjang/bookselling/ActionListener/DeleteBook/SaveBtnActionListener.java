package com.wonbeomjang.bookselling.ActionListener.DeleteBook;

import com.wonbeomjang.bookselling.DataUtils.User.User;
import com.wonbeomjang.bookselling.Layout.BookListUp.BookOnSaleLabelPanel;
import com.wonbeomjang.bookselling.Layout.DeleteBook.DeleteBookListPanel;
import com.wonbeomjang.bookselling.Layout.Interface.DeleteBook;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observer;

public class SaveBtnActionListener implements ActionListener {
    DeleteBook deleteBook = new com.wonbeomjang.bookselling.DataUtils.Book.DeleteBook();
    DeleteBookListPanel deleteBookListPanel;
    User systemUser;

    public SaveBtnActionListener(DeleteBookListPanel deleteBookListPanel, User systemUser, Observer observer) {
        this.deleteBookListPanel = deleteBookListPanel;
        this.systemUser = systemUser;
        deleteBook.addObserver(observer);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ArrayList<BookOnSaleLabelPanel> bookOnSaleLabelPanels = deleteBookListPanel.getBookOnSaleLabelPanels();

        for (BookOnSaleLabelPanel bookOnSaleLabelPanel : bookOnSaleLabelPanels) {
            if(bookOnSaleLabelPanel.isChecked()) {
                deleteBook.deleteBook(systemUser, bookOnSaleLabelPanel.getBook());
            }
        }
    }
}
