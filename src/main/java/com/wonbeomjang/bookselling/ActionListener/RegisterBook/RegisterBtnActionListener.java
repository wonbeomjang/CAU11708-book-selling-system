package com.wonbeomjang.bookselling.ActionListener.RegisterBook;

import com.wonbeomjang.bookselling.DataUtils.Book.AddBook;
import com.wonbeomjang.bookselling.DataUtils.Book.BookCondition;
import com.wonbeomjang.bookselling.DataUtils.User.User;
import com.wonbeomjang.bookselling.Layout.Interface.RegisterBook;
import com.wonbeomjang.bookselling.Layout.RegisterBook.RegisterBookTextPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observer;

public class RegisterBtnActionListener implements ActionListener {
    RegisterBookTextPanel registerBookTextPanel;
    RegisterBook registerBook;
    String title;
    String isbn;
    String publicYear;
    String publisher;
    String author;
    String price;
    String condition;
    User user;

    public RegisterBtnActionListener(RegisterBookTextPanel registerBookTextPanel, User user, Observer observer) {
        this.registerBookTextPanel = registerBookTextPanel;
        this.registerBook = new AddBook();
        this.user = user;
        this.registerBook.addObserver(observer);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        title = registerBookTextPanel.getTitle();
        isbn = registerBookTextPanel.getIsbn();
        publicYear = registerBookTextPanel.getPublicYear();
        publisher = registerBookTextPanel.getPublisher();
        author = registerBookTextPanel.getAuthor();
        price = registerBookTextPanel.getPrice();
        condition = registerBookTextPanel.getCondition();

        if(title.equals("")) {
            JOptionPane.showMessageDialog(null,"제목을 입력해주세요");
            return;
        }
        else if(!checkInt(price)) {
            JOptionPane.showMessageDialog(null,"정확한 가격이 아닙니다");
            return;
        } else if(!checkInt(publicYear)) {
            JOptionPane.showMessageDialog(null,"정확한 년도가 아닙니다");
            return;
        }
        System.out.println(isbn);
        registerBook.addBook(title, isbn, publicYear, publisher, author, price, BookCondition.valueOf(condition), user);
    }

    private boolean checkInt(String number) {
        if(!number.equals("")) {
            try {
                Integer.parseInt(number);
            }
            catch (Exception exception) {
                return false;
            }
        }
        return true;
    }
}
