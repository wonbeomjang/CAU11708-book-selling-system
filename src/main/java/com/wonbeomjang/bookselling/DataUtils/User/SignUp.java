package com.wonbeomjang.bookselling.DataUtils.User;

import com.wonbeomjang.bookselling.Utils.SHA256;

public class SignUp extends com.wonbeomjang.bookselling.Layout.Interface.SignUp {
    private final UserList userList;

    public SignUp() {
        this.userList = UserList.getInstance();
    }

    public boolean checkUniqueUserName(String username) {
        int numUsers = userList.getNumUsers();
        User user;
        for (int i = 0; i < numUsers; i++){
            user = userList.getUser(i);
            if(username.equals(user.getUsername())) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean signUp(String username, String password, String email, String name, String phoneNumber) {

        if (username.equals("") || password.equals("") || email.equals("") || phoneNumber.equals("") || name.equals(""))
            return false;

        if(!checkUniqueUserName(username))
            return false;

        userList.addUser(username, SHA256.encryption(password), email, name, phoneNumber);

        setChanged();
        notifyObservers();

        return true;
    }
}
