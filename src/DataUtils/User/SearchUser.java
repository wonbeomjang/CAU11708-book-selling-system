package DataUtils.User;

import java.util.ArrayList;

public class SearchUser implements Layout.Interface.SearchUser {
    ArrayList<User> users;
    UserList userList;

    public SearchUser() {
        this.userList = UserList.getInstance();
        users = new ArrayList<>();
    }

    @Override
    public User[] search(String username) {
        int numUser = userList.getNumUsers();
        User user;

        users.clear();
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

    public String[] getInfo() {
        String[] outputs = new String[users.size()];
        for(int i = 0; i < users.size(); i++) {
            outputs[i] = users.get(i).toString();
        }
        return outputs;
    }
}
