package DataUtils.User;

import java.util.ArrayList;

public class UserList {
    int numUser;
    ArrayList<User> userList;

    public UserList() {
        numUser = 0;
        userList = new ArrayList<>();
    }

    public boolean addUser(User user) {
      userList.add(user);
      numUser++;
      return true;
    }

    public boolean deleteUser(User user) {
        if (!userList.contains(user))
            return false;
        userList.remove(user);
        numUser--;
        return true;
    }

    public int getNumUser() {
        return numUser;
    }

}
