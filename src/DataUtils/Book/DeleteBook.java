package DataUtils.Book;

import DataUtils.User.Admin;
import DataUtils.User.User;

public class DeleteBook extends Layout.Interface.DeleteBook {
    private final BookSaleList bookSaleList;

    public DeleteBook() {
        this.bookSaleList = BookSaleList.getInstance();
    }

    @Override
    public boolean deleteBook(User owner, Book book) {
        if (book.owner.equals(owner) || owner instanceof Admin) {
            bookSaleList.deleteBook(book);
            setChanged();
            notifyObservers(book);
            bookSaleList.saveData();
            return true;
        }
        return false;
    }
}
