package DataUtils.User;

import Layout.Interface.ChangeUserState;
import Layout.Interface.DeleteUser;

public class ManageUser extends ChangeUserState implements DeleteUser {
    UserList userList;
    User user;
    UserState userState;

    public ManageUser(UserList userList) {
        this.userList = userList;
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
            ((EndUser)user).setUserState(UserState.Deleted);
            userList.saveData();
            setChanged();
            notifyObservers(user);

            return true;
        }
        return false;
    }
}
