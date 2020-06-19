package com.wonbeomjang.bookselling.DataUtils.Book;

public enum BookKeyType {
    Title("Title"), ISBN("ISBN"), Author("Author"), Username("Username"), Publisher("Publisher"),
    PublicYear("Public Year"), ID("ID");
    private String string;
    BookKeyType(String string) {
        this.string = string;
    }

    @Override
    public String toString() {
        return string;
    }
}
