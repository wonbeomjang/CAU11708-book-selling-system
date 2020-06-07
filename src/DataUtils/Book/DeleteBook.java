package DataUtils.Book;

import DataUtils.User.User;

public class DeleteBook implements Layout.Interface.DeleteBook {
    BookSaleList bookSaleList;

    public DeleteBook(BookSaleList bookSaleList) {
        this.bookSaleList = bookSaleList;
    }

    @Override
    public boolean deleteBook(User owner, Book book) {
        if (!book.owner.equals(owner))
            return false;
        bookSaleList.deleteBook(book);
        return true;
    }
}
