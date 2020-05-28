/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pico.cctv.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 * @author andre
 */
public class MinLengthPasswordValidator implements ConstraintValidator<MinLengthPassword, String>{
    
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value != null & value.length() >= 4;
    }
    
}
