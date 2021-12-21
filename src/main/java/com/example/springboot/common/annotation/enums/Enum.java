package com.example.springboot.common.annotation.enums;

import javax.validation.Constraint;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Constraint(validatedBy = {EnumValidator.class})
@Target({ElementType.FIELD, ElementType.PARAMETER})
public @interface Enum {
	String message() default "Invalid value. This is not permitted.";
	Class<? extends java.lang.Enum<?>> enumClass();
	boolean ignoreCase() default true;
}
