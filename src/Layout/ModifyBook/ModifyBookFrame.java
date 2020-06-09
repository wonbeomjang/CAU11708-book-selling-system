package Layout.ModifyBook;

import DataUtils.Book.Book;
import DataUtils.User.EndUser;
import DataUtils.User.User;

import javax.swing.*;
import java.util.Observable;
import java.util.Observer;

public class ModifyBookFrame extends JFrame implements Observer {
    User systemUser;
    ModifyBookPanel modifyBookPanel;
    int height;

    public ModifyBookFrame(User systemUser) {
        if(!(systemUser instanceof EndUser))
            dispose();
        this.systemUser = systemUser;

        modifyBookPanel = new ModifyBookPanel((EndUser) systemUser, this);
        add(modifyBookPanel);
        height = modifyBookPanel.getLength() * 40 + 70;

        setSize(800, height);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void update(Observable o, Object arg) {
        JOptionPane.showMessageDialog(null, ((Book)arg).getTitle() + "의 내용이 변경되었습니다.");
        dispose();
    }
}
