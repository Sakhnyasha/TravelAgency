package org.sakhnyasha.service;

import org.sakhnyasha.entity.Role;
import org.sakhnyasha.entity.User;
import org.sakhnyasha.repository.BookingRepository;
import org.sakhnyasha.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private BookingRepository bookingRepository;

    public void addUser(User user){
        String password = user.getPassword();
        user.setPassword(passwordEncoder.encode(password));
        userRepository.save(user);
    }

    public User getUser(String email){
        return userRepository.findByEmail(email);
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public void deleteUser(Long id){
        bookingRepository.deleteBookingsForUser(id);
        userRepository.deleteById(id);
    }

    public User updateUser(User user){
        return userRepository.update(user);
    }

    public void changeRole(Long id){
        User one = userRepository.findOne(id);
        Role oldRole = one.getRole();
        Role newRole = oldRole.equals(Role.MANAGER) ? Role.USER : Role.MANAGER;
        one.setRole(newRole);
        userRepository.update(one);
    }

    public boolean exists(String email){
        return userRepository.exists(email);
    }



}
