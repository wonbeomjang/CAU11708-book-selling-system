package com.wonbeomjang.bookselling.Layout.Interface;

import com.wonbeomjang.bookselling.DataUtils.User.User;

import java.util.Observable;

public abstract class SignIn extends Observable {
    abstract public User signIn(String username, String password);
}
