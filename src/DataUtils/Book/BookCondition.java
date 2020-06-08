package DataUtils.Book;

public enum BookCondition {
    Excellent("Excellent"), Good("Good"), Fair("Fair");
    private String sting;
    BookCondition(String sting) {
        this.sting = sting;
    }
    @Override
    public String toString() {
        return sting;
    }
}
