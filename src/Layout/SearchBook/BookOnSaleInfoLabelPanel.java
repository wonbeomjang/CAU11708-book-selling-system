package Layout.SearchBook;

import javax.swing.*;
import java.awt.*;

public class BookOnSaleInfoLabelPanel extends JPanel {
    public BookOnSaleInfoLabelPanel() {
        setLayout(new GridLayout(1, 8));
        add(new JLabel("    "));
        add(new JLabel(" 제목 "));
        add(new JLabel(" ISBN "));
        add(new JLabel(" 출판년도 "));
        add(new JLabel(" 출판사 "));
        add(new JLabel(" 저자 "));
        add(new JLabel(" 가격 "));
        add(new JLabel(" 책 상태 "));
        add(new JLabel(" 판매자 "));
    }
}
