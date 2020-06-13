package com.wonbeomjang.bookselling.DataUtils.User;

import com.wonbeomjang.bookselling.DataUtils.Book.BookSaleList;

public class ManageUser extends com.wonbeomjang.bookselling.Layout.Interface.ManageUser {
    private final UserList userList;
    BookSaleList bookSaleList = BookSaleList.getInstance();

    public ManageUser() {
        this.userList = UserList.getInstance();
    }

    @Override
    public boolean change(User user, UserState userState) {
        if(user.getUserRank().equals(UserRank.EndUser)) {
            user.setUserState(userState);
            userList.saveData();
            setChanged();
            notifyObservers(user);
            clearChanged();

            return true;
        }

        return false;
    }

    @Override
    public boolean delete(User user) {
        if(user.getUserState().equals(UserState.Deleted))
            return false;
        if(user.getUserRank().equals(UserRank.EndUser)) {

            userList.deleteUser(user);
            userList.saveData();

            setChanged();
            notifyObservers(user);
            clearChanged();

            return true;
        }
        return false;
    }
}
