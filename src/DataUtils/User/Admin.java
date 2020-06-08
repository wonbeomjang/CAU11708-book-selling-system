package DataUtils.User;

public class Admin extends User {
    public Admin(String username, String password) {
        super(username, password);
    }

    @Override
    public String toString() {
        return username + ':' + password + '\n';
    }
}
