package Layout.Interface;

import DataUtils.User.User;

public interface SearchUser extends InformationUnit {
    User[] search(String username);
}
