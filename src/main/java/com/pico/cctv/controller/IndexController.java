package com.pico.cctv.controller;

import com.pico.cctv.domain.Camera;
import com.pico.cctv.domain.Configuration;
import com.pico.cctv.domain.User;
import com.pico.cctv.service.CameraSvc;
import com.pico.cctv.service.ConfigurationSvc;
import com.pico.cctv.service.UserSvc;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
    
    private final UserSvc userSvc;
    private final CameraSvc cameraSvc;
    private final ConfigurationSvc configurationSvc;
    
    public IndexController(CameraSvc cameraSvc, ConfigurationSvc configurationSvc, UserSvc userSvc) {
        this.cameraSvc = cameraSvc;
        this.configurationSvc = configurationSvc;
        this.userSvc = userSvc;
    }
    
    @RequestMapping("/home")
    public String renderIndex(Model model, HttpServletRequest request, HttpServletResponse response){
        StringBuffer url = request.getRequestURL();
        String token = request.getParameter("sid");
        User user = userSvc.findByToken(token);
        List<Camera> cameras = cameraSvc.findCamerasSorted(user);
        model.addAttribute("user", user);
        model.addAttribute("cameras", cameras);
        return "index";
    }
    
    @RequestMapping("/cameraByName")
    public String renderCameraByName(Model model, String name, HttpServletRequest request, HttpServletResponse response){
        String token = request.getParameter("sid");
        User user = userSvc.findByToken(token);
        List<Camera> cameras = cameraSvc.findByName(name, user);
        model.addAttribute("cameras", cameras);
        return "index";
    }
    
    @RequestMapping("/configuration")
    public String renderConfiguration(Model model, HttpServletRequest request, HttpServletResponse response){
        String token = request.getParameter("sid");
        User user = userSvc.findByToken(token);
        List<Configuration> configurations = configurationSvc.findConfigurations(user);
        model.addAttribute("configurations", configurations);
        return "configuration";
    }
    
    @RequestMapping("/configurationById")
    public String renderCameraByConfiguration(Model model, Integer id, HttpServletRequest request, HttpServletResponse response){
        String token = request.getParameter("sid");
        User user = userSvc.findByToken(token);
        Configuration configuration = configurationSvc.findById(id);
        model.addAttribute("user", user);
        model.addAttribute("configurations", configuration);
        return "configuration";
    }
    
    @RequestMapping("/search")
    public String search(@RequestParam("q") String query, @RequestParam("sid") String sid, Model model, HttpServletRequest request, HttpServletResponse response){
        User user = userSvc.findByToken(sid);
        List<Camera> cameras = cameraSvc.findByName(query, user);
        model.addAttribute("user", user);
        model.addAttribute("cameras", cameras);
        return "index";
    }
}
