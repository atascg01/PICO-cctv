/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pico.cctv.service;

import com.pico.cctv.domain.Role;
import com.pico.cctv.repository.RoleRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author atascg01
 */
@Service
public class RoleSvc {
    
    private final RoleRepository roleRepository;

    public RoleSvc(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Role findByName(String user) {
        return this.roleRepository.findByName(user);
    }
    
    

    
}
