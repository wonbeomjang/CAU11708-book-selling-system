package DataUtils.User;

public class SignUp extends Layout.Interface.SignUp {
    String username;
    String password;
    String email;
    String phoneNumber;
    String name;
    UserList userList;

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
    public boolean signUp(String username, String password, String email, String phoneNumber, String name) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.name = name;

        if (username.equals("") || password.equals("") || email.equals("") || phoneNumber.equals("") || name.equals(""))
            return false;

        if(!checkUniqueUserName(username))
            return false;

        User newUser = new EndUser(username, password, name, email, phoneNumber);
        userList.addUser(newUser);
        userList.saveData();

        setChanged();
        notifyObservers(newUser);

        return true;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setName(String name) {
        this.name = name;
    }
}
