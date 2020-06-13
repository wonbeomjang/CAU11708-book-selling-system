package com.wonbeomjang.bookselling.DataUtils.User;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public enum UserRank implements Serializable {
    Admin("Admin"), EndUser("EndUser");
    private String rank;
    @JsonCreator
    UserRank(@JsonProperty("rank") String rank) {
        this.rank = rank;
    }
    @Override
    public String toString() {
        return rank;
    }
}
