package com.wonbeomjang.bookselling.Layout.Interface;

import com.wonbeomjang.bookselling.DataUtils.User.User;

public interface SearchUser {
    User[] search(String username);
}
