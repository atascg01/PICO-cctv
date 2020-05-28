/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pico.cctv.dto;

import com.pico.cctv.validator.FieldMatch;
import com.pico.cctv.validator.MinLengthPassword;
import com.pico.cctv.validator.UniqueEmail;
import com.pico.cctv.validator.UniqueUsername;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author andre
 */

@FieldMatch(first = "password", second = "confirmPassword")
public class UserDto {
    
    @NotNull
    @Size(min=2, max=30, message="Please enter a full name between 2 and 30 characters.")
    private String fullName;
    
    @NotNull
    @UniqueEmail
    private String email;
    
    @NotNull
    @UniqueUsername
    private String username;
    
    @NotNull
    @MinLengthPassword
    private String password;
    
    @NotNull 
    private String confirmPassword;
    
    private String birthDate;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "UserDto{" + "fullName=" + fullName + ", email=" + email + ", username=" + username + ", password=" + password + ", confirmPassword=" + confirmPassword + ", birthDate=" + birthDate + '}';
    }
    
}
