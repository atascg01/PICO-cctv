/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pico.cctv.service;

import com.pico.cctv.domain.Configuration;
import com.pico.cctv.domain.User;
import com.pico.cctv.repository.ConfigurationRepository;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author atascg01
 */
@Service
public class ConfigurationSvc {
    
    private final ConfigurationRepository configurationRepository;

    public ConfigurationSvc(ConfigurationRepository configurationRepository) {
        this.configurationRepository = configurationRepository;
    }
    
    public List<Configuration> findConfigurations(User user){
        return configurationRepository.findAllByUser(user);
    }
    
    public Configuration findById(int id){
        return configurationRepository.findById(id);
    }
    
    public Configuration save(Configuration configuration){
        return configurationRepository.save(configuration);
    }
    
    public void deleteById(int id){
        configurationRepository.deleteById(id);
    }
    
}
