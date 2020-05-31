/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pico.cctv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.pico.cctv.domain.Object;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author andre
 */
public interface ObjectRepository extends JpaRepository<Object, Integer>{
    
    @Query("from Object o where o.name =?1")
    public Object findByName(String name);
    
}
