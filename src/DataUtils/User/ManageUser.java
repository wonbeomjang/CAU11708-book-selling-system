package DataUtils.User;

import DataUtils.Book.BookSaleList;
import Layout.Interface.ChangeUserState;
import Layout.Interface.DeleteUser;

public class ManageUser extends ChangeUserState implements DeleteUser {
    UserList userList;
    User user;
    UserState userState;

    public ManageUser() {
        this.userList = UserList.getInstance();
    }

    @Override
    public boolean change(User user, UserState userState) {
        this.user = user;
        this.userState = userState;

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

            BookSaleList.getInstance().refresh(userList);

            setChanged();
            notifyObservers(user);

            return true;
        }
        return false;
    }
}
