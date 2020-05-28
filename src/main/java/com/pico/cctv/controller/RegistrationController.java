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
public class RegistrationController {
    
    private final UserSvc userSvc;

    public RegistrationController(UserSvc userSvc) {
        this.userSvc = userSvc;
    }
    
    @RequestMapping("/user/register")
    public String renderRegisterForm(Model model){
        UserDto userDto = new UserDto();
        model.addAttribute("userDto", userDto);
        return "register";
    }
    
    @PostMapping("/user/save")
    public String saveUser(@Valid UserDto userDto, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "register";
        }
        Hash hash = new Hash();
        User user = new User(userDto.getFullName(), userDto.getEmail(), userDto.getUsername(), hash.hash(userDto.getPassword()));
        if(userDto.getBirthDate() != null){
            user.setBirthDate(userDto.getBirthDate());
        }
        userSvc.save(user);
        return "redirect:/";
    }
    
}
