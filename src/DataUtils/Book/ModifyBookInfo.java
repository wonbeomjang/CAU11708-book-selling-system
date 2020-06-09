package DataUtils.Book;

import DataUtils.User.User;

public class ModifyBookInfo implements Layout.Interface.ModifyBookInfo {
    @Override
    public boolean modifyPrice(User owner, BookOnSale book, String price) {
        if (!book.getOwner().equals(owner)) {
            return false;
        }
        book.setPrice(price);
        return true;
    }

    @Override
    public boolean modifyCondition(User owner, BookOnSale book, BookCondition condition) {
        if (!book.getOwner().equals(owner)) {
            return false;
        }
        book.setCondition(condition);
        return false;
    }
}
