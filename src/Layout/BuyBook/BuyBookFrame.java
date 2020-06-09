package Layout.BuyBook;

import DataUtils.Book.Book;
import DataUtils.User.Admin;
import DataUtils.User.EndUser;
import DataUtils.User.User;

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
        if (arg instanceof Book) {
            String msg = "책 제목: " + ((Book) arg).getOwner() + "\n구매자 이메일: " + systemUser.getEmail() + "\n판매자 이메일: " +
                    (((EndUser)((Book) arg).getOwner()).getEmail()) + "\n구매 이메일을 전송했습니다.";

            JOptionPane.showMessageDialog(null, msg);
            dispose();
        }
        else if (arg instanceof Book[]) {
            Book[] books = (Book[])arg;
            setSize(buyBookPanel.getPanWidth(), buyBookPanel.getPanHeight(books.length));
        }
    }
}
