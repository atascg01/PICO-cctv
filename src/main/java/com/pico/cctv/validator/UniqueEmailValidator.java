/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pico.cctv.validator;

import com.pico.cctv.service.UserSvc;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author andre
 */
public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String>{

    @Autowired
    private UserSvc userSvc;
    
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value != null & !userSvc.isEmailUsed(value);
    }
    
}
