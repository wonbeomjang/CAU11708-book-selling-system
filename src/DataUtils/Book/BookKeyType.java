package DataUtils.Book;

public enum BookKeyType {
    Title("Title"), ISBN("ISBN"), Author("Author"), Username("Username");
    private String string;
    BookKeyType(String string) {
        this.string = string;
    }

    @Override
    public String toString() {
        return string;
    }
}
