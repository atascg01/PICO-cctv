/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pico.cctv.controller;

import com.pico.cctv.domain.Password;
import com.pico.cctv.domain.User;
import com.pico.cctv.dto.UserDto;
import com.pico.cctv.service.UserSvc;
import com.pico.cctv.validator.PasswordValidator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
        model.addAttribute("user", userDto);
        return "register";
    }
    
    @PostMapping("/user/save")
    public String saveUser(UserDto userDto){
        PasswordValidator pswdValidator = new PasswordValidator(userDto.getPassword(), userDto.getConfirmPassword());
        Password pswd = new Password();
        String output = pswdValidator.passwordMatch();
        String hash = pswd.hash(userDto.getPassword());
        User user = new User(userDto.getFullName(), userDto.getEmail(), userDto.getUsername(), hash);
        if(userDto.getBirthDate() != null){
            user.setBirthDate(userDto.getBirthDate());
        }
        userSvc.save(user);
        System.out.println(output);
        return "redirect:/";
    }
    
}
