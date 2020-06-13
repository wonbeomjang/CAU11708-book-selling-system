package com.wonbeomjang.bookselling.DataUtils.User;

import com.wonbeomjang.bookselling.DataUtils.Book.BookSaleList;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

public class UserList implements Serializable {
    private int numUsers;
    ArrayList<User> userList;
    UserListFileManager userListFileManager;
    BookSaleList bookSaleList = BookSaleList.getInstance();

    private static final UserList instance = new UserList();

    private UserList() {}

    public static UserList getInstance() {
        return instance;
    }

    public void init(String fileName) {
        numUsers = 0;
        this.userListFileManager = new UserListFileManager(fileName);
        try {
            userList = userListFileManager.readData();
            numUsers = userList.size();
        }
        catch (IOException e) {
            userList = new ArrayList<User>();
        }
    }

    public boolean addUser(User user) {
      userList.add(user);
      numUsers++;
      return true;
    }

    public boolean contain(User user) {
        return userList.contains(user);
    }

    public boolean deleteUser(User user) {
        if (!userList.contains(user))
            return false;
        userList.remove(user);
        numUsers--;
        return true;
    }

    public int getNumUsers() {
        return numUsers;
    }

    public User getUser(int index) {
        return userList.get(index);
    }

    public User[] getUsers() {
        return userList.toArray(new User[0]);
    }

    public void saveData() {
        for(User user: userList) {
            if(user instanceof EndUser && ((EndUser)user).getUserState().equals(UserState.Deleted)) {
                bookSaleList.refresh(user);
            }
        }
        userListFileManager.saveData();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < numUsers; i++) {
            stringBuilder.append(userList.get(i).toString());
        }
        return stringBuilder.toString();
    }
}
