/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pico.cctv.controller;

import com.pico.cctv.domain.Hash;
import com.pico.cctv.domain.User;
import com.pico.cctv.dto.UserDto;
import com.pico.cctv.dto.UserLoginDto;
import com.pico.cctv.service.UserSvc;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
        UserLoginDto userLoginDto = new UserLoginDto();
        model.addAttribute("userLoginDto", userLoginDto);
        return "login";
    }
    
    @PostMapping("/user/login/validate")
    public String validateLogin(@Valid UserLoginDto userLoginDto, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "login";
        }
        return "redirect:/";
    }
}
