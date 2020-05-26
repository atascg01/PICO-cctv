package com.pico.cctv.controller;

import com.pico.cctv.domain.Camera;
import com.pico.cctv.domain.Configuration;
import com.pico.cctv.service.CameraSvc;
import com.pico.cctv.service.ConfigurationSvc;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author atascg01
 */
@Controller
public class IndexController {
    
    private final CameraSvc cameraSvc;
    private final ConfigurationSvc configurationSvc;
    
    public IndexController(CameraSvc cameraSvc, ConfigurationSvc configurationSvc) {
        this.cameraSvc = cameraSvc;
        this.configurationSvc = configurationSvc;
    }
    
    @RequestMapping("/")
    public String renderIndex(Model model){
        List<Camera> cameras = cameraSvc.findCamerasSorted();
        model.addAttribute("cameras", cameras);
        return "index";
    }
    
    @RequestMapping("/cameraByName")
    public String renderCameraByName(Model model, String name){
        List<Camera> cameras = cameraSvc.findByName(name);
        model.addAttribute("cameras", cameras);
        return "index";
    }
    
    @RequestMapping("/configuration")
    public String renderConfiguration(Model model){
        List<Configuration> configurations = configurationSvc.findConfigurations();
        model.addAttribute("configurations", configurations);
        return "configuration";
    }
    
    @RequestMapping("/configurationById")
    public String renderCameraByConfiguration(Model model, Integer id){
        List<Configuration> configurations = configurationSvc.findById(id);
        model.addAttribute("configurations", configurations);
        return "configuration";
    }
    
    @RequestMapping("/search")
    public String search(@RequestParam("q") String query, Model model){
        List<Camera> cameras = cameraSvc.findByName(query);
        model.addAttribute("cameras", cameras);
        return "index";
    }
}
