package Layout.Interface;

import DataUtils.User.User;

public interface DeleteUser extends UpdateUnit{
    boolean delete(User user);
}
