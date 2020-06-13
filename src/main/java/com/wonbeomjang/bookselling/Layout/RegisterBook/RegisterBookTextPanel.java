package com.wonbeomjang.bookselling.Layout.RegisterBook;

import javax.swing.*;
import java.awt.*;

public class RegisterBookTextPanel extends JPanel {
    JTextField title = new JTextField();
    JTextField isbn = new JTextField();
    JTextField publicYear = new JTextField();
    JTextField publisher = new JTextField();
    JTextField author = new JTextField();
    JTextField price = new JTextField();
    String[] conditionStr = {"None", "Excellent", "Good", "Fair"};
    JComboBox<String> condition = new JComboBox<>(conditionStr);

    public RegisterBookTextPanel() {
        setLayout(new GridLayout(7, 1));
        add(title);
        add(isbn);
        add(publicYear);
        add(publisher);
        add(author);
        add(price);
        add(condition);
    }

    public String getTitle() {
        return title.getText();
    }

    public String getIsbn() {
        return isbn.getText();
    }

    public String getPublicYear() {
        return publicYear.getText();
    }

    public String getPublisher() {
        return publisher.getText();
    }

    public String getAuthor() {
        return author.getText();
    }

    public String getPrice() {
        return price.getText();
    }

    public String getCondition() {
        return condition.getSelectedItem().toString();
    }
}
