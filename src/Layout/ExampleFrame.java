package Layout;

import javax.swing.*;
import java.awt.*;

public class ExampleFrame extends JFrame {
    public ExampleFrame() {
        setLayout(new BorderLayout());

        setSize(500, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

}
