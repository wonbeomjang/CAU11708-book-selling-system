package Layout.Interface;

import DataUtils.User.User;
import DataUtils.User.UserState;

public interface ChangeUserState {
    boolean change(User user, UserState userState);
}
