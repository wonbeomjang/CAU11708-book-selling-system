package com.wonbeomjang.bookselling.ActionListener.RegisterBook;

import com.wonbeomjang.bookselling.DataUtils.Book.RegisterBook;
import com.wonbeomjang.bookselling.DataUtils.Book.BookCondition;
import com.wonbeomjang.bookselling.DataUtils.User.User;
import com.wonbeomjang.bookselling.Layout.RegisterBook.RegisterBookTextPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observer;

public class RegisterBtnActionListener implements ActionListener {
    RegisterBookTextPanel registerBookTextPanel;
    com.wonbeomjang.bookselling.Layout.Interface.RegisterBook registerBook;
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
        this.registerBook = new RegisterBook();
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
        else if(!checkFloat(price)) {
            JOptionPane.showMessageDialog(null,"정확한 가격이 아닙니다");
            return;
        } else if(!checkInt(publicYear)) {
            JOptionPane.showMessageDialog(null,"정확한 년도가 아닙니다");
            return;
        } else if(!checkISBN(isbn)) {
            JOptionPane.showMessageDialog(null,"정확한 ISBN이 아닙니다");
            return;
        }
        registerBook.addBook(title, isbn, publicYear, publisher, author, price, BookCondition.valueOf(condition), user);
    }

    private boolean checkFloat(String number) {
        return number.matches("^[+-]?\\d*(\\.?\\d*)$");
    }

    private boolean checkInt(String number) {
        return number.matches("^[0-9]*$");
    }

    private boolean checkISBN(String isbn) {
        if(isbn.equals("")) return true;
        return isbn.matches("^(?:ISBN(?:-10)?:? )?(?=[0-9X]{10}$|(?=(?:[0-9]+[- ]){3})[- 0-9X]{13}$)[0-9]{1,5}[- ]?[0-9]+[- ]?[0-9]+[- ]?[0-9X]$");
    }
}
