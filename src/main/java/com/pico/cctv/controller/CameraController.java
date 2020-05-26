/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pico.cctv.controller;

import com.pico.cctv.domain.Camera;
import com.pico.cctv.service.CameraSvc;
import com.pico.cctv.service.ConfigurationSvc;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author atascg01
 */

@Controller
public class CameraController {
    
    private final ConfigurationSvc configurationSvc;
    private final CameraSvc cameraSvc;

    public CameraController(ConfigurationSvc configurationSvc, CameraSvc cameraSvc) {
        this.configurationSvc = configurationSvc;
        this.cameraSvc = cameraSvc;
    }
    
    @RequestMapping("/camera/new")
    public String renderAddCamera(Model model){
        model.addAttribute("configurations", configurationSvc.findConfigurations());
        model.addAttribute("camera", new Camera());
        return "addCamera";
    }
    
    @PostMapping("/camera/save")
    public String renderSaveCamera(Camera camera){
        //System.out.println(camera);
        cameraSvc.save(camera);
        return "redirect:/";
    }
    
    @RequestMapping("/camera/edit")
    public String renderEditCamera(Model model, int id){
        Camera camera = cameraSvc.findById(id);
        model.addAttribute("configurations", configurationSvc.findConfigurations());
        model.addAttribute("camera", camera);
        return "editCamera";
    }
    
    @RequestMapping("/camera/delete")
    public String renderDeleteCamera(int id){
        cameraSvc.deleteById(id);
        return "redirect:/";
    }
}
