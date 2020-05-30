/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pico.cctv.controller;

import com.pico.cctv.domain.Hash;
import com.pico.cctv.domain.User;
import com.pico.cctv.dto.UserLoginDto;
import com.pico.cctv.security.SecureTokenGenerator;
import com.pico.cctv.service.UserSvc;
import java.security.SecureRandom;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @RequestMapping("/")
    public String renderHomeLogin() {
        //Check user logged
        return "redirect:/user/login";
    }

    @RequestMapping("/user/login")
    public String renderLoginUser(Model model) {
        UserLoginDto userLoginDto = new UserLoginDto();
        model.addAttribute("userLoginDto", userLoginDto);
        return "login";
    }

    @RequestMapping("/login")
    public String createCookie(
            @RequestParam("username") String username, @RequestParam("password") String password,
            HttpServletRequest request, HttpServletResponse response) throws SQLException {
        //code for creating the cookie here, after testing if the user is in my database
        return "login";
    }

    @PostMapping("/user/login/validate")
    public String validateLogin(UserLoginDto userLoginDto) {
        String username = userLoginDto.getUsername();
        String password = userLoginDto.getPassword();
        SecureTokenGenerator stg = new SecureTokenGenerator();
        String token = stg.nextToken();
        User user = userSvc.findByUsername(username);
        if (user != null) {
            user.setToken(token);
            userSvc.save(user);
            Hash hashed = new Hash();
            String passwordLoginHashed = hashed.hash(password);
            if (passwordLoginHashed.equals(user.getPassword())) {
                return "redirect:/home?sid=" + token;
            }
        }
        return "loginError";
    }
}
