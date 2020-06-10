package DataUtils.User;

public class EndUser extends User {
    private String name;
    private String email;
    private String phoneNumber;
    private UserState userState;

    public EndUser(String username, String password, String name, String email, String phoneNumber) {
        super(username, password);
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.userState = UserState.Activate;
    }

    public EndUser(String username, String password, String name, String email, String phoneNumber, String userState) {
        super(username, password);
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.userState = UserState.valueOf(userState);
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public UserState getUserState() {
        return userState;
    }

    public void setUserState(UserState userState) {
        this.userState = userState;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return username + ": " + password + ": " + email + ": " + phoneNumber + ": " + name + ": " + userState.toString() + '\n';
    }
}
