import com.wonbeomjang.bookselling.Layout.MainFrame;
import com.wonbeomjang.bookselling.Utils.SHA256;
import com.wonbeomjang.bookselling.Utils.SetUp;

public class Main {
    public static void main(String[] args) {
        SetUp.setup();
        new MainFrame();
    }
}
