/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pico.cctv.repository;

import com.pico.cctv.domain.Camera;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author atascg01
 */
public interface CameraRepository extends JpaRepository<Camera, Integer>{
    
    @Query("from Camera c where c.name like %?1%")
    List<Camera> findByName(String name);

}
