package Layout.DeleteBook;

import ActionListener.DeleteBook.SaveBtnActionListener;
import DataUtils.User.User;

import javax.swing.*;
import java.awt.*;
import java.util.Observer;

public class DeleteBookPanel extends JPanel {
    DeleteBookListPanel deleteBookListPanel;
    JButton saveBtn = new JButton("저장");
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
