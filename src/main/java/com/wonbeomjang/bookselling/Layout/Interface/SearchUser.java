package com.wonbeomjang.bookselling.Layout.Interface;

import com.wonbeomjang.bookselling.DataUtils.User.User;

import java.util.Observable;

public abstract class SearchUser extends Observable {
    public abstract User[] search(String username);
}
