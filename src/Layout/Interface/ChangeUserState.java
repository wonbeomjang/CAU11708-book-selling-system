package Layout.Interface;

import DataUtils.User.User;
import DataUtils.User.UserState;

public interface ChangeUserState extends UpdateUnit {
    boolean change(User user, UserState userState);
}
