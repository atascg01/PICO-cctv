/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pico.cctv.repository;

import com.pico.cctv.domain.Configuration;
import com.pico.cctv.domain.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author atascg01
 */
public interface ConfigurationRepository extends JpaRepository<Configuration, Integer> {
    
    @Query("from Configuration c where c.id =?1")
    Configuration findById(int id);
    
    @Query("from Configuration c where c.user =?1")
    List<Configuration> findAllByUser(User user);
    
}
