package Layout.Interface;

import DataUtils.User.User;

import java.util.Observable;

public abstract class SignIn extends Observable {
    abstract public User signIn(String username, String password);
}
