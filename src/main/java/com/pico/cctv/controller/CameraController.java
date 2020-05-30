/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pico.cctv.controller;

import com.pico.cctv.domain.Camera;
import com.pico.cctv.domain.User;
import com.pico.cctv.service.CameraSvc;
import com.pico.cctv.service.ConfigurationSvc;
import com.pico.cctv.service.UserSvc;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    private final UserSvc userSvc;

    public CameraController(ConfigurationSvc configurationSvc, CameraSvc cameraSvc, UserSvc userSvc) {
        this.configurationSvc = configurationSvc;
        this.cameraSvc = cameraSvc;
        this.userSvc = userSvc;
    }
    
    @RequestMapping("/camera/new")
    public String renderAddCamera(Model model, HttpServletRequest request, HttpServletResponse response){
        User user = getUser(request);
        model.addAttribute("user", user);
        model.addAttribute("configurations", configurationSvc.findConfigurations(user));
        model.addAttribute("camera", new Camera());
        return "addCamera";
    }
    
    @PostMapping("/camera/save")
    public String renderSaveCamera(Camera camera, HttpServletRequest request, HttpServletResponse response){
        String token = request.getParameter("sid");
        User user = userSvc.findByToken(token);
        camera.setUser(user);
        cameraSvc.save(camera);
        return "redirect:/home?sid="+token;
    }
    
    @RequestMapping("/camera/edit")
    public String renderEditCamera(Model model, Integer id, HttpServletRequest request, HttpServletResponse response){
        User user = getUser(request);
        Camera camera = cameraSvc.findById(id);
        model.addAttribute("user", user);
        model.addAttribute("configurations", configurationSvc.findConfigurations(user));
        model.addAttribute("camera", camera);
        return "editCamera";
    }
    
    @RequestMapping("/camera/edit/confirm")
    public String renderEditConfirmCamera(Camera camera, HttpServletRequest request, HttpServletResponse response){
        String token = request.getParameter("sid");
        User user = userSvc.findByToken(token);
        Camera cameraInDdbb = cameraSvc.findById(camera.getId());
        cameraInDdbb.setConfiguration(camera.getConfiguration());
        cameraInDdbb.setDescription(camera.getDescription());
        cameraInDdbb.setIp(camera.getIp());
        cameraInDdbb.setName(camera.getName());
        cameraInDdbb.setUrlImage(camera.getUrlImage());
        cameraSvc.save(cameraInDdbb);
        return "redirect:/home?sid="+token;
    }
    
    @RequestMapping("/camera/delete")
    public String renderDeleteCamera(int id, HttpServletRequest request, HttpServletResponse response){
        String token = request.getParameter("sid");
        User user = userSvc.findByToken(token);
        cameraSvc.deleteById(id);
        return "redirect:/home?sid="+token;
    }
    
    private User getUser(HttpServletRequest request){
        String token = request.getParameter("sid");
        return userSvc.findByToken(token);
    }
}
