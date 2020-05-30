/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pico.cctv.repository;

import com.pico.cctv.domain.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author andre
 */
public interface UserRepository extends JpaRepository<User, Integer> {
    
    @Query("from User u where u.id =?1")
    User findById(int id);
    
    @Query("from User u where u.username =?1")
    User findByUsername(String username);

    @Query("from User u where u.email =?1")
    User findByEmail(String email);
    
    @Query("from User u where u.token =?1")
    User findByToken(String token);
    
}