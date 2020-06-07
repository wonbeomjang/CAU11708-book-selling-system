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

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setUserState(UserState userState) {
        this.userState = userState;
    }

    public UserState getUserState() {
        return userState;
    }

    @Override
    public String toString() {
        return "EndUser{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
