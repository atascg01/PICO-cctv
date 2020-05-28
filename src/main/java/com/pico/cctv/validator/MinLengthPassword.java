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
import java.lang.annotation.*;
import java.lang.annotation.*;
import javax.validation.*;

@Constraint(validatedBy = MinLengthPasswordValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD })
public @interface MinLengthPassword {
    
        public final int MIN_LENGTH = 4;

	public String message() default "Password must have at least " + MIN_LENGTH + " characters.";
	
	public Class<?>[] groups() default {};
	
	public Class<? extends Payload>[] payload() default{};

}
