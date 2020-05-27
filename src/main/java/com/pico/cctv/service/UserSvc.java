package com.pico.cctv.service;

import com.pico.cctv.domain.User;
import com.pico.cctv.repository.UserRepository;
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
}
