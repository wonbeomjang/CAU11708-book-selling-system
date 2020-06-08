package DataUtils.User;

import DataUtils.User.Test.UserList;
import Layout.Interface.ChangeUserState;
import Layout.Interface.DeleteUser;

public class ManageUser implements ChangeUserState, DeleteUser {
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
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(User user) {
        if(user instanceof EndUser) {
            ((EndUser)user).setUserState(UserState.Deleted);
            return true;
        }
        return false;
    }

    @Override
    public boolean update() {
        return  change(user, userState);
    }
}
