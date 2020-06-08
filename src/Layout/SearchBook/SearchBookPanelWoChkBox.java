package Layout.SearchBook;

import java.util.Observable;
import java.util.Observer;

public class SearchBookPanelWoChkBox extends SearchBookPanel {
    public SearchBookPanelWoChkBox(Observer observer) {
        super(observer);
        removeChkBox();
    }

    private void removeChkBox() {
        bookInfoLabelPanel.remove(0);

        for(BookInfoPanel panel: bookInfoPanels) {
            panel.remove(0);
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        super.update(o, arg);
        removeChkBox();
    }
}
