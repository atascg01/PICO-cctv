/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pico.cctv.validator;

/**
 *
 * @author andre
 */
public class PasswordValidator {
    private String password;
    private String passwordConfirm;

    public PasswordValidator(String password, String passwordConfirm) {
        this.password = password;
        this.passwordConfirm = passwordConfirm;
    }
    
    public String isEmpty(){
        if(this.password.isEmpty() || this.passwordConfirm.isEmpty()){
            return "";
        }
        return "Password is empty";
    }
    
    public String passwordMatch(){
        if(this.password.equals(this.passwordConfirm)){
            return "";
        }
        return "Passwords do not match";
    }
    
}
