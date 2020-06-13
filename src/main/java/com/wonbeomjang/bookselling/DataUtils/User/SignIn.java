package com.wonbeomjang.bookselling.DataUtils.User;

import com.wonbeomjang.bookselling.Utils.SHA256;

public class SignIn extends com.wonbeomjang.bookselling.Layout.Interface.SignIn {
    private final UserList userList;

    public SignIn() {
        this.userList = UserList.getInstance();
    }

    @Override
    public User signIn(String username, String password) {
        int numUser = userList.getNumUsers();
        User user;

        if (username.equals("") || password.equals(""))
            return null;


        for(int i = 0; i < numUser; i++) {
            user = userList.getUser(i);
            if(SHA256.encryption(password).equals(user.getPassword()) && username.equals(user.getUsername())) {
                if(!user.getUserState().equals(UserState.Activate)) {
                    return null;
                }
                setChanged();
                notifyObservers(user);
                return user;
            }
        }
        return null;
    }

}
