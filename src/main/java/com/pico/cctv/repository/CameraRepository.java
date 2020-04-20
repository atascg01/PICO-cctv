/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pico.cctv.repository;

import com.pico.cctv.domain.Camera;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author atascg01
 */
public interface CameraRepository extends JpaRepository<Camera, Integer>{
    
}
