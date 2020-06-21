package com.wonbeomjang.bookselling.DataUtils.User;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
    private String username;
    private String password;
    private String name;
    private String email;
    private String phoneNumber;
    private UserState userState;
    private UserRank userRank = UserRank.EndUser;

    public User(String username, String password, String email,  String name, String phoneNumber) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.userState = UserState.Activate;
    }

    @JsonCreator
    public User(@JsonProperty("username") String username, @JsonProperty("password") String password,
                @JsonProperty("email") String email, @JsonProperty("name") String name,
                @JsonProperty("phoneNumber") String phoneNumber, @JsonProperty("rank") UserRank rank) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.userState = UserState.Activate;
        this.userRank = rank;
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

    public UserState getUserState() {
        return userState;
    }

    public void setUserState(UserState userState) {
        this.userState = userState;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public UserRank getUserRank() {
        return userRank;
    }

}
