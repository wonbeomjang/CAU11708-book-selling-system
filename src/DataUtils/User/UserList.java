package DataUtils.User;

import java.util.ArrayList;

public class UserList {
    private int numUsers;
    ArrayList<User> userList;

    public UserList() {
        numUsers = 0;
        userList = new ArrayList<>();
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

}
