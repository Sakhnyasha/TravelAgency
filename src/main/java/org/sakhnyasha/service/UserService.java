package org.sakhnyasha.service;

import org.sakhnyasha.model.User;
import org.sakhnyasha.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void addUser(User user){
        userRepository.addUser(user);
    }

    public User getUser(String login){
        return userRepository.getUser(login);
    }

    public List<User> getAllUsers(){
        return userRepository.getAllUsers();
    }

}
