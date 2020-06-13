package com.wonbeomjang.bookselling.Layout.DeleteBook;

import com.wonbeomjang.bookselling.ActionListener.DeleteBook.SaveBtnActionListener;
import com.wonbeomjang.bookselling.DataUtils.User.User;

import javax.swing.*;
import java.awt.*;
import java.util.Observer;

public class DeleteBookPanel extends JPanel {
    DeleteBookListPanel deleteBookListPanel;
    JButton saveBtn = new JButton("삭제");
    public DeleteBookPanel(User systemUser, Observer observer) {
        setLayout(new BorderLayout());

        deleteBookListPanel = new DeleteBookListPanel(systemUser);

        add(deleteBookListPanel, BorderLayout.CENTER);
        add(saveBtn, BorderLayout.EAST);

        saveBtn.addActionListener(new SaveBtnActionListener(deleteBookListPanel, systemUser, observer));
    }

    public int getLength() {
        return deleteBookListPanel.getLength();
    }


}
