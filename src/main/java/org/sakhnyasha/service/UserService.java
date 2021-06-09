package org.sakhnyasha.service;

import org.sakhnyasha.entity.User;
import org.sakhnyasha.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void addUser(User user){
        userRepository.save(user);
    }

    public User getUser(String email){
        return userRepository.findByEmail(email);
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }

    public User updateUser(User user){
        return userRepository.update(user);
    }


}
