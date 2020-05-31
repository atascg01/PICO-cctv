package com.pico.cctv.service;

import com.pico.cctv.repository.ObjectRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author atascg01
 */

@Service
public class ObjectSvc {
    
    private final ObjectRepository objectRepository;

    public ObjectSvc(ObjectRepository objectRepository) {
        this.objectRepository = objectRepository;
    }
    
    public Object save(Object object){
        return this.objectRepository.save(object);
    }
}
