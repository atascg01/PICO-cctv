package com.pico.cctv.controller;

import com.pico.cctv.domain.Camera;
import com.pico.cctv.service.CameraSvc;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author atascg01
 */
@Controller
public class IndexController {
    
    private final CameraSvc cameraSvc;

    public IndexController(CameraSvc cameraSvc) {
        this.cameraSvc = cameraSvc;
    }
    
    @RequestMapping("/")
    public String renderIndex(Model model){
        List<Camera> cameras = cameraSvc.findCameras();
        model.addAttribute("cameras", cameras);
        return "index";
    }
}
