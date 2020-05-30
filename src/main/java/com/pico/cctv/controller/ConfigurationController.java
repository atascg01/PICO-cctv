/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pico.cctv.controller;

import com.pico.cctv.domain.Configuration;
import com.pico.cctv.domain.User;
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
 * @author andre
 */

@Controller
public class ConfigurationController {
    
    private final ConfigurationSvc configurationSvc;
    private final UserSvc userSvc;

    public ConfigurationController(ConfigurationSvc configurationSvc, UserSvc userSvc) {
        this.configurationSvc = configurationSvc;
        this.userSvc = userSvc;
    }
    
    @RequestMapping("/configuration/new")
    public String renderNewConfiguration(Model model, HttpServletRequest request, HttpServletResponse response){
        StringBuffer url = request.getRequestURL();
        String token = request.getParameter("sid");
        User user = userSvc.findByToken(token);
        Configuration configuration = new Configuration();
        model.addAttribute("user", user);
        model.addAttribute("configuration", configuration);
        return "addConfiguration";
    }
    
    @PostMapping("/configuration/save")
    public String saveConfiguration(Configuration configuration, HttpServletRequest request, HttpServletResponse response){
        String token = request.getParameter("sid");
        User user = userSvc.findByToken(token);
        configuration.setUser(user);
        this.configurationSvc.save(configuration);
        return "redirect:/home?sid="+token;
    }
    
    @RequestMapping("/configuration/edit")
    public String renderEditConfiguration(Model model, Integer id, HttpServletRequest request, HttpServletResponse response){
        String token = request.getParameter("sid");
        User user = userSvc.findByToken(token);
        Configuration configuration = configurationSvc.findById(id);
        model.addAttribute("user", user);
        model.addAttribute("configuration", configuration);
        return "editConfiguration";
    }
    
    @RequestMapping("/configuration/edit/confirm")
    public String renderEditConfirmConfiguration(Configuration configuration, HttpServletRequest request, HttpServletResponse response){
        String token = request.getParameter("sid");
        User user = userSvc.findByToken(token);
        Configuration confInDdbb = configurationSvc.findById(configuration.getId());
        confInDdbb.setName(configuration.getName());
        confInDdbb.setResolution(configuration.getResolution());
        confInDdbb.setColor(configuration.getColor());
        configurationSvc.save(confInDdbb);
        return "redirect:/home?sid="+token;
    }
    
}
