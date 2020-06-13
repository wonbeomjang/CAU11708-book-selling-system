package com.wonbeomjang.bookselling.Layout.SearchBook;

import com.wonbeomjang.bookselling.DataUtils.User.User;
import com.wonbeomjang.bookselling.Layout.BookListUp.BookOnSaleLabelPanel;

import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class SearchBookPanelWoChkBox extends SearchBookPanel {
    public SearchBookPanelWoChkBox(User systemUser, Observer observer) {
        super(systemUser, observer);
        removeChkBox();
    }

    private void removeChkBox() {
        bookOnSaleAttribFrtBlkPanel.remove(0);
        Component[] components = getComponents();
        for(Component component: components) {
            if(component instanceof BookOnSaleLabelPanel)
                ((BookOnSaleLabelPanel)component).remove(0);
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        super.update(o, arg);
        removeChkBox();
    }
}
