package com.sefrinaldi.productservice.validator.contraint;

import com.sefrinaldi.productservice.validator.ProductIsExistValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Documented
@Constraint(validatedBy = {ProductIsExistValidator.class})
@Retention(RetentionPolicy.RUNTIME)
public @interface ProductCodeIsExist {

    String message() default "product code has already exists";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
