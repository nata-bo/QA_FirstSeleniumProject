package org.ait.demo.models;

public class User {
    private String name;
    private String surname;
    private String email;
    private String password;
    private String ConfirmPassword;

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public String getSurname() {
        return surname;
    }

    public User setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public String getConfirmPassword() {
        return ConfirmPassword;
    }

    public User setConfirmPassword(String confirmPassword) {
        ConfirmPassword = confirmPassword;
        return this;
    }
}