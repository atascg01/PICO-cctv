/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pico.cctv.repository;

import com.pico.cctv.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author andre
 */
public interface RoleRepository extends JpaRepository<Role, Integer>{
    
    @Query("from Role r where r.name =?1")
    public Role findByName(String name);
}
