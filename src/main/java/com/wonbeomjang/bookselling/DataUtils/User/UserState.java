package com.wonbeomjang.bookselling.DataUtils.User;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public enum UserState implements Serializable {
    Deactivate("Deactivate"), Activate("Activate"), Deleted("Deleted");
    private String userState;
    @JsonCreator
    UserState(@JsonProperty("userState") String userState) {
        this.userState = userState;
    }

    @Override
    public String toString() {
        return userState;
    }
}
