package com.pe.screenplaybdd.model;

public class User {
    private int id;
    private String username;
    private  String firstName;
    private  String lastName;
    private  String email;
    private  String password;
    private  String phone;
    private  String userStatus;

    public User() {

    }

    public User(int id, String username, String firstName, String lastName, String email, String password, String phone, String userStatus) {
        this.id = id;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.userStatus = userStatus;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getPhone() {
        return phone;
    }

    public String getUserStatus() {
        return userStatus;
    }


}
