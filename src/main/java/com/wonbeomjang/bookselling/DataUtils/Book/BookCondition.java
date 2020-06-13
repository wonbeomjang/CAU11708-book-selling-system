package com.wonbeomjang.bookselling.DataUtils.Book;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public enum BookCondition {
    Excellent("Excellent"), Good("Good"), Fair("Fair"), None("None");
    private final String condition;
    @JsonCreator
    BookCondition(@JsonProperty("condition") String condition) {
        this.condition = condition;
    }
    @Override
    public String toString() {
        return condition;
    }
}
