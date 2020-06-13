package com.wonbeomjang.bookselling.Layout.Interface;

import java.util.Observable;

public abstract class SignUp extends Observable {
    public abstract boolean signUp(String username, String password, String email, String phoneNumber, String name);
}
