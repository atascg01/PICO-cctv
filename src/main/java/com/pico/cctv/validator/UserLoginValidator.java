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

import com.pico.cctv.domain.Hash;
import com.pico.cctv.domain.User;
import com.pico.cctv.service.UserSvc;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.apache.commons.beanutils.BeanUtils;

public class UserLoginValidator implements ConstraintValidator<UserLogin, Object> {

    private String firstFieldName;
    private String secondFieldName;
    private String message;
    private Hash hash;
    private final UserSvc userSvc;

    public UserLoginValidator(UserSvc userSvc) {
        this.userSvc = userSvc;
    }

    public void initialize(final FieldMatch constraintAnnotation) {
        firstFieldName = constraintAnnotation.first();
        secondFieldName = constraintAnnotation.second();
        message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(final Object value, final ConstraintValidatorContext context) {
        boolean valid = true;
        try
        {
            Object username = BeanUtils.getProperty(value, firstFieldName);
            Object password = BeanUtils.getProperty(value, secondFieldName);
            User user = userSvc.findByUsername(username.toString());
            String passwordHashed = hash.hash(user.getPassword());
            valid =  password.toString() == null && passwordHashed == null || password.toString() != null && password.toString().equals(passwordHashed);
        }
        catch (final Exception ignore)
        {
            // ignore
        }

        if (!valid){
            context.buildConstraintViolationWithTemplate(message)
                    .addPropertyNode(firstFieldName)
                    .addConstraintViolation()
                    .disableDefaultConstraintViolation();
        }

        return valid;
    }
}
