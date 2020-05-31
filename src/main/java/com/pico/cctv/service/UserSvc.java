package com.pico.cctv.service;

import com.pico.cctv.domain.User;
import com.pico.cctv.repository.UserRepository;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author atascg01
 */

@Service
public class UserSvc {
    
    private final UserRepository userRepository;

    public UserSvc(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    public User findById(int id){
        return this.userRepository.findById(id);
    }
    
    public User save(User user){
        return userRepository.save(user);
    }
    
    public User findByUsername(String username){
        return this.userRepository.findByUsername(username);
    }

    public boolean isUsernameUsed(String username) {
        return findByUsername(username) != null;
    }

    public boolean isEmailUsed(String email) {
        return findByEmail(email) != null;
    }

    private Object findByEmail(String email) {
        return this.userRepository.findByEmail(email);
    }
    
    public User findByToken(String token){
        return this.userRepository.findByToken(token);
    }
    
    public List<User> findAll(){
        return this.userRepository.findAll();
    }
}
