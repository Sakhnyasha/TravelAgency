package org.sakhnyasha.repository;

import org.sakhnyasha.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserRepository {

    private static List<User> userList = new ArrayList<>();


    public void addUser(User user){
        userList.add(user);
    }

    public User getUser(String login){
        return userList.stream().filter(user -> user.getLogin().equals(login)).findAny().orElse(null);
    }

    public List<User> getAllUsers(){
        return userList;
    }
}
