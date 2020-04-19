package com.pico.cctv.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author atascg01
 */
@Controller
public class IndexController {
    
    @RequestMapping("/")
    public String renderIndex(){
        return "index";
    }
}
