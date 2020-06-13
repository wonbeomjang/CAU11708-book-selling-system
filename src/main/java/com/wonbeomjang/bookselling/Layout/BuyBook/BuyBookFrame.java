package com.wonbeomjang.bookselling.Layout.BuyBook;

import com.wonbeomjang.bookselling.DataUtils.Book.Book;
import com.wonbeomjang.bookselling.DataUtils.User.Admin;
import com.wonbeomjang.bookselling.DataUtils.User.EndUser;
import com.wonbeomjang.bookselling.DataUtils.User.User;

import javax.swing.*;
import java.util.Observable;
import java.util.Observer;

public class BuyBookFrame extends JFrame implements Observer {
    BuyBookPanel buyBookPanel;
    EndUser systemUser;
    public BuyBookFrame(User systemUser) {
        if(systemUser instanceof Admin) dispose();

        assert systemUser instanceof EndUser;
        this.systemUser = (EndUser) systemUser;
        buyBookPanel = new BuyBookPanel(systemUser, this);

        add(buyBookPanel);
        setSize(buyBookPanel.getPanWidth(), buyBookPanel.getPanHeight());
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (arg instanceof String[]) {
            String[] strings = (String[])arg;
            String msg = "책 제목: " + strings[0]  + "\n구매자 이메일: " + strings[2] + "\n판매자 이메일: " +
                    strings[1] + "\n구매 이메일을 전송했습니다.";

            JOptionPane.showMessageDialog(null, msg);
            dispose();
        }
        else if (arg instanceof Book[]) {
            Book[] books = (Book[])arg;
            setSize(buyBookPanel.getPanWidth(), buyBookPanel.getPanHeight(books.length));
        }
    }
}
