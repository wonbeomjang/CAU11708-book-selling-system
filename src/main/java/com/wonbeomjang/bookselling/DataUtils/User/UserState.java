package com.wonbeomjang.bookselling.DataUtils.User;

import java.io.Serializable;

public enum UserState implements Serializable {
    Deactivate("Deactivate"), Activate("Activate"), Deleted("Deleted");
    private String string;
    UserState(String string) {
        this.string = string;
    }

    @Override
    public String toString() {
        return string;
    }
}
