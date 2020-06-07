package DataUtils.Book;

public class DeleteBook implements Layout.Interface.DeleteBook {
    BookSaleList bookSaleList;

    public DeleteBook(BookSaleList bookSaleList) {
        this.bookSaleList = bookSaleList;
    }

    @Override
    public boolean deleteBook(Book book) {
        bookSaleList.deleteBook(book);
        return true;
    }
}
