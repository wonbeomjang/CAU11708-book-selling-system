package DataUtils.User;

import DataUtils.Book.BookSaleList;
import Layout.Interface.ChangeUserState;
import Layout.Interface.DeleteUser;

public class ManageUser extends ChangeUserState implements DeleteUser {
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

            return true;
        }

        return false;
    }

    @Override
    public boolean delete(User user) {
        if(user instanceof EndUser) {
            userList.deleteUser(user);
            userList.saveData();

            bookSaleList.refresh();

            setChanged();
            notifyObservers(user);

            return true;
        }
        return false;
    }
}
