package DataUtils.User;

import java.util.ArrayList;

public class SearchUser implements Layout.Interface.SearchUser {
    private final UserList userList = UserList.getInstance();

    @Override
    public User[] search(String username) {
        int numUser = userList.getNumUsers();
        User user;

        ArrayList<User> users = new ArrayList<>();

        for(int i = 0; i < numUser; i++) {
            user = userList.getUser(i);
            if(username == null || username.equals(user.username))
                users.add(user);
        }
        return users.toArray(new User[0]);
    }

    public User[] search() {
        return search(null);
    }
}
