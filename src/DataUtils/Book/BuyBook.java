package DataUtils.Book;

import DataUtils.User.User;

public class BuyBook extends Layout.Interface.BuyBook {
    @Override
    public boolean buyBook(User buyer, Book book) {
        if(book.owner.equals(buyer))
            return false;
        book.owner = buyer;
        BookSaleList.getInstance().saveData();

        setChanged();
        notifyObservers(book);

        return true;
    }
}
