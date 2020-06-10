package DataUtils.Book;

import DataUtils.User.EndUser;
import DataUtils.User.User;
import Layout.Interface.SearchUser;

public class BuyBook extends Layout.Interface.BuyBook {
    @Override
    public boolean buyBook(User buyer, Book book) {
        if(book.owner.equals(buyer.getUsername()))
            return false;

        SearchUser searchUser = new DataUtils.User.SearchUser();
        String[] strings = {book.getTitle(), ((EndUser)searchUser.search(book.getOwner())[0]).getEmail(),
                ((EndUser)buyer).getEmail()};
        book.owner = buyer.getUsername();
        BookSaleList.getInstance().saveData();

        setChanged();
        notifyObservers(strings);

        return true;
    }
}
