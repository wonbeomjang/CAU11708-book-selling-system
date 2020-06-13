package com.wonbeomjang.bookselling.Layout.SearchBook;

import com.wonbeomjang.bookselling.DataUtils.Book.BookKeyType;

import javax.swing.*;
import java.awt.*;

public class SearchKeyWordPanel extends JPanel {
    JTextField keyText;
    JButton searchBtn;
    JComboBox<BookKeyType> searchKeyType = new JComboBox<>(BookKeyType.values());
    public SearchKeyWordPanel() {
        keyText = new JTextField();
        searchBtn = new JButton("검색");

        setLayout(new BorderLayout());

        add(searchKeyType, BorderLayout.WEST);
        add(keyText, BorderLayout.CENTER);
        add(searchBtn, BorderLayout.EAST);
    }

    public JTextField getKeyText() {
        return keyText;
    }

    public JButton getSearchBtn() {
        return searchBtn;
    }

    public JComboBox<BookKeyType> getSearchKeyType() {
        return searchKeyType;
    }
}
