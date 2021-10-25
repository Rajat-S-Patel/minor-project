package com.blog.service.user;

import com.blog.dao.user.UserRepository;
import com.blog.model.user.User;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUser(User user){
        user.setDateOfRegistration(new Date());
        return userRepository.save(user);
    }

    public User findByUserName(String username){
        return userRepository.findById(username).get();
    }

    public User updateUser(User user) {
        if(userRepository.existsById(user.getUsername())){
            return userRepository.save(user);
        }
        return null;
    }

    public boolean deleteUser(String username) {
        if(userRepository.existsById(username)) {
            userRepository.deleteById(username);
            return true;
        }
        return false;
    }
}
