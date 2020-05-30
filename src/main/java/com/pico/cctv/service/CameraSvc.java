package com.pico.cctv.service;

import com.pico.cctv.domain.Camera;
import com.pico.cctv.domain.User;
import com.pico.cctv.repository.CameraRepository;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author atascg01
 */

@Service
public class CameraSvc {
    
    private final CameraRepository cameraRepository;

    public CameraSvc(CameraRepository cameraRepository) {
        this.cameraRepository = cameraRepository;
    }
    
    public List<Camera> findCameras(){ 
        return cameraRepository.findAll();
    }
    
    public List<Camera> findCamerasSorted(User user){
        return cameraRepository.findAllSorted(user);
    }
    
    public List<Camera> findByName(String name){
        return cameraRepository.findByName(name);
    }
    
    public Camera save(Camera camera){
        return cameraRepository.save(camera);
    }

    public Camera findById(int id){
        return cameraRepository.findById(id);
    }
    
    public void deleteById(int id){
        cameraRepository.deleteById(id);
    }
    
    public boolean isIpUsed(String ip) {
        return cameraRepository.findByIp(ip) != null;
    }
}
