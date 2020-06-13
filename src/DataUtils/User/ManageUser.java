package DataUtils.User;

import DataUtils.Book.BookSaleList;

public class ManageUser extends Layout.Interface.ManageUser {
    private final UserList userList;
    BookSaleList bookSaleList = BookSaleList.getInstance();

    public ManageUser() {
        this.userList = UserList.getInstance();
    }

    @Override
    public boolean change(User user, UserState userState) {
        if(user instanceof EndUser) {
            ((EndUser)user).setUserState(userState);
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
        if(user instanceof EndUser) {
            ((EndUser)user).setUserState(UserState.Deleted);
            userList.saveData();

            setChanged();
            notifyObservers(user);
            clearChanged();

            return true;
        }
        return false;
    }
}
