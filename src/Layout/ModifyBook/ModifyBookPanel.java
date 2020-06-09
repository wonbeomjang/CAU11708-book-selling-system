package Layout.ModifyBook;

import ActionListener.ModifyBook.SaveBtnActionListener;
import DataUtils.User.EndUser;

import javax.swing.*;
import java.awt.*;
import java.util.Observer;

public class ModifyBookPanel extends JPanel {
    ModifyBookListPanel modifyBookListPanel;
    JButton saveBtn = new JButton("저장");
    public ModifyBookPanel(EndUser systemUser, Observer observer) {
        setLayout(new BorderLayout());

        modifyBookListPanel = new ModifyBookListPanel(systemUser);

        add(modifyBookListPanel, BorderLayout.CENTER);
        add(saveBtn, BorderLayout.EAST);

        saveBtn.addActionListener(new SaveBtnActionListener(modifyBookListPanel, observer));
    }

    public int getLength() {
        return modifyBookListPanel.getLength();
    }


}
