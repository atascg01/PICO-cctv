/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pico.cctv.controller;

import com.pico.cctv.domain.Hash;
import com.pico.cctv.domain.User;
import com.pico.cctv.dto.UserDto;
import com.pico.cctv.service.UserSvc;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author andre
 */

@Controller
public class LoginController {
    
    private final UserSvc userSvc;

    public LoginController(UserSvc userSvc) {
        this.userSvc = userSvc;
    }
    @RequestMapping("/user/login")
    public String renderLoginUser(Model model){
        UserDto userDto = new UserDto();
        model.addAttribute("userDto", userDto);
        return "login";
    }
    
    @PostMapping("/user/login/validate")
    public String validateLogin(UserDto userDto){
        String username = userDto.getUsername();
        String password = userDto.getPassword();
        User user = userSvc.findByUsername(username);
        if(user != null){
            Hash hashed = new Hash();
            String passwordLoginHashed = hashed.hash(password);
            if(passwordLoginHashed.equals(user.getPassword())){
                return "redirect:/";
            }
        }
        return "login";
    }
}
