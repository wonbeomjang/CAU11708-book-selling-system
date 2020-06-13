package com.wonbeomjang.bookselling.Layout.Interface;

import com.wonbeomjang.bookselling.DataUtils.User.User;
import com.wonbeomjang.bookselling.DataUtils.User.UserState;

import java.util.Observable;

public abstract class ManageUser extends Observable {
    public abstract boolean change(User user, UserState userState);
    public abstract boolean delete(User user);
}
