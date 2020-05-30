/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pico.cctv.controller;

import com.pico.cctv.domain.Configuration;
import com.pico.cctv.service.ConfigurationSvc;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author andre
 */

@Controller
public class ConfigurationController {
    
    private final ConfigurationSvc configurationSvc;

    public ConfigurationController(ConfigurationSvc configurationSvc) {
        this.configurationSvc = configurationSvc;
    }
    
    @RequestMapping("/configuration/new")
    public String renderNewConfiguration(Model model){
        Configuration configuration = new Configuration();
        model.addAttribute("configuration", configuration);
        return "addConfiguration";
    }
    
    @PostMapping("/configuration/save")
    public String saveConfiguration(Configuration configuration){
        this.configurationSvc.save(configuration);
        return "redirect:/home";
    }
    
    @RequestMapping("/configuration/edit")
    public String renderEditConfiguration(Model model, Integer id){
        Configuration configuration = configurationSvc.findById(id);
        model.addAttribute("configuration", configuration);
        return "editConfiguration";
    }
    
    @RequestMapping("/configuration/edit/confirm")
    public String renderEditConfirmConfiguration(Configuration configuration){
        Configuration confInDdbb = configurationSvc.findById(configuration.getId());
        confInDdbb.setName(configuration.getName());
        confInDdbb.setResolution(configuration.getResolution());
        confInDdbb.setColor(configuration.getColor());
        configurationSvc.save(confInDdbb);
        return "redirect:/home";
    }
    
}
