package DataUtils.User;

public class SignIn implements Layout.Interface.SignIn {
    UserList userList;

    public SignIn(UserList userList) {
        this.userList = userList;
    }

    @Override
    public User signIn(String username, String password) {
        int numUser = userList.getNumUsers();
        User user;
        for(int i = 0; i < numUser; i++) {
            user = userList.getUser(i);
            if(password.equals(user.getPassword()) && username.equals(user.getUsername())) {
                if(user instanceof EndUser && !((EndUser)user).getUserState().equals(UserState.Activate))
                    return null;
                return user;
            }
        }
        return null;
    }
}
