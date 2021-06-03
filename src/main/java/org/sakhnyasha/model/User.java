package org.sakhnyasha.model;

import java.util.Objects;

public class User {
    private String first_name;
    private String last_name;
    private String login;
    private String password;


    public User() {
    }

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return first_name;
    }

    public void setFirstName(String first_name) {
        this.first_name = first_name;
    }

    public String getLastName() {
        return first_name;
    }

    public void setLastName(String last_name) {
        this.last_name = last_name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + first_name + " " + last_name + '\'' +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(first_name, user.first_name) && Objects.equals(last_name, user.last_name) && Objects.equals(login, user.login) && Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first_name, last_name, login, password);
    }
}
