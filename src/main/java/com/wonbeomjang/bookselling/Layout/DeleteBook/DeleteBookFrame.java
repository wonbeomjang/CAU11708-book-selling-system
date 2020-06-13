package com.wonbeomjang.bookselling.Layout.DeleteBook;

import com.wonbeomjang.bookselling.DataUtils.User.User;
import com.wonbeomjang.bookselling.Layout.Interface.SearchBook;

import javax.swing.*;
import java.util.Observable;
import java.util.Observer;

public class DeleteBookFrame extends JFrame implements Observer {
    User systemUser;
    SearchBook searchBook = new com.wonbeomjang.bookselling.DataUtils.Book.SearchBook();
    DeleteBookPanel deleteBookPanel;
    int height;

    public DeleteBookFrame(User systemUser) {
        this.systemUser = systemUser;

        deleteBookPanel = new DeleteBookPanel(systemUser, this);
        add(deleteBookPanel);
        height = deleteBookPanel.getLength() * 40 + 70;

        setSize(800, height);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void update(Observable o, Object arg) {
        remove(deleteBookPanel);

        deleteBookPanel = new DeleteBookPanel(systemUser, this);
        height = deleteBookPanel.getLength() * 40 + 70;

        add(deleteBookPanel);

        setSize(800, height);

        validate();
        repaint();

    }
}
