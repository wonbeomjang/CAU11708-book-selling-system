package DataUtils.User;

public enum UserState {
    Deactivate("Deactivate"), Activate("Deactivate"), Deleted("Deactivate");
    private String string;
    UserState(String string) {
        this.string = string;
    }

    @Override
    public String toString() {
        return string;
    }
}
