package Layout.Interface;

import DataUtils.User.User;
import DataUtils.User.UserState;

import java.util.Observable;

public abstract class ChangeUserState extends Observable {
    public abstract boolean change(User user, UserState userState);
}
