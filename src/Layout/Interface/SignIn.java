package Layout.Interface;

import DataUtils.User.User;

import java.util.concurrent.Flow;

public interface SignIn {
    User signIn(String username, String password);
}
