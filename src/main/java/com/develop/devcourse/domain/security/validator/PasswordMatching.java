package com.develop.devcourse.domain.security.validator;

import com.nimbusds.jose.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//@Constraint(validatedBy = Pass)
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface PasswordMatching {

    String password();

    String confirmPassword();

    String message() default "Password must match!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    @Target({ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    @interface List{
        PasswordMatching[] value();
    }
}
