/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pico.cctv.repository;

import com.pico.cctv.domain.Camera;
import com.pico.cctv.domain.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author atascg01
 */
public interface CameraRepository extends JpaRepository<Camera, Integer>{
    
    @Query("from Camera c where c.user =?2 AND c.name like %?1%")
    List<Camera> findByName(String name, User user);
    
    @Query("from Camera c where c.id =?1")
    Camera findById(int id);
    
    @Query("from Camera c where c.user =?1 order by c.name")
    List<Camera> findAllSorted(User user);
    
    @Query("from Camera c where c.ip =?1")
    Camera findByIp(String ip);

}
